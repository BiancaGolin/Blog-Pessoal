package org.generation.blogPessoal.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

//Entity = indica que vai ser uma entidade do jpa hibernate
//Table = essa entidade dentro do BD vai virar uma tabela, e o name sera postagem
@Entity 
@Table(name="postagem")
public class Postagem {
	
	//definindo que o atributo ID será uma primary key e de auto incremento
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//esse atributo nao pode ser nulo e tem um tamanho fixo de minimo e maximo de caracteres possiveis
	@NotNull
	@Size(min = 5, max = 100)
	private String titulo;
	
	//esse atributo nao pode ser nulo e tem um tamanho fixo de minimo e maximo de caracteres possiveis
	@NotNull
	@Size(min = 10, max = 500)
	private String texto;
	
	//forma de se trabalhar com datas
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
}
