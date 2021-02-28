package com.togg.suppliermanagement.Dto

import com.togg.suppliermanagement.entity.Company
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.ManyToMany

class EcosystemLayerDto(var id : Long =-1,
                        var ecosystemLayerName: String = "",
                        var companySize : Int=0){

}