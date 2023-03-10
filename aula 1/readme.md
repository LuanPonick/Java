# Frame Work
jdbc == api basica de persistencia 

jpa == jdc

## Persistencia a bancos de dados java.
Para se realizar persistencia a banco de dados se usava o jdbc que ele é estruturadado por 4 partes
>| jbdc  | utilidade |
>| ------------- | ------------- |
>| driver manager| ...      |
>|  conenction   | ... |
>|  statiment    | Executa o comando sql |
>|  result set   | Resebe o resultado da persistencia|
>---
mas o jpa veio para facilitar a vida escondendo a uma parte do jbdc 
## JPA
<sub>java persisten api</sub>
o jpa é um modelo de persistencia que pode ser implementado por algumas formas sendo uma delas o hibernate

## framework
o frame work nada mais é que uma solução generica que pode ser usada em diversos projetos diferentes

## hibernate
O hibernate tem uma serie de ferramentas voltadas para persistencia em banco de dados sendo uma delas o proprio @entity que fala basicamente que a classe que estara abaixo da assinatura tera uma tabela no banco de dados.e para fazer a parte do crud nos temos o entity manager que faz essa parte do crud sendo que para ele funcionar basta apenas a configuração do persistence.xml que é feita pelo entitymanegerfactore

![exemplo](./exemplo%20rela%C3%A7%C3%A3o%20entidade.jpg)