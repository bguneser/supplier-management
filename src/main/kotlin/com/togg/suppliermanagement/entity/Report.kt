package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators

class Report(var companyName: String="",
                  var ecosystemLayerName : String="",
                  var notes : String ="",
                  var uvp : String ="" ,
                  var companyProgression : String ="" ,
                  var isNDAavailable: Boolean = false,
                  var productDescription: String = "")