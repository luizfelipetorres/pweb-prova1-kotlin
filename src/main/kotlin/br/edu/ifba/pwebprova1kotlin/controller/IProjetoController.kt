package br.edu.ifba.pwebprova1kotlin.controller

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.ProjetoRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.ApiException
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.ProjetoResponse
import br.edu.ifba.pwebprova1kotlin.domain.exceptions.ProjetoNotFoundException
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@Tag(
    name = "Projeto Controller",
    description = "Controlador responsável pelas operações na tabela projeto"
)
interface IProjetoController {

    @Operation(
        summary = "Endpoint responsável por cadastrar um novo projeto", responses = [
            ApiResponse(
                description = "Created", responseCode = "201", content = [Content(
                    mediaType = "application/json",
                    array = ArraySchema(schema = Schema(implementation = ProjetoResponse::class))
                )]
            ),
            ApiResponse(
                description = "Bad Request", responseCode = "400", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ApiException::class)
                )]
            ),

        ]
    )
    @PostMapping
    fun cadastrar(
        @RequestBody @Valid dto: ProjetoRequest, builder: UriComponentsBuilder
    ): ResponseEntity<ProjetoResponse>

    @Operation(
        summary = "Endpoint responsável por listar todos os projetos"
    )
    @GetMapping
    fun listar(): ResponseEntity<List<ProjetoResponse>>

    @Operation(
        summary = "Endpoint responsável por exibir um único projeto",
        responses = [
            ApiResponse(
                description = "Ok", responseCode = "200", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ProjetoResponse::class)
                )]
            ),
            ApiResponse(
                description = "Bad Request", responseCode = "400", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ApiException::class)
                )]
            ),
        ]
    )
    @GetMapping("/{id}")
    fun exibir(@PathVariable id: Long) : ResponseEntity<ProjetoResponse>

    @Operation(
        summary = "Endpoind responsável por atualizar projetos",
        responses = [
            ApiResponse(
                description = "Ok", responseCode = "200", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ProjetoResponse::class)
                )]
            ),
            ApiResponse(
                description = "Bad request", responseCode = "400", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ApiException::class)
                )]
            ),
        ]
    )
    @PutMapping(path = ["/{id}"])
    fun atualizar(
        @Parameter(description = "Id do projeto que será atualizado")
        @PathVariable id: Long, @RequestBody dto: ProjetoRequest
    ): ResponseEntity<ProjetoResponse>

    @Operation(
        summary = "Endpoint responsável por deletar projetos",
        responses = [
            ApiResponse(responseCode = "204", description = "No Content"),
            ApiResponse(
                description = "Bad request", responseCode = "400", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ApiException::class)
                )]
            )
        ]
    )
    @DeleteMapping(path = ["/{id}"])
    fun deletar(
        @Parameter(description = "Id do projeto que será deletado")
        @PathVariable id: Long
    ): ResponseEntity<Unit>
}