package com.aral.mvvm_sample_using_hms.data.service

import android.content.Context
import com.aral.mvvm_sample_using_hms.App
import com.aral.mvvm_sample_using_hms.util.Constant
import com.huawei.hms.site.api.SearchService
import com.huawei.hms.site.api.SearchServiceFactory
import com.huawei.hms.site.api.model.*
import java.net.URLEncoder

class SiteKitClient : SiteKitSearch {

    fun getSearchServiceInstance(): SearchService? {
        // Instantiate the SearchService object.
        return SearchServiceFactory.create(
            App.context,
            URLEncoder.encode(Constant.API_key, "utf-8")
        )

    }

    //Create a nearby search request body.
    override fun createNearbySearchRequest(
        lat: Double,
        lng: Double
    ): NearbySearchRequest {
        //Location is mandatory and others are optional
        var nearbySearchRequest = NearbySearchRequest()

        //Current location of a user.
        nearbySearchRequest.setLocation(Coordinate(lat, lng))

        //The search radius is used to specify an area where places are searched in priority,
        // but not restrict the search result to this area.
        //The value ranges from 1 to 50000.
        nearbySearchRequest.setRadius(3500)

        //Huawei Point of Interest type of returned places.
        nearbySearchRequest.setHwPoiType(HwLocationType.RESTAURANT)

        //Number of records on each page. The value ranges from 1 to 20.
        nearbySearchRequest.setPageSize(10)

        //Current page number. The value ranges from 1 to 60
        nearbySearchRequest.setPageIndex(1)

        //Language in which search results are displayed
        nearbySearchRequest.setLanguage("en");

        return nearbySearchRequest
    }
}