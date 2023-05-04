package br.edu.ifba.pwebprova1kotlin.controller

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroUpdateRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.ApiException
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.EngenheiroResponse
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.ProjetoResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.headers.Header
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import io.swagger.v3.oas.annotations.parameters.RequestBody as RequestBodySwagger


@Tag(
    name = "Engenheiro Controller",
    description = "Controlador responsável por operações na tabela engenheiro"
)
interface IEngenheiroController {

    @PostMapping
    @Operation(
        summary = "Endpoint responsável por cadastrar engenheiros",
        requestBody = RequestBodySwagger(description = "Informações do engenheiro que serão cadastradas"),
        responses = [
            ApiResponse(
                responseCode = "201", description = "Created",
                headers = [
                    Header(
                        name = "Location",
                        description = "Url para consulta do objeto criado"
                    )
                ], content = [
                    Content(
                        mediaType = "application/json",
                        schema = Schema(implementation = EngenheiroResponse::class)
                    )
                ]
            ),
            ApiResponse(
                responseCode = "400", description = "Bad Request", content = [
                    Content(
                        mediaType = "application/json",
                        schema = Schema(implementation = ApiException::class)
                    )
                ]
            ),
        ]
    )
    fun cadastrar(
        dto: EngenheiroRequest, builder: UriComponentsBuilder
    ): ResponseEntity<EngenheiroResponse>

    @GetMapping
    @Operation(
        summary = "Endpoint responsável por listar engenheiros",
        responses = [
            ApiResponse(
                responseCode = "200", description = "teste ok", content = [
                    Content(
                        mediaType = "application/json",
                        array = ArraySchema(schema = Schema(implementation = EngenheiroResponse::class))
                    )
                ]
            ),
            ApiResponse(
                responseCode = "400", description = "teste badRequest", content = [
                    Content(
                        mediaType = "application/json",
                        schema = Schema(implementation = ApiException::class)
                    )
                ]
            ),
        ]
    )
    fun listar(): ResponseEntity<List<EngenheiroResponse>>

    @Operation(
        summary = "Endpoint responsável por exibir um único engenheiro",
        responses = [
            ApiResponse(
                description = "Ok", responseCode = "200", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = EngenheiroResponse::class)
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
    fun exibir(@PathVariable id: Long) : ResponseEntity<EngenheiroResponse>

    @PutMapping(path = ["/{id}"])
    @Operation(
        summary = "Endpoint responsável por atualizar informações do engenheiro",
        requestBody = RequestBodySwagger(
            description = "Informações do engenheiro que podem ser atualizadas",
            content = [
                Content(mediaType = "application/json")
            ]
        ),
        responses = [
            ApiResponse(
                responseCode = "200", description = "Ok", content = [
                    Content(
                        mediaType = "application/json",
                        schema = Schema(implementation = EngenheiroResponse::class)
                    )
                ]
            ),
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
    fun atualizar(
        @Parameter(description = "Id do engenheiro que será atualizado")
        @PathVariable id: Long, @RequestBody dto: EngenheiroUpdateRequest
    ): ResponseEntity<EngenheiroResponse>

    @DeleteMapping(path = ["/{id}"])
    @Operation(
        summary = "Endpoint responsável por deletar engenheiros",
        responses = [
            ApiResponse(
                responseCode = "204", description = "No Content"
            ),
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
    fun deletar(
        @Parameter(description = "Id do engenheiro que será deletado")
        @PathVariable id: Long): ResponseEntity<Unit>
}