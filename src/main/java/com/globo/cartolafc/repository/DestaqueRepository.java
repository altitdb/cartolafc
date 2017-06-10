package com.globo.cartolafc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globo.cartolafc.domain.Destaque;

@Repository
public interface DestaqueRepository extends JpaRepository<Destaque, Long> {

}