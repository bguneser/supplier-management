package com.togg.suppliermanagement.service

import com.togg.suppliermanagement.entity.Report
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
interface ReportService {

    fun getAllReport(): MutableList<Report>

}