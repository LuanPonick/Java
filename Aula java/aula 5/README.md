## Aprofundando em testes.
os teste unitarios são feiotos na pasta test.
Toda função que tem aver com teste tem uma assinatura de @Test sobre ela.
### O salvador de dados!
<sub>no caso do banco de dados</sub>
para realizar um salvamento ao banco de dados nos temos que ter alguem objeto com uma codecoração de entityManager como por exemplo um repository ou um proprio entitymanager.

### @autowire
O autowire é basicamente um objeto que foi criado uma vez e é guardado na memoria para outros usarem tambem por exemplo tempo uma classe que é estanciada em 3 scipts diferentes e caso ela não eteje com o autowire ela sera criada 3 vezes mas caso o autowire esteje ativo ela não precisara ser criada 3 vez.

>## assertThat
>># Utilidade
>>Isso serve para se fazer um teste UNITARIO. 
># Instalação
>> Para se utilizar essa função se deve ter importado essa dependencia
>>~~~xml
>><dependency>
>>	<groupId>org.assertj</groupId>
>>	<artifactId>assertj-core</artifactId>
>>	<scope>test</scope>
>></dependency>
>>~~~
>>Com essa dependencia rodando no projeto basta apenas usar a seguinte importação
>>~~~Java
>>import static org.assertj.core.api.Assertions.*;
>>~~~
>>com essas 2 partes ok voce ja consegue utilizar a função assertThat
># Utilizando
>>O assert that significa afirmar que com essa fraze estabelcida na cabeça fica mais facil de entender sua função.
>>~~~Java
>> assertThat(clientesbuscados.get(2).getEmail()).isEqualTo(cli.getEmail());
>>~~~
>>Basicamente assertThat(pergunta)isEqualTo(consulta)
>>
>>---
