package br.edu.ifba.pwebprova1kotlin.domain.exceptions

import org.springframework.http.HttpStatus

class EngenheiroNotFoundException(message: String = "Engenheiro não encontrado!") :
    GenericException(
        message = message,
        status = HttpStatus.BAD_REQUEST
    )