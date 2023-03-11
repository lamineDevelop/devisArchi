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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevis;
    @ManyToOne
    private DemandeTravaux demandeTravaux;
    private Boolean devisValide;

}
