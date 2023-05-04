package br.edu.ifba.pwebprova1kotlin.domain.entities

import br.edu.ifba.pwebprova1kotlin.domain.dtos.request.EngenheiroRequest
import br.edu.ifba.pwebprova1kotlin.domain.enums.Especialidade
import jakarta.persistence.*

@Entity(name = "engenheiros")
class Engenheiro(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    var nome: String,
    val CREA: String,
    @Enumerated(EnumType.STRING) var especialidade: Especialidade = Especialidade.CIVIL
) {
    constructor(dto: EngenheiroRequest) : this(null, dto.nome, dto.CREA, dto.especialidade)
}