package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.Dto.CompanyDto
import com.togg.suppliermanagement.Dto.UserJourneyDto
import com.togg.suppliermanagement.entity.UserJourney
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.repo.UserJourneyRepository
import com.togg.suppliermanagement.service.UserJourneyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserJourneyServiceImpl : UserJourneyService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var userJourneyRepository: UserJourneyRepository

    override fun findUserJourneysByCompanyId(companyId: Long): MutableList<UserJourneyDto> {
        val userJourneys = mutableListOf<UserJourneyDto>()
        companyRepository.findById(companyId).get().userJourneys.forEach {
            it ->
            val userJourneyDto = UserJourneyDto()
            userJourneyDto.id=it.id
            userJourneyDto.userJourneyName=it.userJourneyName

            userJourneys.add(userJourneyDto)

        }

        return userJourneys
    }

    override fun findUserJourneyByUserJourneyName(userjourneyName: String): Optional<UserJourney> {
        return userJourneyRepository.findUserJourneyByUserJourneyName(userjourneyName)
    }
}