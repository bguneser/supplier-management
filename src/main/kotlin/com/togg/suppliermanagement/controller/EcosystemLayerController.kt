package com.togg.suppliermanagement.controller

import com.togg.suppliermanagement.Dto.EcoSystemLayerDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.repo.EcosystemLayerRepository
import com.togg.suppliermanagement.service.CompanyService
import com.togg.suppliermanagement.service.EcosystemLayerService
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
@Api(value = "Ecosystem Layer  API dokümantasyonu")
class EcosystemLayerController {

    @Autowired
    lateinit var ecosystemLayerService: EcosystemLayerService

    @GetMapping("/findEcosystemplatformIdsByCompanyId/{companyId}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun findEcosystemIdsByCompanyId(@PathVariable("companyId") companyId: Long) : ResponseEntity<MutableList<Long>> {
        return ResponseEntity.ok(ecosystemLayerService.findEcosystemIdsByCompanyId(companyId))
    }

    @GetMapping("/findEcosystemLayerByEcosystemLayerName/{ecosystemLayerName}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "EcosystemLayer ismine göre ecosystemLayer'a ait bilgileri getirir", notes = " EcosystemLayer ismine göre ecosystemLayer'a ait bilgileri getirir")
    fun findByEcosystemLayerName(@PathVariable("ecosystemLayerName") ecosystemLayerName :String ): Optional<EcosystemLayer> {
        return ecosystemLayerService.findByEcosystemLayerName(ecosystemLayerName)
    }

    @GetMapping("/ecosystemlayers",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "EcosystemLayer listesi metodu", notes = "Bu metod tüm ecosystemLayer getirir")
    fun retrieveEcosystemLayers() : ResponseEntity<MutableList<EcoSystemLayerDto>> {
        return ResponseEntity.ok(ecosystemLayerService.retrieveAllEcosystemLayers())
    }



}