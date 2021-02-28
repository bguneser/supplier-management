package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.Dto.CompanyDto
import com.togg.suppliermanagement.entity.Company
import org.springframework.stereotype.Service
import java.util.*

@Service
interface CompanyService {

    fun saveCompany(companyDto: CompanyDto) : Company

    fun deleteCompany(companyId : Long):CompanyDto

    fun updateCompany(company : Company, companyId: Long) : Company

    fun retrieveAllCompanies() : MutableList<Company>

    fun findByCompanyName(companyName : String) : Optional<Company>

    fun findCompanyByCompanyId(id : Long): CompanyDto

    fun getCompaniesByEcosystemLayerId(ecosystemLayerId : Long) :MutableList<CompanyDto>


}