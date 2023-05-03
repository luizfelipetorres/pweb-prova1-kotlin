package br.edu.ifba.pwebprova1kotlin.domain.dtos

import br.edu.ifba.pwebprova1kotlin.domain.entities.Engenheiro
import br.edu.ifba.pwebprova1kotlin.domain.enums.Especialidade

data class EngenheiroResponse(var id: Long, var nome: String, var especialidade: Especialidade) {
    constructor(entity: Engenheiro) : this(entity.id!!, entity.nome, entity.especialidade)
}