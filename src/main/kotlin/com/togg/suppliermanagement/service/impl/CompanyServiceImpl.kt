package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.Dto.CompanyDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.repo.EcosystemLayerRepository
import com.togg.suppliermanagement.service.CompanyService
import com.togg.suppliermanagement.service.EcosystemLayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.util.*


@Service
class CompanyServiceImpl : CompanyService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var ecosystemLayerRepository: EcosystemLayerRepository

    override fun saveCompany(companyDto: CompanyDto): Company {

        val company = Company()

        val companyNames = mutableListOf<String>()

        getCompaniesByEcosystemLayerId(companyDto.ecosystemLayer.id).forEach { it -> companyNames.add(it.companyName)
        }

        if(companyNames.contains(companyDto.companyName.toUpperCase())) {

            throw ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Company already exist")

        } else {

            company.ecosystemLayer.id = companyDto.ecosystemLayer.id
            company.ecosystemLayer.ecosystemLayerName = companyDto.ecosystemLayer.ecosystemLayerName
            company.ecosystemLayer.companies.add(company)
            company.companyName = companyDto.companyName.toUpperCase()
            company.productDescription = companyDto.productDescription
            company.notes = companyDto.notes
            company.companyProgression = companyDto.companyProgression
            company.isNDAavailable = companyDto.isNDAavailable
            company.uvp = companyDto.uvp
            company.userJourneyName=companyDto.userJourneyName
            company.countryName = companyDto.countryName

            val savedCompany = companyRepository.save(company)
            company.id = savedCompany.id

            return savedCompany

        }



    }

    override fun deleteCompany(companyId: Long): CompanyDto {
        val deletedCompany = findCompanyByCompanyId(companyId)
        companyRepository.deleteById(companyId)
        return deletedCompany
    }

    @Transactional
    override fun updateCompany(company: Company, companyId: Long): Company {

            val newCompany = companyRepository.findById(companyId).get()
            newCompany.userJourneyName=company.userJourneyName
            newCompany.companyName=company.companyName
            newCompany.ecosystemLayer=company.ecosystemLayer
            newCompany.uvp=company.uvp
            newCompany.isNDAavailable=company.isNDAavailable
            newCompany.companyProgression=company.companyProgression
            newCompany.countryName=company.countryName
            newCompany.notes=company.notes

        val savedCompany = companyRepository.save(newCompany)

        return   savedCompany

    }

    override fun retrieveAllCompanies(): MutableList<Company> {
        return companyRepository.findAll()
    }

    override fun findByCompanyName(companyName: String): Optional<Company> {
        return companyRepository.findByCompanyName(companyName)
    }

    override fun findCompanyByCompanyId(id: Long): CompanyDto {

        val companyDto = CompanyDto()
        val company = companyRepository.findById(id).get()

        companyDto.companyId = company.id
        companyDto.companyName=company.companyName
        companyDto.notes = company.notes
        companyDto.uvp = company.uvp
        companyDto.isNDAavailable = company.isNDAavailable
        companyDto.companyProgression = company.companyProgression
        companyDto.countryName = company.countryName
        companyDto.productDescription = company.productDescription
        companyDto.ecosystemLayer.ecosystemLayerName=company.ecosystemLayer.ecosystemLayerName
        companyDto.ecosystemLayer.id=company.ecosystemLayer.id

        return companyDto
    }

    override fun getCompaniesByEcosystemLayerId(ecosystemLayerId: Long): MutableList<CompanyDto> {
        val companies = mutableListOf<CompanyDto>()

        ecosystemLayerRepository.findById(ecosystemLayerId).get().companies.forEach { it ->
            val companyDto = CompanyDto()
            companyDto.companyId = it.id
            companyDto.companyName = it.companyName
            companyDto.companyProgression = it.companyProgression
            companyDto.isNDAavailable = it.isNDAavailable
            companyDto.productDescription = it.productDescription
            companyDto.countryName = it.countryName
            companyDto.uvp = it.uvp
            companyDto.notes = it.notes
            companyDto.userJourneyName=it.userJourneyName
            companyDto.ecosystemLayer.id=it.ecosystemLayer.id
            companyDto.ecosystemLayer.ecosystemLayerName=it.ecosystemLayer.ecosystemLayerName
            // companyDto.ecosystemLayer.companies=it.ecosystemLayer.companies

            companies.add(companyDto)

        }


        return companies
    }
}