package br.edu.ifba.pwebprova1kotlin.service

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.ProjetoRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.ProjetoResponse
import br.edu.ifba.pwebprova1kotlin.domain.entities.Projeto
import br.edu.ifba.pwebprova1kotlin.domain.exceptions.ProjetoNotFoundException
import br.edu.ifba.pwebprova1kotlin.repository.ProjetoRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProjetoService(@Autowired val repository: ProjetoRepository) {

    fun cadastrar(dto: ProjetoRequest): ProjetoResponse {
        with(repository.save(Projeto(dto))) {
            return ProjetoResponse(id!!, nome, categoria)
        }
    }

    fun listar(): List<ProjetoResponse> =
        repository.findAll().map { ProjetoResponse(it.id!!, it.nome, it.categoria) }

    @Transactional
    fun atualizar(id: Long, dto: ProjetoRequest): ProjetoResponse = repository.findById(id).let {
        with(it.get()) {
            nome = dto.nome
            categoria = dto.categoria
            repository.save(this).let { ProjetoResponse(id, nome, categoria) }
        }
    }

    fun deletar(id: Long) = repository.deleteById(id)

    fun exibir(id: Long): ProjetoResponse = repository.findByIdOrNull(id)?.let {
         ProjetoResponse(it)
     } ?: throw ProjetoNotFoundException()
}
