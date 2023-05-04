package br.edu.ifba.pwebprova1kotlin.domain.dtos.response

import br.edu.ifba.pwebprova1kotlin.domain.entities.Projeto
import br.edu.ifba.pwebprova1kotlin.domain.enums.Categoria
import com.fasterxml.jackson.annotation.JsonIgnore

data class ProjetoResponse(
    @JsonIgnore val id: Long, val nome: String, val categoria: Categoria
) {
    constructor(entity: Projeto) : this(entity.id!!, entity.nome, entity.categoria)
}
