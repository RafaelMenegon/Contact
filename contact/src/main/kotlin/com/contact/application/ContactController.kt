package com.contact.application

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contact")
class ContactController(
    val service: ContactService
) {

    @GetMapping(value = ["/{id}"])
    fun getContact(@PathVariable id: Long): ResponseEntity<Contact> {
        return ResponseEntity.ok(service.getContact(id))
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postContact(@RequestBody contact: Contact): ResponseEntity<Contact> {
        val response = service.createContact(contact)
        return ResponseEntity.ok(response)
    }

}