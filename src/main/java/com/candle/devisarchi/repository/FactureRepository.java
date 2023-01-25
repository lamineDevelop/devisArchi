package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.Facture;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Facture", path = "Facture")
public interface FactureRepository extends PagingAndSortingRepository<Facture,Integer> {

}
