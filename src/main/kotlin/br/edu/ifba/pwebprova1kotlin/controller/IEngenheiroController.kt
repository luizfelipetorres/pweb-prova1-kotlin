package br.edu.ifba.pwebprova1kotlin.controller

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroUpdateRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.EngenheiroResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


interface IEngenheiroController {
    @PostMapping
    @Operation(description = "Teste cadastrar")
    @ApiResponses( value = [
        ApiResponse(responseCode = "201", description = "Created"),
        ApiResponse(responseCode = "400", description = "Bad Request")
    ])
    fun cadastrar(@RequestBody @Valid dto: EngenheiroRequest, builder: UriComponentsBuilder): ResponseEntity<EngenheiroResponse>

    @GetMapping
    @Operation(description = "Teste")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK")
    )
    fun listar(): ResponseEntity<List<EngenheiroResponse>>

    @PutMapping(path = ["/{id}"])
    fun atualizar(@PathVariable id: Long, @RequestBody dto: EngenheiroUpdateRequest): ResponseEntity<EngenheiroResponse>

    @DeleteMapping(path = ["/{id}"])
    fun deletar(@PathVariable id: Long): ResponseEntity<Unit>
}