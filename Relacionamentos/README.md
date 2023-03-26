#Coisas

---

# @Table !
## Nome Tabela ?
No _@Table_ pode se fazer uma configuração para se forçar um nome para uma tabela.
~~~Java
@Entity
@Table(name = "professor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String prontuario;
}

~~~

---

# @Colum !
## Não pode ser null ?
Para realizar tal configuração basta apenas acima do atributo colocar a anotação da seguinte forma.
~~~Java
@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String prontuario;
}
~~~
# Valores unicos ?
Para realizar tal configuração basta apenas acima do atributo colocar a anotação da seguinte forma.
~~~java
@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String prontuario;
}
~~~

---
# Depreciado 
Para falar que determinada função não deve ser usada muito basta apenas adicionar a @Deprecated acima da fução 
~~~Java
@Deprecated
    public Profesor() {}
~~~

---
# Repository
Ele serve para basicamente ser um repositorio de interaçoes com o banco de dados.<br>
O repository é basicamente uma interface que estende uma inteface do JPA denominada de _JpaRepository_
~~~Java
@Repository
public interface ProfessorRepository extends JpaRepository<Profesor,Long>
{

}
~~~
Dentro do diamante se passa primeiro a classe que sera baseada e logo ao lado o tipo do atributo id.

---
# Rodando na classe main
Para nos conseguirmos rodar comandos simples na classe main de uma forma mais simples basta apenas utilizar o segunte codigos
~~~Java
@SpringBootApplication
public class RelacionamentosApplication implements CommandLineRunner {
	@Autowired
	ProfessorRepository professorRepository;

	public static void main(String[] args) {
		SpringApplication.run(RelacionamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profesor profesor = new Profesor("Samuka","xyz");
        //Bla Bla Bla
	}
}

~~~
<!-->
Notas do escritor

o fk fica salva na parte de muitas
<---->
# Relação 
As relaçoes de tabelas sao feitas usando @ManyToOne - @OneToMany - @OneToOne - @ManyToMany.<br>
Para se fazer uma relação basica basta adicionar acima de um atributo
~~~java
@ManyToOne
    private Profesor profesor;
~~~
## @ManyToOne - @OneToMany
Para se realizar uma relação de ManyToOne para OneToMany é interessante salientar primeiro o "fk" fica principalemte na classe considerada many
<sub> Bem no caso todo os codigos desse artigo se baseam nesse modelo de relacionamento</sub><br>
O codigo que sera possivel ver abaixo utiliza esse relacionamento
<center>
<img src="01.jpg">
</center>

Modelo de diciplina
~~~java
package com.Java.Relacionamentos.model;

import javax.persistence.*;

@Entity
@Table(name = "diciplinas")
public class Diciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String semestre;

    @ManyToOne
    private Profesor profesor;

    @Deprecated
    public Diciplina(){}

    public Diciplina(String name, String semestre) {
        this.name = name;
        this.semestre = semestre;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}

~~~

modelo de professor

~~~java
package com.Java.Relacionamentos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    private String prontuario;

    @OneToMany
    private List<Diciplina> diciplinas;

    @Deprecated
    public Profesor() {}

    public Profesor(String nome, String prontuario) {
        this.nome = nome;
        this.prontuario = prontuario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prontuario='" + prontuario + '\'' +
                '}';
    }
}
~~~

Caso seje criado dessa forma os 2 models nos teremos um certo "problema" que é simplesmente o fato que sera criado uma nova tabela no nosso banco de dados que estara dizendo como funciona esse relacionameto e isso não é interesante para o momento autual. E para resolver esse problema basta apenas fazer as seguintes alteraçoes<br>
no arquivo "Many" no caso o **Diciplina**
~~~java
(...)
@ManyToOne
    @JoinColumn(name = "professor_id",nullable = true)
    private Profesor profesor;
(...)
~~~

Professor
~~~java
(...)
@OneToMany(mappedBy = "profesor")
    private List<Diciplina> diciplinas;
(...)
~~~
## Feath - pesquisa / mappedBy
O fetch nada mais que como se foce pesquisa ou busca.

Ele serve para dizer se determinado atributo tem que fazer uma buscar em uma outra tabela ou não.

arquivo **Professor**
~~~Java
@OneToMany(mappedBy = "profesor",fetch = FetchType.EAGER)
    private List<Diciplina> diciplinas;
~~~

Nesse casp esta sendo dito que o atributo diciplina PRECISA fazer essa busca na tabela

Caso o mappedBy não seje colocado ele semrpe nao ira retornar nada.

No mappedBy se é colocado o nome do atributo da tabela que sera feita a busca como mostra no exemplo abaixo

**Professor**
~~~java
@OneToMany(mappedBy = "profesor",fetch = FetchType.EAGER)
    private List<Diciplina> diciplinas;
~~~

**Diciplina**
~~~java
@ManyToOne
    @JoinColumn(name = "professor_id",nullable = true)
    private Profesor profesor;
~~~

## Cascate @PreRemove
O cascete tem varias funçoes e entre elas temos uma chamada de :

###  cascade = CascadeType.ALL
Isso fara que quando um atributo se deletado ele delete todas as tuplas atreladas a ele.
**Professor**
~~~java
@OneToMany(mappedBy = "profesor",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Diciplina> diciplinas;
~~~
### @PreRemove
O @PreRemove ele é uma função que sera chamada toda vez que a tupla for ser apagada.
~~~java
@PreRemove
    private void DeletarProfessor(){
        for (Diciplina diciplina : this.getDiciplinas()){
            diciplina.setProfesor(null);
        }
    }
~~~
com essa funcao antes da tupla ser apagada ela faz que todas as diciplinas atreladas a essa tupla seje colocadas como null.
