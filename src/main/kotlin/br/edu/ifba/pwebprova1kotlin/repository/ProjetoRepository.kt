package br.edu.ifba.pwebprova1kotlin.repository

import br.edu.ifba.pwebprova1kotlin.domain.entities.Projeto
import org.springframework.data.jpa.repository.JpaRepository

interface ProjetoRepository : JpaRepository<Projeto, Long> {}