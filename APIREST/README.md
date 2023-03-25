# Fonte 
https://www.youtube.com/watch?v=aEAFpQfcu-0&list=PLg5-aZqPjMmAjcS-7lDTdWry9_KvappUF&index=7

Visto as ultiams 3 aula

---

# Rest
É um modelo de arquitetura que permite a criação de backends iguais para todos os tipos de plataforma ex desktop, web, mobile etc.<br>
E para que haja essa transação os dados são transmitidos atravez de um formato unicochamado de json.Mas a principal utilidade do json é a utilização dos protocolos http:
| http |Sql|
|------|--------|
| Get | Consulta |
| Post | Inserção |
| Put | Alteração |
| Delete | Remoção |

## Assinaturas de banco de dados
Para poder utilizar as assinaturas como @Entity entre outras se de intalar a biblioteca 
## API REST
A classeRest é focada em gerenciar as requisiçoes; 
><strong>Spring data JPA</strong>
>>~~~XML
>><dependency>
>>    <groupId>org.springframework.boot</groupId>
>>    <artifactId>spring-boot-starter</artifactId>
>></dependency>
>><dependency>
>>    <groupId>org.springframework.boot</groupId>
>>    <artifactId>spring-boot-starter-data-jpa</artifactId>
>></dependency>
>>~~~
>---

## Assinaturas 
|@|utilidade|
|---|----|
| @Id | Tem a utilidade de dizer que o atributo abaixo sera uma chave primaria|
|@GenerateValue()|Diz que o valor sera auto incrementado|
|@GeneratedValue(strategy = GenerationType.IDENTITY)| Diz que o valor auto incrementado tem uma determinada estrategia.|
|@Column()|Dira que o atributo abaixo tera que respeitar determinada configuração |
|@Column(nullable = false)|Esta dizendo que o atributo abaixo tem uma regra no banco de dados que diz que ele nao pode ser nulo.|

## Configurando porta diferente spring
Para fazer isso basta apenas entrar no application.properties e colocar o seguinte comando :
~~~properties
server.port = 8090
~~~ 

##