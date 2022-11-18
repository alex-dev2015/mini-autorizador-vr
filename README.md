<h1>Mini Autorizador VR </h1>
<p> Sejam bem-vindos ao projeto teste que simula as transações básicas de um mini autorizador de cartão, usando o framework <strong>Spring Boot</strong>.<br>

## Índice

- [Objetivo](#objetivo)
- [Pré-requisitos](#requisitos)
- [Executando o Projeto](#usage)
- [Documentação](#docs)
- [Tecnologias Utilizadas](#utils)
- [Anotações de Mapeamento](#maps)
- [Links](#links)
- [Licença](#licence)
- [Autor](#autor)

## 🎯 Objetivo do Projeto <a name = "objetivo"></a>

<p>O projeto trata-se de uma <strong>API REST</strong> usando padrão de projeto <strong>DTO</strong> com a abordadem de mapeamento objeto relacional (ORM) usando o <strong>Spring Data JPA,</strong> o <strong>Maven</strong> como gerador 
de dependências, <strong>o Lombok</strong> que faz a ligação dos métodos acessores, sem ter que incluir explicitamente os Getter's e Setter's e por fim a documentação com o <strong>Swagger</strong>.</p>

## 🛑 Pré-requistos para rodar o Projeto <a name = "requisitos"></a>

- [x] GIT

- [x] Docker

## Executando o Projeto <a name = "usage"></a>

Para ter uma cópia do projeto, basta realizar o clone deste repositório e prosseguir com os passos seguintes.
```
  git clone https://github.com/alex-dev2015/mini-autorizador-vr
```

Executando o docker

```
  docker-compose up -d --build
```

Após o subir o servidor, instale as dependências do projeto usando o maven
```
  mvn install    
```

Caso não tenha uma IDE para executar o projeto, use o seguinte comando para subir o servidor do spring 
```
  mvn spring-boot:run   
```


## Visualizar a documentação <a name = "docs"></a>

```
  http://localhost:8080/swagger-ui.html
```

![Documentacao](https://github.com/alex-dev2015/mini-autorizador-vr/blob/main/src/main/java/vr/miniautorizador/utils/imagens/swagger.PNG)

## 🛠 Tecnologias Utilizadas</h2> <a name = "utils"></a>

<ul>
    <li>IDE IntelliJ</li>
    <li>Java 11</li>
    <li>Maven</li>
    <li><strong>Spring Web</strong></li>
    <li><strong>Spring Data JPA</strong></li>
    <li><strong>MySQL Driver</strong></li>
    <li><strong>Hibernate Validator</strong></li>
    <li>Lombok</li>
    <li>Insomnia</li>
    <li>Swagger</li>
</ul>

## 🎈 Anotações de Mapeamento <a name = "maps"></a>

<strong>@Entity</strong>
Usada para especificar que a classe anotada atualmente representa um tipo de entidade.

<strong>@Table</strong>
Usada para especificar a tabela principal da entidade atualmente anotada.

<strong>@Id</strong>
Especifica o identificador da entidade. Uma entidade deve sempre ter um atributo identificado.

<strong>@GeneratedValue</strong>
Especifica que o valor do identificador de entidade é gerado automaticamente.

<strong>@Column</strong>
Usada para especificar o mapeamento entre um atributo de entidade básico e a coluna da tabela de banco de dados.


## 🔗 Links Úteis <a name = "links"></a>
<ul>
    <li><a href="https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.6.1&packaging=jar&jvmVersion=11&groupId=me.dio.academia&artifactId=academia-digital&name=academia-digital&description=Tutorial%20API%20RESTful%20modelando%20sistema%20de%20academia%20de%20gin%C3%A1stica&packageName=me.dio.academia.digital&dependencies=web,data-jpa,postgresql,validation,lombok">Spring Initializr</a></li>
    <li><a href="https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/common-application-properties.html">Common application properties</a></li>
    <li><a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories">Spring Data JPA - Reference Documentation</a></li>
    <li><a href="https://swagger.io/">Swagger - API Documentation</a></li>

</ul>


## 📜 Licença <a name = "licence"></a>

Este projeto está sob licença MIT. Veja o arquivo [LICENSE](LICENSE.md) para mais detalhes.

## ✍️Autor <a name = "autor"></a>

 <a href="https://github.com/alex-dev2015" target="_blank">Alex Sousa</a>

&#xa0;

<a href="#top">Voltar para o topo</a>

------------






