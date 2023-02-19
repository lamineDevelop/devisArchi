package com.candle.devisarchi.repository;

import com.candle.devisarchi.entite.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    @Query("SELECT c FROM Utilisateur c where UPPER(c.userName) =UPPER(:username)")
    Utilisateur fiondByUserName(String username);
}
