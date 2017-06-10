package com.globo.cartolafc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Destaque implements Serializable {

    private static final long serialVersionUID = 23L;
    
    @Id
    @Column(name = "id_destaque")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_atleta")
    @JsonProperty(value = "Atleta")
    private Atleta atleta;
    private String escalacoes;
    private String clube;
    @JsonProperty(value = "escudo_clube")
    private String escudoClube;
    private String posicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public String getEscalacoes() {
        return escalacoes;
    }

    public void setEscalacoes(String escalacoes) {
        this.escalacoes = escalacoes;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getEscudoClube() {
        return escudoClube;
    }

    public void setEscudoClube(String escudoClube) {
        this.escudoClube = escudoClube;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

}
