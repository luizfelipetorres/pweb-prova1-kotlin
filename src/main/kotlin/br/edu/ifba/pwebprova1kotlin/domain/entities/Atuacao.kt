package br.edu.ifba.pwebprova1kotlin.domain.entities

import jakarta.persistence.*

@Entity(name = "atuacao")
class Atuacao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    @ManyToOne @JoinColumn(name = "engenheiro_id") val engenheiro: Engenheiro,
    @ManyToOne @JoinColumn(name = "projeto_id") val projeto: Projeto,
    var duracao: Int
) {}