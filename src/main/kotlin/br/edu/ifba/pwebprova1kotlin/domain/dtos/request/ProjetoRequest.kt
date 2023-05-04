package br.edu.ifba.pwebprova1kotlin.domain.dtos.request

import br.edu.ifba.pwebprova1kotlin.domain.enums.Categoria
import jakarta.validation.constraints.NotNull

data class ProjetoRequest(
    @NotNull val nome: String,
    @NotNull val custo: Double,
    @NotNull val categoria: Categoria
)
