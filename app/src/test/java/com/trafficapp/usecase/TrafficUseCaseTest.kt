package com.trafficapp.usecase

import com.trafficapp.Testdata.sampleResponseData
import com.trafficapp.Testdata.sortedData
import com.trafficapp.api.TrafficApi
import com.trafficapp.repo.TrafficRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

class TrafficUseCaseTest {

    private lateinit var trafficApi: TrafficApi
    private lateinit var trafficUseCase: TrafficUseCase
    private lateinit var repo: TrafficRepository

    @Before
    fun setUp() {
        trafficApi = Mockito.mock(TrafficApi::class.java)
        repo = TrafficRepository(trafficApi)
        trafficUseCase = TrafficUseCase(repo)

    }

    @Test
    fun `load traffic data success`() {
        runBlocking {
            whenever(trafficApi.loadTrafficData()).thenReturn(sampleResponseData)
            val trafficData = trafficUseCase.getAction()
            trafficData.collect {
                assertTrue(it.isNotEmpty())
            }
        }
    }

    @Test
    fun `load traffic data and sorted`() {
        runBlocking {
            whenever(trafficApi.loadTrafficData()).thenReturn(sampleResponseData)
            val trafficData = trafficUseCase.getAction()
            trafficData.collect {
                assertTrue(it == sortedData)
            }
        }
    }
}