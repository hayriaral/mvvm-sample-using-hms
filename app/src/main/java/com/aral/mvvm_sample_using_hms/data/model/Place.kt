package com.aral.mvvm_sample_using_hms.data.model

import com.huawei.hms.site.api.model.AddressDetail
import com.huawei.hms.site.api.model.Coordinate

data class Place(
    var siteId: String? = null,
    var name: String? = null,
    var address: String? = null,
    var addressDetail: AddressDetail? = null,
    var location: Coordinate? = null,
)