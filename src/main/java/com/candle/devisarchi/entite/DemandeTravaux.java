package com.candle.devisarchi.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemandeTravaux {
    @Id
    private int idDemande;
    private String intitule;
    private String detail;
    private String typeTravaux;
    @ManyToOne
    // déclaration d'une table d'association
    @JoinTable(name = "DEMANDE_CLIENT",
            joinColumns = @JoinColumn(name = "ID_DEMANDE"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLIENT"))
    private Client client;

}
