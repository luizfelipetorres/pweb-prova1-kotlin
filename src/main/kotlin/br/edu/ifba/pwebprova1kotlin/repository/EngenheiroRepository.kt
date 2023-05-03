package br.edu.ifba.pwebprova1kotlin.repository

import br.edu.ifba.pwebprova1kotlin.domain.entities.Engenheiro
import org.springframework.data.repository.CrudRepository

interface EngenheiroRepository : CrudRepository<Engenheiro, Long> {}