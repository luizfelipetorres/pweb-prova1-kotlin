package br.edu.ifba.pwebprova1kotlin.domain.entities

import jakarta.persistence.*

@Entity(name = "atuacao")
class Atuacao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
    @ManyToOne @JoinColumn(name = "engenheiro_id") var engenheiro: Engenheiro,
    @ManyToOne @JoinColumn(name = "projeto_id") var projeto: Projeto,
    var duracao: Int
) {}