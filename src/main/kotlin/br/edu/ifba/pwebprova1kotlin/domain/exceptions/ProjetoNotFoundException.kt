package br.edu.ifba.pwebprova1kotlin.domain.exceptions

import org.springframework.http.HttpStatus

class ProjetoNotFoundException() : GenericException("Projeto não encontrado!", HttpStatus.BAD_REQUEST)