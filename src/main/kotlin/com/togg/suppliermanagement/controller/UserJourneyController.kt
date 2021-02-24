package com.togg.suppliermanagement.controller

import com.togg.suppliermanagement.Dto.UserJourneyDto
import com.togg.suppliermanagement.entity.UserJourney
import com.togg.suppliermanagement.service.UserJourneyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
@Api(value = "UserJourney API dokümantasyonu")
class UserJourneyController {

    @Autowired
    lateinit var userJournerService: UserJourneyService

    @GetMapping("/userJourneysByCompanyId/{companyId}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Ecosystem Id'sine göre companyleri getirir", notes = "Ecosystem Id'sine göre companyleri getirir")
    fun getUserJournesByCompanyId(@PathVariable("companyId") companyId : Long) : ResponseEntity<MutableList<UserJourneyDto>> {
        return ResponseEntity.ok(userJournerService.findUserJourneysByCompanyId(companyId))
    }

    @GetMapping("/userjourney/{userJourneyName}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Userjourney ismine göre userjorney'e ait bilgileri getirir", notes = "Userjourney ismine göre userjorney'e ait bilgileri getirir")
    fun findUserJourneyByUserjourneyName(@PathVariable("userJourneyName") userJourneyName :String ): Optional<UserJourney> {
        return userJournerService.findUserJourneyByUserJourneyName(userJourneyName)
    }
}