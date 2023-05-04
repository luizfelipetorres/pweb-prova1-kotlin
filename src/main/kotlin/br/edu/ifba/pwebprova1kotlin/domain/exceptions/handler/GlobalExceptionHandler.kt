package br.edu.ifba.pwebprova1kotlin.domain.exceptions.handler

import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.ApiException
import br.edu.ifba.pwebprova1kotlin.domain.exceptions.EngenheiroNotFoundException
import br.edu.ifba.pwebprova1kotlin.domain.exceptions.GenericException
import br.edu.ifba.pwebprova1kotlin.domain.exceptions.ProjetoNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(GenericException::class)
    fun handleEngenheiroNotFound(exception: GenericException) =
            ApiException(exception.message, exception.status).let {
                ResponseEntity.status(it.status).body(it)
            }
}