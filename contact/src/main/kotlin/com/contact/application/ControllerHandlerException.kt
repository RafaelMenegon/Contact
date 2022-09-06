package com.contact.application

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerHandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [ValidationContactException::class])
    fun validationException(ex: ValidationContactException): ApiError {
        return ApiError(message = ex.message, httpStatusCode = HttpStatus.BAD_REQUEST.name)
    }
}