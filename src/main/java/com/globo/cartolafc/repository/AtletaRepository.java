package com.globo.cartolafc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globo.cartolafc.domain.Atleta;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Long> {

}