package com.togg.suppliermanagement.controller

import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.repo.EcosystemLayerRepository
import com.togg.suppliermanagement.service.CompanyService
import com.togg.suppliermanagement.service.EcosystemLayerService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Api(value = "Ecosystem Layer  API dokümantasyonu")
class EcosystemLayerController {

    @Autowired
    lateinit var ecosystemLayerService: EcosystemLayerService

    @GetMapping("/findEcosystemplatformIds/{companyId}")
    fun findEcosystemIdsByCompanyId(@PathVariable("companyId") companyId: Long) : ResponseEntity<MutableList<Long>> {
        return ResponseEntity.ok(ecosystemLayerService.findEcosystemIdsByCompanyId(companyId))
    }



}