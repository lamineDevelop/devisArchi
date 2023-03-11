package com.candle.devisarchi.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SousCategorieTravauxProposes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer idSousCategorieTravaux;
  String intitule;
  String image;
  float prix;

  @ManyToOne
  TravauxProposes travauxProposes;
}
