package br.edu.ifba.pwebprova1kotlin.controller.impl

import br.edu.ifba.pwebprova1kotlin.controller.IEngenheiroController
import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroUpdateRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.EngenheiroResponse
import br.edu.ifba.pwebprova1kotlin.service.EngenheiroService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping(path = ["/engenheiro"])
class EngenheiroController(@Autowired val service: EngenheiroService) : IEngenheiroController {

    @GetMapping("/{id}")
    override fun exibir(@PathVariable id: Long): ResponseEntity<EngenheiroResponse> {
        return service.exibir(id).let { response ->
            ResponseEntity.ok(response)
        }
    }

    @PostMapping
    override fun cadastrar(
        @RequestBody @Valid dto: EngenheiroRequest, builder: UriComponentsBuilder
    ): ResponseEntity<EngenheiroResponse> = service.cadastrar(dto).let { response ->
        builder.path("/engenheiro/${response.id}").build().toUri().let { uri ->
            ResponseEntity.created(uri).body(response)
        }
    }

    @GetMapping
    override fun listar() = ResponseEntity.ok(service.listar())

    @PutMapping(path = ["/{id}"])
    override fun atualizar(@PathVariable id: Long, @RequestBody dto: EngenheiroUpdateRequest) =
        service.atualizar(id, dto).let { ResponseEntity.ok(it) }

    @DeleteMapping(path = ["/{id}"])
    override fun deletar(@PathVariable id: Long): ResponseEntity<Unit> =
        service.deletar(id).let { ResponseEntity.noContent().build() }
}