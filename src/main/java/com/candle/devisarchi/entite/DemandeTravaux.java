package com.candle.devisarchi.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemandeTravaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande;
    private String intitule;
    private String detail;
    private String typeTravaux;
    @ManyToOne
    private Client client;
/*
    ManyToMany
    private String listDevis;
*/}
