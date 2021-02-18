package com.togg.suppliermanagement.controller

import com.togg.suppliermanagement.dto.CompanyDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.service.CompanyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
@Api(value = "Company API dokümantasyonu")
class CompanyController {

    @Autowired
    lateinit var companyService: CompanyService

    @GetMapping("/companies")
    @ApiOperation(value = "Company listesi metodu", notes = "Bu metod tüm companyleri getirir")
    fun retrieveAllCompanies() : ResponseEntity<MutableList<Company>> {
        return ResponseEntity.ok(companyService.retrieveAllCompanies())
    }

    @PostMapping("/saveCompany")
    @ApiOperation(value = "Yeni Company Ekleme metodu", notes = "Geriye eklediğin company'i döndürecek")
    fun saveCompany(@RequestBody companyDto: CompanyDto): ResponseEntity<CompanyDto> {
        return ResponseEntity.ok(companyService.saveCompany(companyDto))
    }

    @GetMapping("/{companyName}")
    @ApiOperation(value = "Company ismine göre company'e ait bilgileri getirir", notes = "Company ismine göre company'e ait bilgileri getirir")
    fun findByComPanyName(@PathVariable("companyName") companyName :String ): Optional<Company> {
        return companyService.findByCompanyName(companyName)
    }


}