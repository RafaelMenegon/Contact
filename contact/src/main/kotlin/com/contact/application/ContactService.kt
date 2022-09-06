package com.contact.application

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ContactService(
    private val repository: ContactRepository
) {

    val logger = LoggerFactory.getLogger(ContactService::class.java)

    fun createContact(contact: Contact): Contact {
        validateContact(contact)
        val contactEntity = repository.save(contact.toEntity())
        return contactEntity.toDTO()
    }

    fun getContact(id: Long): Contact {
        val contactOptional = repository.findById(id)
        if (!contactOptional.isPresent) throw ValidationContactException("Contact not found")
        return contactOptional.get().toDTO()
    }

    private fun validateContact(contact: Contact) {
        kotlin.runCatching {
            if (contact.name.isNullOrBlank()) throw ValidationContactException("Name is mandatory")
            val regexName = Regex("^((\\b[A-zÀ-ú']{2,40}\\b)\\s*){2,}$")
            if (!contact.name.matches(regexName)) throw ValidationContactException("Name must be valid")
            contact.mobile ?: throw ValidationContactException("Mobile is mandatory")
        }.onFailure {
            logger.error("Error during validation", it)
            throw it
        }.onSuccess {
            logger.info("Validated")
        }
    }
}