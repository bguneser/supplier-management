package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.Dto.EcoSystemLayerDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import org.springframework.stereotype.Service
import java.util.*

@Service
interface EcosystemLayerService {

    fun saveEcosystemLayer(ecosystemLayerDto: EcosystemLayer) : EcosystemLayer
    fun retrieveAllEcosystemLayers() : MutableList<EcoSystemLayerDto>
    fun findEcosystemIdsByCompanyId(userId : Long): MutableList<Long>
    fun findEcosystemLayerById(ecosystemLayerId : Long) : Optional<EcosystemLayer>
    fun findByEcosystemLayerName(ecosystemLayerName : String) : Optional<EcosystemLayer>


}