package com.candle.devisarchi.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDevis;
    @ManyToOne
    // déclaration d'une table d'association
    @JoinTable(name = "devis_travaux", joinColumns = @JoinColumn(name = "ID_DEVIS"), inverseJoinColumns = @JoinColumn(name = "ID_DEMANDE"))
    private DemandeTravaux demandeTravaux;
    private Boolean devisValide;
}
