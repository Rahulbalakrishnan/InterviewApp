package com.example.openinapp.data.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.openinapp.data.api.models.OpenInAppResponse
import com.example.openinapp.data.api.repository.OpenInAppRepository
import javax.inject.Inject

// TODO [COMPLETED] -> The View Model.


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: OpenInAppRepository
): ViewModel() {

    private val _results = MutableStateFlow<Resource<OpenInAppResponse>?>(null)
    val results:StateFlow<Resource<OpenInAppResponse>?> = _results
    init {
        viewModelScope.launch {
            _results.value = Resource.Loading
            _results.value = repository.getOpenInAppResponse()
        }
    }


}