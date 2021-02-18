package com.togg.suppliermanagement.exception

import com.togg.suppliermanagement.validation.ApiErrorVO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleValidationError(ex: MethodArgumentNotValidException): ApiErrorVO? {
        val bindingResult = ex.bindingResult
        val fieldError = bindingResult.fieldError
        val defaultMessage = fieldError!!.defaultMessage
        return defaultMessage?.let { ApiErrorVO("VALIDATION_FAILED", it) }
    }
}