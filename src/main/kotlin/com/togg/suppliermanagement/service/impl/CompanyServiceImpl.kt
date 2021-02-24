package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.Dto.CompanyDto
import com.togg.suppliermanagement.Dto.EcoSystemLayerDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.entity.UserJourney
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.repo.EcosystemLayerRepository
import com.togg.suppliermanagement.repo.UserJourneyRepository
import com.togg.suppliermanagement.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyServiceImpl : CompanyService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var ecosystemLayerRepository: EcosystemLayerRepository


    @Autowired
    lateinit var userJourneyRepository: UserJourneyRepository

    override fun saveCompany(companyDto: Company): Company {

        val company = Company()

        if(companyRepository.findByCompanyName(companyDto.companyName).isPresent){
            throw  Exception()
        } else {

            companyDto.ecosystemLayers.forEach {
                it ->
                if(ecosystemLayerRepository.findByEcosystemLayerName(it.ecosystemLayerName).isPresent){
                    company.ecosystemLayers.add(ecosystemLayerRepository.findByEcosystemLayerName(it.ecosystemLayerName).get())
                } else {
                    val ecosystemLayer= EcosystemLayer()
                    ecosystemLayer.ecosystemLayerName=it.ecosystemLayerName
                    company.ecosystemLayers.add(ecosystemLayer)
                }
            }

            companyDto.userJourneys.forEach {
                it->
                if(userJourneyRepository.findUserJourneyByUserJourneyName(it.userJourneyName).isPresent()){
                    company.userJourneys.add(userJourneyRepository.findUserJourneyByUserJourneyName(it.userJourneyName).get())
                } else {
                    val userJourney = UserJourney()
                    userJourney.userJourneyName=it.userJourneyName
                    company.userJourneys.add(userJourney)
                }
            }



        }


        company.companyName = companyDto.companyName.toUpperCase()
        company.productDescription = companyDto.productDescription
        company.notes = companyDto.notes
        company.companyProgression = companyDto.companyProgression
        company.isNDAavailable = companyDto.isNDAavailable
        company.uvp=companyDto.uvp
        company.country=companyDto.country


        //company.ecosystemLayers = companyDto.ecosystemLayers
        //company.userJourneys = companyDto.userJourneys

       /* val returnedCompanyDto = CompanyDto()
        returnedCompanyDto.companyName=company.companyName
        returnedCompanyDto.countryName=company.country!!.countryName
        returnedCompanyDto.companyProgression=company.companyProgression
        returnedCompanyDto.isNDAavailable=company.isNDAavailable
        returnedCompanyDto.uvp=company.uvp
        returnedCompanyDto.notes=company.notes

        company.ecosystemLayers.forEach {
            it ->
            val ecosystemLayerDto = EcoSystemLayerDto()
            ecosystemLayerDto.ecosystemLayerName=it.ecosystemLayerName
            returnedCompanyDto.ecosystemLayers.add(ecosystemLayerDto)
        }*/


        return companyRepository.save(company)
    }

    override fun deleteCompany(companyId: Long) : CompanyDto {
        val deletedCompany = findCompanyByCompanyId(companyId)
        companyRepository.deleteById(companyId)
        return deletedCompany
    }
    override fun retrieveAllCompanies(): MutableList<Company> {
        return companyRepository.findAll()
    }

    override fun findByCompanyName(companyName: String): Optional<Company> {
        return companyRepository.findByCompanyName(companyName)
    }

    override fun findCompanyByCompanyId(id: Long): CompanyDto {

        val companyDto = CompanyDto()
        val company =  companyRepository.findById(id).get()

        companyDto.companyId=company.id
        companyDto.notes=company.notes
        companyDto.uvp=company.uvp
        companyDto.isNDAavailable=company.isNDAavailable
        companyDto.companyProgression=company.companyProgression
        companyDto.countryName=company.country!!.countryName
        companyDto.productDescription=company.productDescription

        return companyDto
    }

    override fun getCompaniesByEcosystemLayerId(ecosystemLayerId: Long): MutableList<CompanyDto> {
        val companies = mutableListOf<CompanyDto>()

        ecosystemLayerRepository.findById(ecosystemLayerId).get().companies.forEach { it ->
            val companyDto = CompanyDto()
            companyDto.companyId = it.id
            companyDto.companyName = it.companyName
            companyDto.companyProgression= it.companyProgression
            companyDto.isNDAavailable=it.isNDAavailable
            companyDto.productDescription=it.productDescription
            companyDto.countryName=it.country!!.countryName
            companyDto.uvp=it.uvp
            companyDto.notes=it.notes

            companies.add(companyDto)

        }


       return companies
    }
}