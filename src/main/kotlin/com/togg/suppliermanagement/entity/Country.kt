package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "country")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Country(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   var id: Long = -1,
                   @Column(name="country_name")
                   var countryName: String="",
                   @OneToMany(mappedBy = "country")
                   var companies: MutableList<Company> = mutableListOf()) {

}