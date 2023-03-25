package com.trafficapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.trafficapp.R
import com.trafficapp.databinding.TrafficItemBinding
import com.trafficapp.models.TrafficData

class TrafficAdapter(
    private val context: Context
) : RecyclerView.Adapter<TrafficAdapter.TrafficItemViewHolder>() {

    private lateinit var listData: List<TrafficData>

    fun updateList(listData: List<TrafficData>) {
        this.listData = listData
        notifyItemRangeChanged(0, this.listData.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrafficItemViewHolder =
        TrafficItemViewHolder(
            TrafficItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            context
        )

    override fun getItemCount(): Int {
        return if (::listData.isInitialized) listData.size else 0
    }

    override fun onBindViewHolder(holder: TrafficItemViewHolder, position: Int) {
        holder.bind(listData[position])
    }


    inner class TrafficItemViewHolder(
        private val trafficItemBinding: TrafficItemBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(trafficItemBinding.root) {
        fun bind(trafficData: TrafficData) {
            Glide.with(context)
                .load(trafficData.trafficCamera.url)
                .placeholder(R.drawable.image_not_found_icon)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(trafficItemBinding.trafficImage)
            trafficItemBinding.locationText.text =
                "${trafficData.cameraLocation}, Quadrant: ${trafficData.quadrant}"
        }
    }
}