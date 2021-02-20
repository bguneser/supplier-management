package com.togg.suppliermanagement.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user_journey")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class,property = "id")
class UserJourney(@Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Long,

                  @Column(name = "user_journey_name") var userJourneyName: String = "",
                  @ManyToMany(targetEntity=Company::class,cascade = arrayOf(CascadeType.ALL),mappedBy = "userJourneys")
                  var companies : MutableList<Company> = mutableListOf()) : Serializable {

    override fun toString(): String {
        return "{userJourneys : ${this.userJourneyName}, companies: ${companies.map { it->it.companyName }}}"
    }
}