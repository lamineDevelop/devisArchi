package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.LigneFacture;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "LigneFacture", path = "LigneFacture")
public interface LigneFactureRepository  extends PagingAndSortingRepository<LigneFacture,Integer> {
}
