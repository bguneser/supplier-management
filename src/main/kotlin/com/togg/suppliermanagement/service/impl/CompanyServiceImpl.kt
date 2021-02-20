package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyServiceImpl : CompanyService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    override fun saveCompany(companyDto: Company): Company {

        val company = Company()
        company.companyName = companyDto.companyName.toUpperCase()
        company.productDescription = companyDto.productDescription
        company.notes = companyDto.notes
        company.companyProgression = companyDto.companyProgression
        company.isNDAavailable = companyDto.isNDAavailable
        company.uvp=companyDto.uvp
        company.ecosystemLayers = companyDto.ecosystemLayers
        company.userJourneys = companyDto.userJourneys

        return companyRepository.save(company)
    }

    override fun deleteCompany(id: Long) {


    }
    override fun retrieveAllCompanies(): MutableList<Company> {
        return companyRepository.findAll()
    }

    override fun findByCompanyName(companyName: String): Optional<Company> {
        return companyRepository.findByCompanyName(companyName)
    }

    override fun findById(id: Long): Optional<Company> {
        return companyRepository.findById(id)
    }


}