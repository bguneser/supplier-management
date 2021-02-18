package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.dto.CompanyDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.service.CompanyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.MethodArgumentNotValidException
import java.lang.RuntimeException
import java.util.*

@Service
class CompanyServiceImpl : CompanyService {

    @Autowired
    lateinit var  companyRepository : CompanyRepository

    private val logger: Logger = LoggerFactory.getLogger(CompanyServiceImpl::class.java)

    override fun saveCompany(companyDto: CompanyDto): CompanyDto {

        try {

            val company : Company = Company()
            company.companyName=companyDto.companyName.toUpperCase()
            company.productDescription=companyDto.productDescription
            company.notes=companyDto.notes
            company.companyProgression=companyDto.companyProgression
            company.ecosystemLayers=companyDto.ecosystemLayers
            company.userJourneys=companyDto.userJourneys

            val savedCompany : Company = companyRepository.save(company)
            companyDto.id=savedCompany.id
            companyDto.ecosystemLayers= savedCompany.ecosystemLayers
            companyDto.userJourneys=savedCompany.userJourneys

        }catch (e: Exception){
            logger.error("Error: "+ e.cause!!.message)
            throw Exception()
        }
        return companyDto
    }

    override fun deleteCompany(id: Long) {




    }

    override fun retrieveAllCompanies(): MutableList<Company> {

        val companies : MutableList<Company> = companyRepository.findAll()

        val companyDtos: MutableList<CompanyDto> = mutableListOf<CompanyDto>()

       /* companies.forEach { company ->
            val companyDto = CompanyDto()
            companyDto.id = company.id
            companyDto.companyName = company.companyName
            companyDto.companyProgression = company.companyProgression
            companyDto.notes = company.notes
            companyDto.productDescription = company.productDescription
            companyDto.status = company.status
            companyDto.ecosystemLayers.addAll(company.ecosystemLayers)
            companyDtos.add(companyDto)
        }


        var info : String = ""
        companyDtos.forEach{
            info += it.toString() + "<br>"
        }

        println(info)*/

        return companies
    }

    override fun findByCompanyName(companyName: String): Optional<Company> {
         return companyRepository.findByCompanyName(companyName)
    }


}