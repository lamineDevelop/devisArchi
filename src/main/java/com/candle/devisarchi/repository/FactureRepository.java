package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Integer> {

}
