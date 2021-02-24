package com.togg.suppliermanagement.controller


import com.togg.suppliermanagement.Dto.CompanyDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.service.CompanyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = arrayOf("/api"))
@Api(value = "Company API dokümantasyonu")
class CompanyController {

    @Autowired
    lateinit var companyService: CompanyService

    @GetMapping("/companies",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Company listesi metodu", notes = "Bu metod tüm companyleri getirir")
    fun retrieveAllCompanies() : ResponseEntity<MutableList<Company>> {
        return ResponseEntity.ok(companyService.retrieveAllCompanies())
    }

    @PostMapping(value = arrayOf("/saveCompany"),produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Yeni Company Ekleme metodu", notes = "Geriye eklediğin company'i döndürecek")
    fun saveCompany(@RequestBody company: Company): ResponseEntity<Company> {
        return ResponseEntity.ok(companyService.saveCompany(company))
    }

    @GetMapping("/getCompanyByCompanyName/{companyName}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Company ismine göre company'e ait bilgileri getirir", notes = "Company ismine göre company'e ait bilgileri getirir")
    fun findByCompanyName(@PathVariable("companyName") companyName :String ): Optional<Company> {
        return companyService.findByCompanyName(companyName)
    }

    @GetMapping("/getCompanyByCompanyId/{companyId}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Id'ye göre company getirir", notes = "Id'ye göre company getirir")
    fun findCompanyByCompanyId(@PathVariable("companyId") companyId :Long ): CompanyDto {
        return companyService.findCompanyByCompanyId(companyId)
    }

    @GetMapping("/deleteCompanyByCompanyId/{companyId}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Id'ye göre company'i siler", notes = "Id'ye göre company'i siler")
    fun deleteById(@PathVariable("companyId") companyId :Long ):CompanyDto {
        return companyService.deleteCompany(companyId)
    }

    @GetMapping("/getCompaniesByEcosystemLayerId/{ecosystemLayerId}",produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ApiOperation(value = "Ecosystem Id'sine göre companyleri getirir", notes = "Ecosystem Id'sine göre companyleri getirir")
    fun getCompaniesByEcosystemLayerId(@PathVariable("ecosystemLayerId") ecosystemLayerId : Long) : ResponseEntity<MutableList<CompanyDto>> {
        return ResponseEntity.ok(companyService.getCompaniesByEcosystemLayerId(ecosystemLayerId))
    }



}