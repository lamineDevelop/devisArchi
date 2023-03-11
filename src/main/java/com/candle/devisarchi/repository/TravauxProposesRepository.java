package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.TravauxProposes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravauxProposesRepository extends CrudRepository<TravauxProposes, Integer> {

}
