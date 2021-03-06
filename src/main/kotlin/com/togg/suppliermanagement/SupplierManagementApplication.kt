package com.togg.suppliermanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class SupplierManagementApplication

fun main(args: Array<String>) {
	runApplication<SupplierManagementApplication>(*args)
}
