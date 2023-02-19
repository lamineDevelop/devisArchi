package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.LigneFacture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneFactureRepository  extends CrudRepository<LigneFacture,Integer> {
}
