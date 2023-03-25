package com.trafficapp.models

import com.google.gson.annotations.SerializedName

data class TrafficCamera(
    @SerializedName("url")
    val url: String,

    @SerializedName("description")
    val description: String
)