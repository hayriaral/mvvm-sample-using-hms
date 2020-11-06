package com.aral.mvvm_sample_using_hms.data.repository

import androidx.lifecycle.LiveData
import com.aral.mvvm_sample_using_hms.data.model.Place

interface PlaceRepository {
    fun searchNearbyPlace(lat: Double, lng: Double)
    fun getPlaces(): LiveData<List<Place>>
}