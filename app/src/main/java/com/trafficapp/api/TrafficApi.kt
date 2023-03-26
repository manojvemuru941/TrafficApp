package com.trafficapp.api

import com.trafficapp.core.AppConstants
import com.trafficapp.models.TrafficData
import retrofit2.http.GET

interface TrafficApi {

    @GET(AppConstants.TRAFFIC_URL)
    suspend fun loadTrafficData(): ArrayList<TrafficData>
}