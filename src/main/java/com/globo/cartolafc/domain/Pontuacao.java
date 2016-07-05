package com.globo.cartolafc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Pontuacao implements Serializable {

	private static final long serialVersionUID = 23L;
	@Id
	@JsonIgnore
	private PontuacaoPK pontuacaoPK = new PontuacaoPK();
	@Transient
	@JsonProperty(value = "atleta_id")
	private Long idAtleta;
	@Transient
	@JsonProperty(value = "rodada_id")
	private Long idRodada;
	private BigDecimal pontos;
	@Transient
	private BigDecimal preco;
	@Transient
	private BigDecimal variacao;
	@Transient
	private BigDecimal media;

	public Atleta getAtleta() {
		return pontuacaoPK.getAtleta();
	}

	public void setAtleta(Atleta atleta) {
		this.pontuacaoPK.setAtleta(atleta);
	}

	public Long getIdRodada() {
		return pontuacaoPK.getIdRodada();
	}

	public void setIdRodada(Long idRodada) {
		this.pontuacaoPK.setIdRodada(idRodada);
	}

	public BigDecimal getPontos() {
		return pontos;
	}

	public void setPontos(BigDecimal pontos) {
		this.pontos = pontos;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getVariacao() {
		return variacao;
	}

	public void setVariacao(BigDecimal variacao) {
		this.variacao = variacao;
	}

	public BigDecimal getMedia() {
		return media;
	}

	public void setMedia(BigDecimal media) {
		this.media = media;
	}

}
