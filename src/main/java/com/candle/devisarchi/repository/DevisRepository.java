package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.Devis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends CrudRepository<Devis,Integer> {
}
