package com.globo.cartolafc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Atleta implements Serializable {

	private static final long serialVersionUID = 23L;
	@Id
	@Column(name = "id_atleta")
	@JsonProperty(value = "atleta_id")
	private Long id;
	private String nome;
	private String apelido;
	@JsonProperty(value = "status_id")
	private Integer status;
	@JsonProperty(value = "posicao_id")
	private Integer posicao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

}
