package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.entity.Company
import org.springframework.stereotype.Service
import java.util.*

@Service
interface CompanyService {

    fun saveCompany(companyDto: Company) : Company

    fun deleteCompany(companyId : Long): Optional<Company>

    fun retrieveAllCompanies() : MutableList<Company>

    fun findByCompanyName(companyName : String) : Optional<Company>

    fun findByCompanyId(id : Long): Optional<Company>


}