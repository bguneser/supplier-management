package com.togg.suppliermanagement.repo

import com.togg.suppliermanagement.entity.UserJourney
import org.apache.catalina.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import java.util.*

interface UserJourneyRepository  : JpaRepository<UserJourney,Long>{

    fun findUserJourneyByUserJourneyName(userjourneyName : String) : Optional<UserJourney>

}