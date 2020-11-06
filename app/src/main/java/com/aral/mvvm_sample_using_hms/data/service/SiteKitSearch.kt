package com.aral.mvvm_sample_using_hms.data.service

import androidx.lifecycle.LiveData
import com.aral.mvvm_sample_using_hms.data.model.Place
import com.huawei.hms.site.api.model.NearbySearchRequest
import com.huawei.hms.site.api.model.Site

interface SiteKitSearch {

    fun createNearbySearchRequest(
        lat: Double,
        lng: Double
    ): NearbySearchRequest
}