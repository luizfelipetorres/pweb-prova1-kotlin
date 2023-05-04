package br.edu.ifba.pwebprova1kotlin.controller.impl

import br.edu.ifba.pwebprova1kotlin.controller.IAtuacaoController
import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.AtuacaoRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.AtuacaoResponse
import br.edu.ifba.pwebprova1kotlin.service.AtuacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/atuacao")
class AtuacaoController(@Autowired val service: AtuacaoService) : IAtuacaoController {

    @PostMapping
    override fun cadastrar(@RequestBody dto: AtuacaoRequest, builder: UriComponentsBuilder) = service.cadastrar(dto).let { response ->
        builder.path("/atuacao/${response.id}").build().toUri().let { uri ->
            ResponseEntity.created(uri).body(response)
        }
    }

    @DeleteMapping("/{id}")
    override fun deletar(@PathVariable id: Long): ResponseEntity<Unit> =
            service.deletar(id).let { ResponseEntity.noContent().build() }

    @GetMapping("/{id}")
    override fun exibir(id: Long): ResponseEntity<AtuacaoResponse> = service.exibir(id).let{ atuacao ->
        ResponseEntity.ok(atuacao)
    }
}