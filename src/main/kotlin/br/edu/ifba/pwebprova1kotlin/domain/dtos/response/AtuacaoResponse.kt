package br.edu.ifba.pwebprova1kotlin.domain.dtos.response

import br.edu.ifba.pwebprova1kotlin.domain.entities.Atuacao

data class AtuacaoResponse(val id: Long, val engenheiro: EngenheiroResponse, val projeto: ProjetoResponse) {
    constructor(entity: Atuacao) : this(entity.id!!, EngenheiroResponse(entity.engenheiro), ProjetoResponse(entity.projeto))
}
