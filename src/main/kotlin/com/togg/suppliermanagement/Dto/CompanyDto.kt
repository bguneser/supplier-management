package com.togg.suppliermanagement.Dto

import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.Country
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.entity.UserJourney
import javax.persistence.*
import javax.validation.constraints.NotBlank

class CompanyDto(
            var companyId : Long = -1,
                   var companyName: String = "",
                   var productDescription: String = "",
                   var notes: String = "",
                   var uvp: String ="",
                   var companyProgression: Company.CompanyProgressionStatus? = null,
                   var isNDAavailable: Boolean = false,
                   var countryName: String = "null") {
}