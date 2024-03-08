package com.example.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.FirebaseRepositoryImpl
import com.example.demo.data.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainActivityViewModel(val repository: FirebaseRepositoryImpl) : ViewModel() {
    // Create a StateFlow with an initial value of DataState.Loading
    private val _state = MutableStateFlow<UiState<Response>>(UiState.Loading)
    val state: StateFlow<UiState<Response>> = _state

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                repository.getData().collect { response ->
                    _state.value = UiState.Success(response)
                }
            } catch (e: Exception) {
                _state.value = UiState.Error(e)
            }
        }
    }
}

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val exception: Exception) : UiState<Nothing>()
}









