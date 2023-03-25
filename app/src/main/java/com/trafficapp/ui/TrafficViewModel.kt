package com.trafficapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trafficapp.api.TrafficApi
import com.trafficapp.models.TrafficData
import com.trafficapp.repo.TrafficRepository
import com.trafficapp.state.UIState
import com.trafficapp.usecase.TrafficUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrafficViewModel @Inject constructor(
    private val trafficUseCase: TrafficUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState<List<TrafficData>>>(UIState.Loading)
    val uiState: StateFlow<UIState<List<TrafficData>>> = _uiState

    fun loadData() {
        viewModelScope.launch {
            trafficUseCase.getAction()
                .flowOn(Dispatchers.IO)
                .onStart {
                    _uiState.value = UIState.Loading
                }
                .catch {
                    //show error
                    _uiState.value = UIState.Error(it)
                }
                .collect {
                    _uiState.value = UIState.Success(it)
                }
        }
    }
}