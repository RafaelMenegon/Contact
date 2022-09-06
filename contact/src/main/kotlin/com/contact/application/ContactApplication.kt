package com.contact.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class ContactApplication

fun main(args: Array<String>) {
    runApplication<ContactApplication>(*args)
}