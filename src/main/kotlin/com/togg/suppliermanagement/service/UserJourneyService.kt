package com.togg.suppliermanagement.service

import org.springframework.stereotype.Service

@Service
interface UserJourneyService {

    fun findUserJourneysByCompaniesCompanyId(companyId : Long)
}