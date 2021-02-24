package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.Dto.CompanyDto
import com.togg.suppliermanagement.Dto.EcoSystemLayerDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import com.togg.suppliermanagement.repo.CompanyRepository
import com.togg.suppliermanagement.repo.EcosystemLayerRepository
import com.togg.suppliermanagement.service.EcosystemLayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class EcosystemLayerImpl : EcosystemLayerService{
    @Autowired
    lateinit var ecosystemLayerRepository: EcosystemLayerRepository
    @Autowired
    lateinit var companyRepository: CompanyRepository

    override fun saveEcosystemLayer(ecosystemLayerDto: EcosystemLayer): EcosystemLayer {
       return ecosystemLayerRepository.save(ecosystemLayerDto)
    }

    override fun retrieveAllEcosystemLayers(): MutableList<EcoSystemLayerDto> {
        val ecosystemLayers = mutableListOf<EcoSystemLayerDto>()

        ecosystemLayerRepository.findAll().forEach {  it ->

            val ecosystemLayerDto = EcoSystemLayerDto()
            ecosystemLayerDto.id=it.id
            ecosystemLayerDto.ecosystemLayerName=it.ecosystemLayerName
            ecosystemLayerDto.companies=getCompanyList(it)
            ecosystemLayerDto.companySize= getCompanyList(it).size.toLong()
            ecosystemLayers.add(ecosystemLayerDto)


        }

        return ecosystemLayers

    }

    fun getCompanyList(ecosystemLayer: EcosystemLayer): MutableList<CompanyDto> {
        val companyList = mutableListOf<CompanyDto>()

        ecosystemLayer.companies.forEach {
            it ->
            val companyDto = CompanyDto()
            companyDto.companyId=it.id
            companyDto.companyName=it.companyName
            companyDto.companyProgression=it.companyProgression
            companyDto.countryName=it.country!!.countryName
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
            company.ecosystemLayers.forEach {
                ecosystemLayer ->
                ecosystemLayerIds.add(ecosystemLayer.id)
            }
        }
        return ecosystemLayerIds
    }

    override fun findEcosystemLayerById(ecosystemLayerId: Long): Optional<EcosystemLayer> {
       return ecosystemLayerRepository.findById(ecosystemLayerId)
    }

    override fun findByEcosystemLayerName(ecosystemLayerName: String): Optional<EcosystemLayer> {
      return  ecosystemLayerRepository.findByEcosystemLayerName(ecosystemLayerName)
    }

}