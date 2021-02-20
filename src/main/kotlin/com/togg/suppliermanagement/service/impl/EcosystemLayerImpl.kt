package com.togg.suppliermanagement.service.impl

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

    override fun findById(ecosystemLayerId: Long): Optional<EcosystemLayer> {
       return ecosystemLayerRepository.findById(ecosystemLayerId)
    }

}