package br.edu.ifba.pwebprova1kotlin.service

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.AtuacaoRequest
import br.edu.ifba.pwebprova1kotlin.domain.dtos.response.AtuacaoResponse
import br.edu.ifba.pwebprova1kotlin.domain.entities.Atuacao
import br.edu.ifba.pwebprova1kotlin.domain.exceptions.EngenheiroNotFoundException
import br.edu.ifba.pwebprova1kotlin.domain.exceptions.ProjetoNotFoundException
import br.edu.ifba.pwebprova1kotlin.repository.AtuacaoRepository
import br.edu.ifba.pwebprova1kotlin.repository.EngenheiroRepository
import br.edu.ifba.pwebprova1kotlin.repository.ProjetoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AtuacaoService(
        @Autowired val engenheiroRepository: EngenheiroRepository,
        @Autowired val projetoRepository: ProjetoRepository,
        @Autowired val atuacaoRepository: AtuacaoRepository) {

    fun cadastrar(dto: AtuacaoRequest): AtuacaoResponse = engenheiroRepository.findByIdOrNull(dto.engenheiroId)?.let { engenheiro ->
        projetoRepository.findByIdOrNull(dto.projetoId)?.let { projeto ->
            Atuacao(null, engenheiro, projeto, dto.duracao).let { atuacao ->
                atuacaoRepository.save(atuacao)
                AtuacaoResponse(atuacao)
            }
        } ?: throw ProjetoNotFoundException()
    } ?: throw EngenheiroNotFoundException()

    fun deletar(id: Long): Unit = atuacaoRepository.deleteById(id)
}