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
public class TravauxProposes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer idTravaux;
  String intitule;
  String image;
}
