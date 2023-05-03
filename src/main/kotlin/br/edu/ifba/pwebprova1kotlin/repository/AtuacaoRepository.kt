package br.edu.ifba.pwebprova1kotlin.repository

import br.edu.ifba.pwebprova1kotlin.domain.entities.Atuacao
import org.springframework.data.jpa.repository.JpaRepository

interface AtuacaoRepository : JpaRepository<Atuacao, Long> {}