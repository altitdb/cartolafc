package com.globo.cartolafc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PontuacaoPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "id_atleta")
	private Atleta atleta;
	@Column(name = "id_rodada")
	private Long idRodada;

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Long getIdRodada() {
		return idRodada;
	}

	public void setIdRodada(Long idRodada) {
		this.idRodada = idRodada;
	}

}
