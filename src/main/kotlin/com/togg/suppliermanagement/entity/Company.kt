package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "company")
@JsonIgnoreProperties("hibernateLazyInitializer", "handler",  "ecosystemLayers" ,"userJourneys")
data class Company(@Id
                   @SequenceGenerator(name = "seq_company_id", allocationSize = 1)
                   @GeneratedValue(generator = "seq_company_id", strategy = GenerationType.SEQUENCE)
                   var id: Long = -1,
                   @Column(name = "company_name",unique = true)
                   @NotBlank(message = "Company name can't be blank")
                   var companyName: String = "",
                   @Column(name = "product_description")
                   var productDescription: String = "",
                   @Column(name = "notes") var notes: String = "",
                   @Enumerated var companyProgression: CompanyProgressionStatus? = null,
                   @Column(name = "agreement_status") var agreementStatus: Boolean = false,
                   @ManyToMany(fetch = FetchType.LAZY,cascade = arrayOf(CascadeType.ALL))
                   @JoinTable( name = "company_ecosystemlayers",
                           joinColumns = [JoinColumn(name = "company_id",referencedColumnName = "id")],
                           inverseJoinColumns = [JoinColumn(name = "ecosystemlayer_id",referencedColumnName = "id")])
                   var ecosystemLayers: MutableSet<EcosystemLayer> = mutableSetOf(),
                   @ManyToMany(fetch = FetchType.LAZY,cascade = arrayOf(CascadeType.ALL))
                   @JoinTable( name = "company_userjourney",
                           joinColumns = [JoinColumn(name = "company_id",referencedColumnName = "id")],
                           inverseJoinColumns = [JoinColumn(name = "userjorney_id",referencedColumnName = "id")])
                   var userJourneys: MutableSet<UserJourney> = mutableSetOf()) : Serializable {

    enum class CompanyProgressionStatus {
        REJECT, NoTouch, Collaboration, Rejected, FirstMeeting, SecondMeeting, Finalized
    }

    override fun toString(): String {
        return "{company:${this.companyName},ecosystemLayers: ${ecosystemLayers.map { it->it.ecosystemLayerName }}}"
    }

}