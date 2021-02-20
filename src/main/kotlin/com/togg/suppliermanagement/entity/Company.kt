package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "company")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Company(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   var id: Long = -1,

                   @Column(name = "company_name", unique = true)
                   @NotBlank(message = "Company name can't be blank")
                   var companyName: String = "",

                   @Column(name = "product_description")
                   var productDescription: String = "",

                   @Column(name = "notes")
                   var notes: String = "",

                   @Column(name ="uvp")
                   var uvp : String ="",

                   @Enumerated
                   @Column(name = "company_progression")
                   var companyProgression: CompanyProgressionStatus? = null,

                   @Column(name = "is_nda_available")
                   var isNDAavailable: Boolean = false,

                   @ManyToMany(targetEntity = EcosystemLayer::class,cascade = arrayOf(CascadeType.ALL))
                   var ecosystemLayers: MutableList<EcosystemLayer> = mutableListOf(),

                   @ManyToMany(targetEntity = UserJourney::class, cascade = arrayOf(CascadeType.ALL))
                   var userJourneys: MutableList<UserJourney> = mutableListOf()) : Serializable {

    companion object {

       fun getCompanyProgressionStatusById(id: Long?): CompanyProgressionStatus? {
            for (e in CompanyProgressionStatus.values()) {
                if (e.id.equals(id)) return e
            }
            return CompanyProgressionStatus.UNKNOWN
        }
    }

    enum class CompanyProgressionStatus(var id: Long, var statusName: String) {
        REJECT(1,"REJECT"),
        NoTouch(2,"NoTouch"),
        Collaboration(3,"Collaboration"),
        Rejected( 4,"Rejected"),
        FirstMeeting( 5,"FirstMeeting"),
        SecondMeeting(6,"SecondMeeting"),
        Finalized(7,"Finalized"),
        UNKNOWN(8,"UNKNOWN")


    }


    override fun toString(): String {
        return "{company:${this.companyName},ecosystemLayers: ${ecosystemLayers.map { it->it.ecosystemLayerName }}}"
    }



}