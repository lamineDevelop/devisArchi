package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.SousCategorieTravauxProposes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SousCategorieTravauxProposesRepository extends CrudRepository<SousCategorieTravauxProposes,Integer>{

  @Query(value = "SELECT * from sous_categorie_travaux_proposes where travaux_proposes =:idTravaux",
      nativeQuery = true)
  List<SousCategorieTravauxProposes> findSousCategorieTravauxProposesByIdTravaux(int idTravaux );
}
