package br.edu.ifba.pwebprova1kotlin.controller

import br.edu.ifba.pwebprova1kotlin.domain.dtos.EngenheiroRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.EngenheiroResponse
import br.edu.ifba.pwebprova1kotlin.domain.dtos.EngenheiroUpdateRequest
import br.edu.ifba.pwebprova1kotlin.service.EngenheiroService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping(path = ["/engenheiro"])
class EngenheiroController(@Autowired val service: EngenheiroService) {

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid dto: EngenheiroRequest, builder: UriComponentsBuilder
    ): ResponseEntity<EngenheiroResponse> = service.cadastrar(dto).let { response ->
        builder.path("/engenheiro/${response.id}").build().toUri().let { uri ->
            ResponseEntity.created(uri).body(response)
        }
    }

    @GetMapping
    fun listar() = ResponseEntity.ok(service.listar())

    @PutMapping(path = ["/{id}"])
    fun atualizar(@PathVariable id: Long, @RequestBody dto: EngenheiroUpdateRequest) =
        service.atualizar(id, dto).let { ResponseEntity.ok(it) }

    @DeleteMapping(path = ["/{id}"])
    fun deletar(@PathVariable id: Long): ResponseEntity<Unit> =
        service.deletar(id).let { ResponseEntity.noContent().build() }
}