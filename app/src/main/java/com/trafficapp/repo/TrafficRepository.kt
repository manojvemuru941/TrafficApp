package com.trafficapp.repo

import com.trafficapp.api.TrafficApi
import com.trafficapp.models.TrafficData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrafficRepository @Inject constructor(
    private val trafficApi: TrafficApi
) {

    suspend fun getTrafficData(): Flow<List<TrafficData>> {
        return flow { emit(trafficApi.loadTrafficData()) }
    }
}