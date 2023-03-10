## Dependecias
para se fazer uma mesclagem do nosso banco de dados que sera usado se deve primeiro configurar as dependecias. No caso sera utilizado o banco de dados postgresql. E para dizer ao sprindo que nos usaremos o postgresql devemos colocar no arquivp de dependecias(pom.xml) que queremos utilizar.Para fazer isso é super simples basta abrir o arquivo xml e colocar a seguinte dependencia dentro da "tag" \<dependencies\> 
### ex:
~~~xml
(...)
</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
		</dependency>
        (...)
    (...)
(...)
~~~
<sub>No caso foi posto a dependency org.postgresql.</sub>

## Configurando o banco de dados.
No caso quando é colocado a dependecia necessaria ao projeto podemos começar a configuração da conexão do banco. E para começar se deve abrir o arquivo que esta na parsta resources e abrir o arquivo application.properietes
<center><img src="./01.png"></center>
<br>
é entrando nesse arquivo nos temos que fazer algumas configurações sendo elas

### Configurações 
<center><img src="./02.png"></center>

>spring.datasource.url=jdbc:postgresql://localhost:5432/estudos<br>
>><sub>tem a utilidade de dizer onde estao banco de dados.</sub>
>
>spring.datasource.password=123456789
>spring.datasource.username=postgres
>><sub>Configuração da senha e o "nome do servidor"</sub>
>
>spring.jpa.hibernate.ddl-auto=update
>><sub>Tem a utilidade de dizer que caso não haja uma determinada tabela ou atributo sera criado automaticamente antes de executar um comando sql.</sub>
>
>spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
>><sub>Tem a utilidade de dizer qual dialeto/banco_de_dados esta sendo usado.</sub> 
