package com.togg.suppliermanagement.controller

import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.Report
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.repo.EcosystemLayerRepository
import com.togg.suppliermanagement.service.CompanyService
import com.togg.suppliermanagement.service.EcosystemLayerService
import com.togg.suppliermanagement.service.ReportService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Api(value = "Report API dokümantasyonu")
class ReportController {

    @Autowired
    lateinit var reportService: ReportService

    @GetMapping("/report")
    fun getAllReport():  ResponseEntity<MutableList<Report>> {
        return ResponseEntity.ok(reportService.getAllReport())
    }


}