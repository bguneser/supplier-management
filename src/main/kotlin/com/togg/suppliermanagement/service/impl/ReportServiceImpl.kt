package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.Report
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.service.EcosystemLayerService
import com.togg.suppliermanagement.service.ReportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ReportServiceImpl : ReportService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var ecosystemLayerService: EcosystemLayerService


    override fun getAllReport() : MutableList<Report> {

        val reportList= mutableListOf<Report>()
        companyRepository.findAll().forEach {
            company ->
            ecosystemLayerService.findEcosystemIdsByCompanyId(company.id).forEach { id ->
                val report = Report()
                report.ecosystemLayerName=ecosystemLayerService.findById(id).get().ecosystemLayerName
                report.companyName=company.companyName
                report.companyProgression= Company.getCompanyProgressionStatusById(company.id)!!.statusName
                report.isNDAavailable=company.isNDAavailable
                report.notes=company.notes
                report.uvp=company.uvp
                report.productDescription=company.productDescription
                report.companyName=company.companyName
                reportList.add(report)
            }
        }
        reportList.forEach {
            item ->
            println(item)
        }

        return reportList

    }
}