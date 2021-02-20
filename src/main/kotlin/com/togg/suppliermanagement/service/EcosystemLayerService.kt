package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.entity.Company
import com.togg.suppliermanagement.entity.EcosystemLayer
import org.springframework.stereotype.Service
import java.util.*

@Service
interface EcosystemLayerService {

    fun findEcosystemIdsByCompanyId(userId : Long): MutableList<Long>
    fun findById(ecosystemLayerId : Long) : Optional<EcosystemLayer>

}