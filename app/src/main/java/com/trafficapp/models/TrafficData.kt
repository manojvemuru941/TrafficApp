package com.trafficapp.models

import com.google.gson.annotations.SerializedName

data class TrafficData(
    @SerializedName("quadrant")
    val quadrant: String,

    @SerializedName("camera_url")
    val trafficCamera: TrafficCamera,

    @SerializedName("camera_location")
    val cameraLocation: String
)
