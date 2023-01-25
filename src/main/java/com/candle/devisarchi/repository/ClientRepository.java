package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Client", path = "Client")
public interface ClientRepository extends PagingAndSortingRepository<Client,Integer> {
}
