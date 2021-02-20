package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "ecosystem_layer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class,property = "id")
data class EcosystemLayer(@Id
                          @GeneratedValue(strategy = GenerationType.IDENTITY)
                          var id : Long=-1,

                          @Column(name = "ecosystem_layer_name")
                          var ecosystemLayerName: String = "",

                          @ManyToMany(targetEntity=Company::class,cascade = arrayOf(CascadeType.ALL),mappedBy = "ecosystemLayers")
                          var companies : MutableList<Company> = mutableListOf()) : Serializable {


    override fun toString(): String {
        return "{ecosystemLayers : ${this.ecosystemLayerName}, companies: ${companies.map { it->it.companyName }}}"
    }

}