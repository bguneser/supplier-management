package com.togg.suppliermanagement.Dto

import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer

class CompanyDto(
        var companyId: Long = -1,
        var companyName: String = "",
        var productDescription: String = "",
        var notes: String = "",
        var uvp: String = "",
        var companyProgression: Company.CompanyProgressionStatus? = null,
        var isNDAavailable: Boolean = false,
        var countryName: String = "null",
        var userJourneyName: String = "",
        var ecosystemLayer: EcosystemLayer = EcosystemLayer() ) {




}