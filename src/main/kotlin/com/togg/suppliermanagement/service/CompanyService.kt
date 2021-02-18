package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.dto.CompanyDto
import com.togg.suppliermanagement.entity.Company
import org.springframework.stereotype.Service
import java.util.*

@Service
interface CompanyService {

    fun saveCompany(companyDto: CompanyDto) : CompanyDto

    fun deleteCompany(id : Long)

    fun retrieveAllCompanies() : MutableList<Company>

    fun findByCompanyName(companyName : String) : Optional<Company>


}