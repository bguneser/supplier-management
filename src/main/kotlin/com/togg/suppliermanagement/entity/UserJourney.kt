package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user_journey")
@JsonIgnoreProperties("hibernateLazyInitializer", "handler",  "companies")
class UserJourney(@Id
                  @SequenceGenerator(name = "seq_userjourney_id", allocationSize = 1)
                  @GeneratedValue(generator = "seq_userjourney_id", strategy = GenerationType.SEQUENCE)
                  var id: Long = -1,
                  @Column(name = "user_journey_name") var userJourneyName: String = "",
                  @ManyToMany(fetch = FetchType.LAZY,cascade = arrayOf(CascadeType.ALL), mappedBy = "userJourneys")
                  var companies : MutableSet<Company> = mutableSetOf<Company>()) : Serializable {

    override fun toString(): String {
        return "{userJourneys : ${this.userJourneyName}, companies: ${companies.map { it->it.companyName }}}"
    }
}