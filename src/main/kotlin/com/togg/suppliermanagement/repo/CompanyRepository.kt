package com.togg.suppliermanagement.repo

import com.togg.suppliermanagement.entity.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CompanyRepository : JpaRepository<Company,Long> {

    fun findByCompanyName(companyName : String) : Optional<Company>


}