package com.trafficapp.viewmodel

import com.trafficapp.Testdata.sampleResponseData
import com.trafficapp.models.TrafficData
import com.trafficapp.state.UIState
import com.trafficapp.ui.TrafficViewModel
import com.trafficapp.usecase.TrafficUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class TrafficViewModelTest {

    private var trafficUseCase: TrafficUseCase = Mockito.mock(TrafficUseCase::class.java)
    private lateinit var trafficViewModel: TrafficViewModel

    @Before
    fun setUp() {
        trafficViewModel = TrafficViewModel(trafficUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `load traffic success`() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)
        whenever(trafficUseCase.getAction()).thenReturn(flowOf(sampleResponseData))
        trafficViewModel.loadData()
        assertTrue((trafficViewModel.uiState.value as UIState.Success<List<TrafficData>>).data.isNotEmpty())
        Dispatchers.resetMain()
    }
}