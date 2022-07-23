package com.example.dogapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapp.network.ApiRequest
import com.example.dogapp.model.DogModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DogFragmentViewModel @Inject constructor(
    var apiRequest: ApiRequest
) : ViewModel() {
    val dogResponse: MutableLiveData<Response<DogModel>> = MutableLiveData()


init {
    getDogImage()
}

     fun getDogImage() {
        viewModelScope.launch {
            val response: Response<DogModel> = apiRequest.getRandomDog()
            if (response.isSuccessful) {
                dogResponse.value = response
            }
        }
    }
}