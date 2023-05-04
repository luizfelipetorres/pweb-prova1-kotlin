package br.edu.ifba.pwebprova1kotlin.domain.exceptions

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

open class GenericException(
        override val message: String,
        val status: HttpStatus,
        val timestamp: LocalDateTime = LocalDateTime.now()
) : RuntimeException()