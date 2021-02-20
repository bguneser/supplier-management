package com.togg.suppliermanagement.service.impl

import com.togg.suppliermanagement.entity.Country
import com.togg.suppliermanagement.repo.AdressRepository
import com.togg.suppliermanagement.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl : CountryService {

    @Autowired
    lateinit var addressRepository: AdressRepository

    override fun saveAddress(addressDto: Country): Country {
        return addressRepository.save(addressDto)
    }
}