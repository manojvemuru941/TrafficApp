package com.trafficapp.api

import com.trafficapp.models.TrafficData
import retrofit2.http.GET

interface TrafficApi {

    @GET("resource/k7p9-kppz.json")
    suspend fun loadTrafficData(): ArrayList<TrafficData>
}