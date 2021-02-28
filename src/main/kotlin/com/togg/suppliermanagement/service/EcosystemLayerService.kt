package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.Dto.EcosystemLayerDto
import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import org.springframework.stereotype.Service
import java.util.*

@Service
interface EcosystemLayerService {

    fun saveEcosystemLayer(ecosystemLayerDto: EcosystemLayerDto) : EcosystemLayerDto
    fun retrieveAllEcosystemLayers() : MutableList<EcosystemLayerDto>
    fun updateEcosystemLayer(ecosystemLayer :EcosystemLayer , ecosystemLayerId : Long) : EcosystemLayer
    fun findEcosystemIdsByCompanyId(userId : Long): MutableList<Long>
    fun findEcosystemLayerByEcosystemLayerId(ecosystemLayerId : Long) : EcosystemLayerDto
    fun findByEcosystemLayerName(ecosystemLayerName : String) : Optional<EcosystemLayer>


}