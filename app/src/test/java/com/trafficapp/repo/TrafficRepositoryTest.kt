package com.trafficapp.repo

import com.trafficapp.Testdata.sampleResponseData
import com.trafficapp.api.TrafficApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

class TrafficRepositoryTest {

    private lateinit var trafficApi: TrafficApi
    private lateinit var repo: TrafficRepository

    @Before
    fun setUp() {
        trafficApi = Mockito.mock(TrafficApi::class.java)
        repo = TrafficRepository(trafficApi)
    }

    @Test
    fun `load traffic data success`() {
        runBlocking {
            whenever(trafficApi.loadTrafficData()).thenReturn(sampleResponseData)
            val trafficData = repo.getTrafficData()
            trafficData.collect {
                assertTrue(it.isNotEmpty())
            }
        }
    }

    @Test
    fun `load traffic data is correct`() {
        runBlocking {
            whenever(trafficApi.loadTrafficData()).thenReturn(sampleResponseData)
            val trafficData = repo.getTrafficData()
            trafficData.collect {
                assertTrue(it.containsAll(sampleResponseData))
            }
        }
    }
}