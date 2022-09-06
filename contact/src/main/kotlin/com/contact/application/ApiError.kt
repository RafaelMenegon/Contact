package com.contact.application

data class ApiError(
    val httpStatusCode: String,
    val message: String
)