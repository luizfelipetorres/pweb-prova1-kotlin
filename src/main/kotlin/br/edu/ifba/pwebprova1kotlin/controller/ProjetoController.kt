package br.edu.ifba.pwebprova1kotlin.controller

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.ProjetoRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.ProjetoResponse
import br.edu.ifba.pwebprova1kotlin.service.ProjetoService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping(path = ["/projeto"])
class ProjetoController(@Autowired val service: ProjetoService) {

    @PostMapping
    fun cadastrar(
            @RequestBody @Valid dto: ProjetoRequest, builder: UriComponentsBuilder
    ): ResponseEntity<ProjetoResponse> = service.cadastrar(dto).let { response ->
        builder.path("/projeto/${response.id}").build().toUri().let { uri ->
            ResponseEntity.created(uri).body(response)
        }
    }

    @GetMapping
    fun listar() = ResponseEntity.ok(service.listar())

    @PutMapping(path = ["/{id}"])
    fun atualizar(@PathVariable id: Long, @RequestBody dto: ProjetoRequest) =
        service.atualizar(id, dto).let { ResponseEntity.ok(it) }

    @DeleteMapping(path = ["/{id}"])
    fun deletar(@PathVariable id: Long): ResponseEntity<Unit> =
        service.deletar(id).let { ResponseEntity.noContent().build() }
}