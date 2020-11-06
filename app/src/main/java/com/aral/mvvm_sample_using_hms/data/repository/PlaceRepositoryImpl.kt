package com.aral.mvvm_sample_using_hms.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aral.mvvm_sample_using_hms.App
import com.aral.mvvm_sample_using_hms.data.model.Place
import com.aral.mvvm_sample_using_hms.data.service.SiteKitClient
import com.huawei.hms.site.api.SearchResultListener
import com.huawei.hms.site.api.model.NearbySearchResponse
import com.huawei.hms.site.api.model.SearchStatus
import com.huawei.hms.site.api.model.Site

class PlaceRepositoryImpl : PlaceRepository {
    private val siteKitClient = SiteKitClient()
    private val places: MutableList<Place> = mutableListOf()
    private val placesLiveData = MutableLiveData<List<Place>>()

    private fun convertToPlace(site: Site) {
        val place = Place(
            site.getSiteId(),
            site.getName(),
            site.getFormatAddress(),
            site.getAddress(),
            site.getLocation()
        )
        places.add(place)
        placesLiveData.value = places
    }

    //Create nearby search result listener & Call the nearby place search API.
    override fun searchNearbyPlace(lat: Double, lng: Double) {

        siteKitClient.getSearchServiceInstance()
            ?.nearbySearch(
                siteKitClient.createNearbySearchRequest(lat, lng),
                object : SearchResultListener<NearbySearchResponse> {
                    override fun onSearchResult(nearbySearchResponse: NearbySearchResponse?) {
                        val sites: List<Site> = nearbySearchResponse!!.getSites()
                        for (site in sites) {
                            convertToPlace(site)
                        }
                        Log.i(
                            "PlaceRepository",
                            "NearbySearch onSearchResult: Total site " + nearbySearchResponse.totalCount
                        )
                    }

                    override fun onSearchError(searchStatus: SearchStatus?) {
                        Log.e(
                            "PlaceRepository",
                            "NearbySearch onSearchError: Error code is " + searchStatus!!.getErrorCode()
                        )
                    }

                })
    }

    override fun getPlaces(): LiveData<List<Place>> {
        return placesLiveData
    }
}