package com.trafficapp.usecase

import com.trafficapp.models.TrafficData
import com.trafficapp.repo.TrafficRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrafficUseCase @Inject constructor(
    private val trafficRepository: TrafficRepository
) {
    private val customOrder = listOf("NW", "NE", "SW", "SE")
    /**
     * Action func to generate Traffic API data
     *
     * @return
     */
    suspend fun getAction(): Flow<List<TrafficData>> {
        return trafficRepository.getTrafficData().map { trafficRepository ->
            val sortedData = trafficRepository.filter { customOrder.contains(it.quadrant) }
                .sortedWith(compareBy({ customOrder.indexOf(it.quadrant) }, { it.cameraLocation })
            )
            sortedData
        }
    }
}