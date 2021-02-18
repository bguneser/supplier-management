package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "ecosystem_layer")
@JsonIgnoreProperties("hibernateLazyInitializer", "handler",  "companies")
data class EcosystemLayer(@Id
                           @SequenceGenerator(name = "seq_company_ecosystemLayer",allocationSize = 1)
                           @GeneratedValue(generator = "seq_company_ecosystemLayer",strategy = GenerationType.SEQUENCE) var id : Long =-1,
                          @Column(name = "ecosystem_layer_name") var ecosystemLayerName: String = "",
                          @ManyToMany(fetch = FetchType.LAZY,cascade = arrayOf(CascadeType.ALL), mappedBy = "ecosystemLayers")
                          var companies : MutableSet<Company> = mutableSetOf<Company>()) : Serializable {


    override fun toString(): String {
        return "{ecosystemLayers : ${this.ecosystemLayerName}, companies: ${companies.map { it->it.companyName }}}"
    }

}