package br.edu.ifba.pwebprova1kotlin.repository

import br.edu.ifba.pwebprova1kotlin.domain.entities.Atuacao
import br.edu.ifba.pwebprova1kotlin.domain.entities.Engenheiro
import br.edu.ifba.pwebprova1kotlin.domain.entities.Projeto
import org.springframework.data.jpa.repository.JpaRepository

interface AtuacaoRepository : JpaRepository<Atuacao, Long> {}

interface EngenheiroRepository : JpaRepository<Engenheiro, Long> {}

interface ProjetoRepository : JpaRepository<Projeto, Long> {}