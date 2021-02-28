package com.togg.suppliermanagement.controller

import com.togg.suppliermanagement.Dto.EcosystemLayerDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.service.EcosystemLayerService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
@Api(value = "Ecosystem Layer  API dokümantasyonu")
class EcosystemLayerController {

    @Autowired
    lateinit var ecosystemLayerService: EcosystemLayerService

    @GetMapping("/ecosystemlayers",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "EcosystemLayer listesi metodu", notes = "Bu metod tüm ecosystemLayer getirir")
    fun retrieveEcosystemLayers() : ResponseEntity<MutableList<EcosystemLayerDto>> {
        return ResponseEntity.ok(ecosystemLayerService.retrieveAllEcosystemLayers())
    }

    @PostMapping(value = arrayOf("/saveEcosystemLayer"),produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Yeni Ecosystem Ekleme metodu", notes = "Geriye eklediğin ecosystem'i döndürecek")
    fun saveCompany(@RequestBody ecosystemLayer: EcosystemLayerDto): ResponseEntity<EcosystemLayerDto> {
        return ResponseEntity.ok(ecosystemLayerService.saveEcosystemLayer(ecosystemLayer))
    }

    @GetMapping("/getEcosystemLayerByEcosystemLayerId/{ecosystemLayerId}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Id'ye göre ecosystemLayer getirir", notes = "Id'ye göre ecosystemLayer getirir")
    fun findEcosystemLayerByEcosystemLayerId(@PathVariable("ecosystemLayerId") ecosystemLayerId :Long ): EcosystemLayerDto{
        return ecosystemLayerService.findEcosystemLayerByEcosystemLayerId(ecosystemLayerId)
    }

    @PutMapping ("/updateEcosystemLayer/{ecosysystemLayerId}")
    fun updateCompany(@RequestBody ecosystemLayer: EcosystemLayer , @PathVariable ecosysystemLayerId:Long): EcosystemLayer {
        return ecosystemLayerService.updateEcosystemLayer(ecosystemLayer,ecosysystemLayerId)
    }

    @GetMapping("/findEcosystemplatformIdsByCompanyId/{companyId}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun findEcosystemIdsByCompanyId(@PathVariable("companyId") companyId: Long) : ResponseEntity<MutableList<Long>> {
        return ResponseEntity.ok(ecosystemLayerService.findEcosystemIdsByCompanyId(companyId))
    }

    @GetMapping("/findEcosystemLayerByEcosystemLayerName/{ecosystemLayerName}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "EcosystemLayer ismine göre ecosystemLayer'a ait bilgileri getirir", notes = " EcosystemLayer ismine göre ecosystemLayer'a ait bilgileri getirir")
    fun findByEcosystemLayerName(@PathVariable("ecosystemLayerName") ecosystemLayerName :String ): Optional<EcosystemLayer> {
        return ecosystemLayerService.findByEcosystemLayerName(ecosystemLayerName)
    }





}