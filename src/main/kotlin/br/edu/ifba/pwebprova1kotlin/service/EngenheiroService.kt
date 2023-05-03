package br.edu.ifba.pwebprova1kotlin.service

import br.edu.ifba.pwebprova1kotlin.domain.dtos.EngenheiroRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.EngenheiroResponse
import br.edu.ifba.pwebprova1kotlin.domain.dtos.EngenheiroUpdateRequest
import br.edu.ifba.pwebprova1kotlin.domain.entities.Engenheiro
import br.edu.ifba.pwebprova1kotlin.repository.EngenheiroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EngenheiroService(@Autowired val repository: EngenheiroRepository) {

    fun cadastrar(dto: EngenheiroRequest): EngenheiroResponse {
        val entity = repository.save(Engenheiro(dto))
        return EngenheiroResponse(entity)
    }

    fun listar(): List<EngenheiroResponse> = repository.findAll().map { EngenheiroResponse(it) }

    fun atualizar(id: Long, dto: EngenheiroUpdateRequest): EngenheiroResponse =
        repository.findById(id).let {
            val entity = it.get()
            entity.nome = dto.nome
            entity.especialidade = dto.especialidade
            EngenheiroResponse(repository.save(entity))
        }

    fun deletar(id: Long) = repository.deleteById(id)
}
