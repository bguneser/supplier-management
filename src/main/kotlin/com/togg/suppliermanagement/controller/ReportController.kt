package com.togg.suppliermanagement.controller

import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.entity.Report
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.repo.EcosystemLayerRepository
import com.togg.suppliermanagement.service.CompanyService
import com.togg.suppliermanagement.service.EcosystemLayerService
import com.togg.suppliermanagement.service.ReportService
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
@Api(value = "Report API dokümantasyonu")
class ReportController {

    @Autowired
    lateinit var reportService: ReportService


    @GetMapping("/report",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getAllReport():  ResponseEntity<MutableList<Report>> {
        return ResponseEntity.ok(reportService.getAllReport())
    }





}