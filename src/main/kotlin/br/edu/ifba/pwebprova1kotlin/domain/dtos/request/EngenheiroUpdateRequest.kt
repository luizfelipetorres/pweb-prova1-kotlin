package br.edu.ifba.pwebprova1kotlin.domain.dtos.request

import br.edu.ifba.pwebprova1kotlin.domain.enums.Especialidade

data class EngenheiroUpdateRequest(
    val nome: String,
    val especialidade: Especialidade
)
