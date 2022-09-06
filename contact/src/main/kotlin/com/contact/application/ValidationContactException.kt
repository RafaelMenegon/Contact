package com.contact.application

data class ValidationContactException(
    override val message: String = ""
) : Exception()