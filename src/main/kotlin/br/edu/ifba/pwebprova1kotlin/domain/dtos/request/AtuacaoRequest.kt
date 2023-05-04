package br.edu.ifba.pwebprova1kotlin.domain.dtos.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotNull

data class AtuacaoRequest(
        @NotNull @JsonProperty("engenheiro_id") val engenheiroId: Long,
        @NotNull @JsonProperty("projeto_id") val projetoId: Long,
        @NotNull val duracao: Int)
