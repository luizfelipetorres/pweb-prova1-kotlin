package br.edu.ifba.pwebprova1kotlin.domain.dtos.request

import br.edu.ifba.pwebprova1kotlin.domain.enums.Especialidade
import jakarta.validation.constraints.NotNull

data class EngenheiroRequest(
    @NotNull val nome: String,
    @NotNull val CREA: String,
    @NotNull val especialidade: Especialidade
)
