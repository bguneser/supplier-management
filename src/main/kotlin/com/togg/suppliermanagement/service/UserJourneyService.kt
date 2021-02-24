package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.Dto.UserJourneyDto
import com.togg.suppliermanagement.entity.UserJourney
import org.springframework.stereotype.Service
import java.util.*

@Service
interface UserJourneyService {

    fun findUserJourneysByCompanyId(companyId : Long) : MutableList<UserJourneyDto>
    fun findUserJourneyByUserJourneyName(userjourneyName : String) : Optional<UserJourney>
}