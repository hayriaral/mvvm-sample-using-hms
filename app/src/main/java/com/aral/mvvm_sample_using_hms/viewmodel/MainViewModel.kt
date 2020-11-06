package com.aral.mvvm_sample_using_hms.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.aral.mvvm_sample_using_hms.data.model.Place
import com.aral.mvvm_sample_using_hms.data.repository.PlaceRepository
import com.aral.mvvm_sample_using_hms.data.repository.PlaceRepositoryImpl
import com.aral.mvvm_sample_using_hms.util.Constant

class MainViewModel(private val repository: PlaceRepository = PlaceRepositoryImpl()) : ViewModel() {

    private val allPlaces = MediatorLiveData<List<Place>>()

    init {
        getAllPlaces()
    }

    fun getCurrentPlaces() = allPlaces

    private fun getAllPlaces() {
        repository.searchNearbyPlace(Constant.mockDataLat, Constant.mockDataLng)
        allPlaces.addSource(repository.getPlaces()) { places ->
            allPlaces.postValue(places)
        }
    }
}