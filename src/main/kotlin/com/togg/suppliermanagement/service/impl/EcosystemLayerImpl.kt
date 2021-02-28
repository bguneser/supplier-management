package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.Dto.CompanyDto
import com.togg.suppliermanagement.Dto.EcosystemLayerDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.repo.EcosystemLayerRepository
import com.togg.suppliermanagement.service.EcosystemLayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class EcosystemLayerImpl : EcosystemLayerService{
    @Autowired
    lateinit var ecosystemLayerRepository: EcosystemLayerRepository
    @Autowired
    lateinit var companyRepository: CompanyRepository

    override fun saveEcosystemLayer(ecosystemLayerDto: EcosystemLayerDto): EcosystemLayerDto {
        val ecosystemLayer = EcosystemLayer()
        ecosystemLayer.ecosystemLayerName=ecosystemLayerDto.ecosystemLayerName
        val savedEcosystemLayer =ecosystemLayerRepository.save(ecosystemLayer)
        ecosystemLayerDto.id=  savedEcosystemLayer.id
        return ecosystemLayerDto
    }


    override fun retrieveAllEcosystemLayers(): MutableList<EcosystemLayerDto> {
        val ecosystemLayers = mutableListOf<EcosystemLayerDto>()

        ecosystemLayerRepository.findAll().forEach {  it ->

            val ecosystemLayerDto = EcosystemLayerDto()
            ecosystemLayerDto.id=it.id
           // ecosystemLayerDto.companySize= it.companies.size
            ecosystemLayerDto.ecosystemLayerName=it.ecosystemLayerName
            ecosystemLayerDto.companySize= getCompanyList(it).size
            ecosystemLayers.add(ecosystemLayerDto)

        }

        return ecosystemLayers

    }

    @Transactional
    override fun updateEcosystemLayer(ecosystemLayer: EcosystemLayer, ecosystemLayerId: Long): EcosystemLayer {

        val newEcosystemLayer = ecosystemLayerRepository.findById(ecosystemLayerId).get()

        newEcosystemLayer.companies=ecosystemLayer.companies
        newEcosystemLayer.ecosystemLayerName=ecosystemLayer.ecosystemLayerName
        val savedEcosystemLayer= ecosystemLayerRepository.save(newEcosystemLayer)

        return savedEcosystemLayer

    }

    fun getCompanyList(ecosystemLayer: EcosystemLayer): MutableList<CompanyDto> {
        val companyList = mutableListOf<CompanyDto>()

        ecosystemLayer.companies.forEach {
            it ->
            val companyDto = CompanyDto()
            companyDto.companyId=it.id
            companyDto.companyName=it.companyName
            companyDto.companyProgression=it.companyProgression
            companyDto.countryName=it.countryName
            companyDto.isNDAavailable=it.isNDAavailable
            companyDto.notes=it.notes
            companyDto.productDescription=it.productDescription
            companyDto.uvp=it.uvp
            companyList.add(companyDto)
        }



        return companyList

    }

    override fun findEcosystemIdsByCompanyId(userId: Long): MutableList<Long> {
        val ecosystemLayerIds : MutableList<Long> = mutableListOf()
        companyRepository.findAll().forEach { company ->
            ecosystemLayerIds.add(company.ecosystemLayer.id)
        }
        return ecosystemLayerIds
    }

    override fun findEcosystemLayerByEcosystemLayerId(ecosystemLayerId: Long): EcosystemLayerDto {
        val ecosystemLayer = ecosystemLayerRepository.findById(ecosystemLayerId).get()

        val ecosystemLayerDto = EcosystemLayerDto()
        ecosystemLayerDto.id=ecosystemLayer.id
        ecosystemLayerDto.ecosystemLayerName=ecosystemLayer.ecosystemLayerName
        ecosystemLayerDto.companySize=ecosystemLayer.companies.size

       return ecosystemLayerDto
    }

    override fun findByEcosystemLayerName(ecosystemLayerName: String): Optional<EcosystemLayer> {
      return  ecosystemLayerRepository.findByEcosystemLayerName(ecosystemLayerName)
    }

}