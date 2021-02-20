package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.entity.Country
import org.springframework.stereotype.Service

@Service
interface CountryService {

    fun saveAddress(addressDto: Country) : Country
}