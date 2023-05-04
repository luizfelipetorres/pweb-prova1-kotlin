package br.edu.ifba.pwebprova1kotlin.controller

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.AtuacaoRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.ApiException
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.AtuacaoResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.headers.Header
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@Tag(
    name = "Atuação Controller",
    description = "Controller responsável por operações na tabela atuacao"
)
interface IAtuacaoController {
    @PostMapping
    @Operation(
        summary = "Endpoint responsável por cadastrar atuações",
        responses = [
            ApiResponse(
                description = "Created",
                responseCode = "201",
                headers = [Header(
                    name = "Location",
                    description = "Caminho para consultar o objeto criado"
                )],
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = AtuacaoResponse::class)
                )]
            ),
            ApiResponse(
                description = "Bad request",
                responseCode = "400",
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ApiException::class)
                )]
            )
        ]
    )
    fun cadastrar(
        @RequestBody dto: AtuacaoRequest,
        builder: UriComponentsBuilder
    ): ResponseEntity<AtuacaoResponse>


    @DeleteMapping("/{id}")
    @Operation(
        summary = "Endpoint responsável por deletar atuações",
        responses = [
            ApiResponse(responseCode = "204", description = "No Content"),
            ApiResponse(
                responseCode = "400", description = "Bad request", content = [
                    Content(
                        mediaType = "application/json",
                        schema = Schema(implementation = ApiException::class)
                    )
                ]
            )
        ]
    )
    fun deletar(@Parameter(description = "Id da atuação que será deletada") @PathVariable id: Long): ResponseEntity<Unit>

    @Operation(
        summary = "Endpoint responsável por exibir uma atuação",
        responses = [
            ApiResponse(
                description = "Bad Request", responseCode = "400", content = [
                    Content(
                        mediaType = "application/json",
                        schema = Schema(implementation = ApiException::class)
                    ),
                ]
            ),
            ApiResponse(
                description = "Ok", responseCode = "200", content = [
                    Content(
                        mediaType = "application/json",
                        schema = Schema(implementation = AtuacaoResponse::class)
                    ),
                ]
            )
        ]
    )
    @GetMapping(path = ["/{id}"])
    fun exibir(@Parameter(description = "Id da atuação que será exibida") @PathVariable id: Long): ResponseEntity<AtuacaoResponse>
}