package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.Devis;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Devis", path = "Devis")
public interface DevisRepository extends PagingAndSortingRepository<Devis,Integer> {
}
