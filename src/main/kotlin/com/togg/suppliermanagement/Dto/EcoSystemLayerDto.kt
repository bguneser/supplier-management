package com.togg.suppliermanagement.Dto

import com.togg.suppliermanagement.entity.Company
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.ManyToMany

class EcoSystemLayerDto(var id : Long =-1 , var ecosystemLayerName: String = "",
                        var companySize : Long = -1,
                        var companies : MutableList<CompanyDto> = mutableListOf() ){

}