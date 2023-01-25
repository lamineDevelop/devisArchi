package com.candle.devisarchi.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LigneFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLigneFacture;
    private String intituleLigne;
    private String descriptionLigne;
    private Double montantLigneAvantTTC;
    private Double montantLigneAvantHT;
}
