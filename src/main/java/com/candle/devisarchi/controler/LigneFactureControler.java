package com.candle.devisarchi.controler;

import com.candle.devisarchi.entite.LigneFacture;
import com.candle.devisarchi.repository.LigneFactureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ligneFacture")
@CrossOrigin("*")
public class LigneFactureControler {

    @Autowired
    LigneFactureRepository ligneFactureRepository;
    Logger logger  = LoggerFactory.getLogger(LigneFactureControler.class);

    @GetMapping("/all")
    public java.util.List<LigneFacture> getAllFacture() {
        return (List<LigneFacture>) ligneFactureRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createLigneFacture(@RequestBody LigneFacture ligneFacture) {
        try {
            ligneFactureRepository.save(ligneFacture);
            logger.info("La ligne de facture a été rajoutée " + ligneFacture);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de création de la ligne de facture " + ligneFacture.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteLigneFacture(@RequestParam int ligneFactureID) {
        try {
            ligneFactureRepository.deleteById(ligneFactureID);
            logger.info("La ligne de facture a été supprimée id: " + ligneFactureID);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (
                Exception e) {
            logger.warn("Erreur lors de la tentative de suppression de la ligne de facture " + ligneFactureID);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateLigneFacture(@RequestBody LigneFacture ligneFacture) {
        try {
            ligneFactureRepository.save(ligneFacture);
            logger.info("la ligne de facture a été mise à jour " + ligneFacture);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de la mise à jour de la ligne de facture " + ligneFacture.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }
}
