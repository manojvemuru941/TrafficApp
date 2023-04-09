package com.trafficapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.trafficapp.state.UIState
import com.trafficapp.ui.compose.DisplayTrafficData
import com.trafficapp.ui.compose.EmptyState
import com.trafficapp.ui.compose.ErrorDialog

class TrafficComposeFragment : Fragment() {

    companion object {
        fun newInstance() = TrafficComposeFragment()
    }

    private val viewModel: TrafficViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(
                    viewLifecycleOwner
                )
            )
            setContent {
                MaterialTheme {
                    DisplayLocalTraffic()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

    @Composable
    fun DisplayLocalTraffic() {
        Column(
            Modifier
                .background(color = Color.White)
        ) {
            when (val state = viewModel.uiState.collectAsState().value) {
                is UIState.Loading ->
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                    }
                is UIState.Error -> {
                    EmptyState { viewModel.loadData() }
                    ErrorDialog(
                        message = state.throwable.message.orEmpty(),
                        positiveOnclick = { viewModel.loadData() },
                        negativeOnclick = { }
                    )
                }
                is UIState.Success -> {
                    if(state.data.isEmpty()) EmptyState() { viewModel.loadData() }
                    DisplayTrafficData(state.data)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        DisplayLocalTraffic()
    }
}