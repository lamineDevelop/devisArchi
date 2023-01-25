package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.DemandeTravaux;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "DemandeTravaux", path = "DemandeTravaux")
public interface DemandeTravauxRepository extends PagingAndSortingRepository<DemandeTravaux,Integer> {
}
