
# 🚀 API para Engenheiros e Projetos de Engenharia

Esta é uma API em Kotlin para gerenciamento de projetos de engenharia e engenheiros envolvidos nesses projetos. Essa API foi criada como parte de um projeto para a disciplina de Programação Web do IFBA.

## 📦 Instalação

Para instalar e executar a API, você precisará ter instalado em seu computador:

-   [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
-   [Kotlin](https://kotlinlang.org/docs/getting-started.html)
-   [Gradle](https://gradle.org/install/)

Depois de instalar as dependências, faça o download do projeto e execute o seguinte comando no terminal:

`gradle bootRun` 

A API estará disponível em [http://localhost:8080](http://localhost:8080/).

## :gear:  Tecnologias utilizadas 

- `spring-boot-starter-data-jpa`: Uma das dependências do Spring Boot que fornece suporte para acesso a banco de dados usando o JPA (Java Persistence API), que é uma especificação para mapeamento objeto-relacional em Java. Ele ajuda a simplificar o código necessário para acessar o banco de dados e também oferece recursos adicionais, como paginação e ordenação.

- `spring-boot-starter-hateoas`: Dependência que fornece suporte para a criação de APIs RESTful seguindo o princípio HATEOAS (Hypermedia as the Engine of Application State). Isso significa que a API incluirá links que o cliente pode seguir para descobrir mais informações e transitar entre os recursos.

- `spring-boot-starter-validation`: Dependência que fornece suporte para validação de dados de entrada em endpoints da API.

- `spring-boot-starter-web`: Dependência que fornece suporte para construção de APIs RESTful com o Spring Boot.

- `jackson-module-kotlin`: Dependência que fornece suporte para serialização e desserialização de objetos Kotlin com o Jackson, que é uma biblioteca Java para conversão entre objetos Java/Kotlin e formato JSON.

- `kotlin-reflect`: Dependência que fornece suporte para reflexão em objetos Kotlin.

- `h2`: Dependência que fornece um banco de dados relacional em memória que pode ser usado para testes e desenvolvimento.

- `springdoc-openapi-starter-webmvc-ui`: Dependência que fornece suporte para a documentação da API usando o OpenAPI 3.0 (anteriormente conhecido como Swagger). Ele permite que você exponha sua API como um arquivo JSON e o OpenAPI o usa para gerar uma documentação interativa para sua API.

## 🔗 Endpoints

### Engenheiro

- `GET /engenheiro` 
  - Retorna todos os engenheiros cadastrados.
- `GET /engenheiro/{id}` 
  - Retorna um engenheiro específico com base no ID fornecido.
- `POST /engenheiro` 
  - Cadastra um novo engenheiro.
  - Request body:
    ```
    {
      "nome": "string",
      "CREA": "string",
      "especialidade": "string"
    }
    ```
    Exemplo:
    ```
    {
      "nome": "Luiz",
      "CREA": "1234abc",
      "especialidade": "CIVIL"
    }
    ```
- `PUT /engenheiro/{id}` 
  - Atualiza as informações de um engenheiro existente com base no ID fornecido.
  - Request body:
    ```
    {
      "nome": "string",
      "CREA": "string",
      "especialidade": "string"
    }
    ```
- `DELETE /engenheiro/{id}` 
  - Remove um engenheiro existente com base no ID fornecido.

### Projeto

- `GET /projeto` 
  - Retorna todos os projetos cadastrados.
- `GET /projeto/{id}` 
  - Retorna um projeto específico com base no ID fornecido.
- `POST /projeto` 
  - Cadastra um novo projeto.
  - Request body:
    ```
    {
      "nome": "string",
      "custo": "number",
      "categoria": "string"
    }
    ```
    Exemplo:
    ```
    {
      "nome": "Projeto xpto",
      "custo": 10,
      "categoria": "PUBLICO"
    }
    ```
- `PUT /projeto/{id}` 
  - Atualiza as informações de um projeto existente com base no ID fornecido.
  - Request body:
    ```
    {
      "nome": "string",
      "custo": "number",
      "categoria": "string"
    }
    ```
- `DELETE /projeto/{id}` 
  - Remove um projeto existente com base no ID fornecido.

### Atuação

- `GET /atuacao/{id}` 
  - Retorna todos os engenheiros que atuam em um determinado projeto.
- `POST /atuacao` 
  - Adiciona um engenheiro a um projeto.
  - Request body:
    ```
    {
      "engenheiro_id": "number",
      "projeto_id": "number",
      "duracao": "number"
    }
    ```
    Exemplo:
    ```
    {
      "engenheiro_id": 1,
      "projeto_id": 1,
      "duracao": 1
    }
    ```
- `DELETE /atuacao/{id}` 
  - Remove um engenheiro de um projeto.

## 🤝 Contribuição

Se você quiser contribuir com o projeto, sinta-se à vontade para enviar um pull request.

## 📧 Contato

Se você tiver alguma dúvida ou sugestão, pode entrar em contato com o autor do projeto pelo e-mail: [fellipe116@gmail.com](mailto:fellipe116@gmail.com).
