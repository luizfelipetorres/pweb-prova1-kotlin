package br.edu.ifba.pwebprova1kotlin.domain.exceptions

import org.springframework.http.HttpStatus

class AtuacaoNotFoundException(message: String) : GenericException(message, HttpStatus.BAD_REQUEST)
