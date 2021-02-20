package com.togg.suppliermanagement.controller


import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.repo.CompanyRepository
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
    fun saveCompany(@RequestBody company: Company): ResponseEntity<Company> {
        return ResponseEntity.ok(companyService.saveCompany(company))
    }

    @GetMapping("/{companyName}")
    @ApiOperation(value = "Company ismine göre company'e ait bilgileri getirir", notes = "Company ismine göre company'e ait bilgileri getirir")
    fun findByCompanyName(@PathVariable("companyName") companyName :String ): Optional<Company> {
        return companyService.findByCompanyName(companyName)
    }

    @GetMapping("/company/{id}")
    @ApiOperation(value = "Id'ye göre company getirir", notes = "Id'ye göre company getirir")
    fun findById(@PathVariable("id") id :Long ): Optional<Company> {
        return companyService.findById(id)
    }



}