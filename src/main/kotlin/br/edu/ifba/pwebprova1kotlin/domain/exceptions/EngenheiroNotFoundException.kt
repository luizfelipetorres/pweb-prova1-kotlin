package br.edu.ifba.pwebprova1kotlin.domain.exceptions

import org.springframework.http.HttpStatus

class EngenheiroNotFoundException() : GenericException(
        message = "Engenheiro não encontrado!",
        status = HttpStatus.BAD_REQUEST)