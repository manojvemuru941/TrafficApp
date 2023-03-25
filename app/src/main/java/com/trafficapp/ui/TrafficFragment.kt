package com.trafficapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fair.weather.ui.main.ext.hide
import com.fair.weather.ui.main.ext.show
import com.trafficapp.R
import com.trafficapp.databinding.FragmentTrafficBinding
import com.trafficapp.state.UIState
import com.trafficapp.ui.adapter.TrafficAdapter

class TrafficFragment : Fragment() {
    companion object {
        fun newInstance() = TrafficFragment()
    }

    private val viewModel: TrafficViewModel by activityViewModels()
    private lateinit var binding: FragmentTrafficBinding
    private lateinit var adapter:TrafficAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrafficBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TrafficAdapter(requireActivity())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadData()

        lifecycleScope.launchWhenResumed {
            viewModel.uiState.collect { state ->
                when (state) {
                    is UIState.Success -> {
                        binding.loading.hide()
                        adapter.updateList(state.data)
                    }
                    is UIState.Error -> {
                        binding.loading.hide()
                        showErrorDialog(
                            state.throwable.message ?: getString(R.string.something_went_wrong)
                        )
                    }
                    is UIState.Loading -> {
                        binding.loading.show()
                    }
                }
            }
        }
    }

    private fun showErrorDialog(err: String) {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(err)
            builder.apply {
                setPositiveButton(
                    R.string.ok
                ) { _, _ ->
                    // User clicked OK button
                }
            }

            // Create the AlertDialog
            builder.create()
        }
        alertDialog?.show()
    }
}