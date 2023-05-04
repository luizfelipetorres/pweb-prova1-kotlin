package br.edu.ifba.pwebprova1kotlin.service

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroUpdateRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.EngenheiroResponse
import br.edu.ifba.pwebprova1kotlin.domain.entities.Engenheiro
import br.edu.ifba.pwebprova1kotlin.domain.exceptions.EngenheiroNotFoundException
import br.edu.ifba.pwebprova1kotlin.repository.EngenheiroRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class EngenheiroService(@Autowired val repository: EngenheiroRepository) {

    fun cadastrar(dto: EngenheiroRequest): EngenheiroResponse {
        val entity = repository.save(Engenheiro(dto))
        return EngenheiroResponse(entity)
    }

    fun listar(): List<EngenheiroResponse> = repository.findAll().map { EngenheiroResponse(it) }

    @Transactional
    fun atualizar(id: Long, dto: EngenheiroUpdateRequest): EngenheiroResponse =
        repository.findById(id).let {
            val entity = it.get()
            entity.nome = dto.nome
            entity.especialidade = dto.especialidade
            EngenheiroResponse(repository.save(entity))
        }

    fun deletar(id: Long) = repository.findByIdOrNull(id)?.let { engenheiro ->
        repository.delete(engenheiro)
    } ?: throw EngenheiroNotFoundException("Engenheiro de id '$id' não encontrado!")

    fun exibir(id: Long): EngenheiroResponse = repository.findByIdOrNull(id)?.let { engenheiro ->
        EngenheiroResponse(engenheiro)
    } ?: throw EngenheiroNotFoundException("Engenheiro de id '$id' não encontrado")
}
