package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "ecosystem_layer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class,property = "id")
@JsonIgnoreProperties(value = arrayOf("companies"))
data class EcosystemLayer(@Id
                          @GeneratedValue(strategy = GenerationType.IDENTITY)
                          var id : Long=-1,

                          @Column(name = "ecosystem_layer_name", unique = true)
                          var ecosystemLayerName: String = "",

                          @OneToMany(mappedBy = "ecosystemLayer",targetEntity=Company::class,cascade = arrayOf(CascadeType.PERSIST, CascadeType.DETACH, /*CascadeType.MERGE,*/ CascadeType.REFRESH))
                          var companies : MutableList<Company> = mutableListOf()) : Serializable {


    override fun toString(): String {
        return "{ecosystemLayers : ${this.ecosystemLayerName}, companies: ${companies.map { it->it.companyName }}}"
    }

}