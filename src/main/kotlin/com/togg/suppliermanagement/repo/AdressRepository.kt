package com.togg.suppliermanagement.repo

import com.togg.suppliermanagement.entity.Country
import org.springframework.data.jpa.repository.JpaRepository

interface AdressRepository : JpaRepository<Country, Long> {


}