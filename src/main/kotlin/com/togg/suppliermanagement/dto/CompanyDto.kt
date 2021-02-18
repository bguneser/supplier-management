package com.togg.suppliermanagement.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.entity.UserJourney


data class CompanyDto (var id : Long=-1,
                       var companyName : String="",
                       var productDescription : String="",
                       var notes : String="",
                       var companyProgression : Company.CompanyProgressionStatus?=null,
                       var agreementStatus : Boolean=false,
                       var ecosystemLayers:MutableSet<EcosystemLayer> = mutableSetOf(),
                       var userJourneys:MutableSet<UserJourney> = mutableSetOf()) {


}