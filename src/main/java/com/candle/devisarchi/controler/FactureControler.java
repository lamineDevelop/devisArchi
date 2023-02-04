package com.candle.devisarchi.controler;

import com.candle.devisarchi.entite.Facture;
import com.candle.devisarchi.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/facture")
@CrossOrigin(origins = "http://localhost:4200")
public class FactureControler {

    @Autowired
    FactureRepository factureRepository;
    Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/all")
    public List<Facture> getAllFacture() {
        return (List<Facture>) factureRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createFacture(@RequestBody Facture facture) {
        try {
            factureRepository.save(facture);
            logger.info("La facture a été rajoutée " + facture);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de création de la facture " + facture.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteFacture(@RequestParam int factureID) {
        try {
            factureRepository.deleteById(factureID);
            logger.info("La facture a été supprimée id: " + factureID);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de suppression de la   facture " + factureID);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateFacture(@RequestBody Facture facture) {
        try {
            factureRepository.save(facture);
            logger.info("la facture a été mise à jour " + facture);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de la mise à jour  de la facture " + facture.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @GetMapping(path = "/image/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getImageFacture(@PathVariable("id") Long id) throws Exception {
        try {
            return Files.readAllBytes(Paths.get("data_architecture/data_architecture/doc_" + id + ".pdf"));
        } catch (Exception e) {
            logger.warning("la facture demandée n'existe pas" + e.getMessage());
        }
        return new byte[0];
    }

    @GetMapping(path = "/images/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getImageFacture2(@PathVariable("id") Long id) throws Exception {
        try {
            return Files.readAllBytes(Paths.get("data_architecture/doc_" + id + ".pdf"));
        } catch (Exception e) {
            logger.warning("la facture demandée n'existe pas " + e.getMessage());
        }
        return new byte[0];
    }
}