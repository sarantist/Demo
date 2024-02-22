package com.example.demo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.FirebaseRepository
import com.example.demo.data.Response
import kotlinx.coroutines.launch


class MainActivityViewModel(val repository: FirebaseRepository) : ViewModel() {
    var state: MutableState<DataState<Response>> = mutableStateOf(DataState.Loading)
        private set


    init {
        getData()
    }

    private fun getData() = viewModelScope.launch {
        try {
            repository.getData().collect { response ->
               state.value = DataState.Success(response)
            }
        } catch (e: Exception) {
            state.value = DataState.Error(e)
        }
    }
}

sealed class DataState<out T> {
    object Loading : DataState<Nothing>()
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
}









