package br.edu.ifba.pwebprova1kotlin.domain.dtos.response

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDateTime

@ResponseBody
data class ApiException(
        val message: String,
        val status: HttpStatus,
        val timestamp: LocalDateTime = LocalDateTime.now())