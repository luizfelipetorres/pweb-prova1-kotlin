package br.edu.ifba.pwebprova1kotlin.domain.dtos.response

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDateTime

@ResponseBody
data class ApiException(
        val message: String,
        @Schema(example = "BAD_REQUEST")
        val status: HttpStatus,
        val timestamp: LocalDateTime = LocalDateTime.now())