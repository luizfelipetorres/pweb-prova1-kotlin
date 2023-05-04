package br.edu.ifba.pwebprova1kotlin.controller

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.AtuacaoRequest
import br.edu.ifba.pwebprova1kotlin.service.AtuacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/atuacao")
class AtuacaoController(@Autowired val service: AtuacaoService) {

    @PostMapping
    fun cadastrar(@RequestBody dto: AtuacaoRequest, builder: UriComponentsBuilder) = service.cadastrar(dto).let { response ->
        builder.path("/atuacao/${response.id}").build().toUri().let { uri ->
            ResponseEntity.created(uri).body(response)
        }
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Unit> =
            service.deletar(id).let { ResponseEntity.noContent().build() }
}