package br.edu.ifba.pwebprova1kotlin

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PwebProva1KotlinApplication {
    @Bean
    fun apiConfig(): OpenAPI = OpenAPI().info(info())

    private fun info(): Info = Info()
        .contact(contact())
        .title("API Engenharia")
        .description("API feita baseada na primeira avaliação de PWEB do IFBA, semestre 2023.1 ")

    private fun contact(): Contact = Contact()
        .email("fellipe116@gmail.com")
        .name("Luiz Felipe Tôrres")
        .url("github.com/luizfelipetorres")
}

fun main(args: Array<String>) {
    runApplication<PwebProva1KotlinApplication>(*args)
}
