package br.edu.ifba.pwebprova1kotlin.domain.entities

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.ProjetoRequest
import br.edu.ifba.pwebprova1kotlin.domain.enums.Categoria
import jakarta.persistence.*

@Entity(name = "projetos")
class Projeto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
    var nome: String,
    var custo: Double,
    @Enumerated(value = EnumType.STRING) var categoria: Categoria
) {
    constructor(dto: ProjetoRequest) : this(null, dto.nome, dto.custo, dto.categoria)
}