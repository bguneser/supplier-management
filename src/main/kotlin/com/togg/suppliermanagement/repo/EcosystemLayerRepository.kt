package com.togg.suppliermanagement.repo


import com.togg.suppliermanagement.entity.EcosystemLayer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EcosystemLayerRepository : JpaRepository<EcosystemLayer, Long> {

    fun findByEcosystemLayerName(ecosystemLayerName : String): Optional<EcosystemLayer>


}