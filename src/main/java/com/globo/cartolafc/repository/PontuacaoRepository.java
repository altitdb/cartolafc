package com.globo.cartolafc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globo.cartolafc.domain.Pontuacao;
import com.globo.cartolafc.domain.PontuacaoPK;

@Repository
public interface PontuacaoRepository extends JpaRepository<Pontuacao, PontuacaoPK> {

}