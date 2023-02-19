package com.candle.devisarchi.service;

import com.candle.devisarchi.entite.Utilisateur;
import com.candle.devisarchi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UtilisateurDetailsService implements UserDetailsService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.fiondByUserName(username);
       return new org.springframework.security.core.userdetails.User(utilisateur.getUserName(),utilisateur.getPassword(),new ArrayList<>());
    }

}
