package com.candle.devisarchi.controler;

import com.candle.devisarchi.entite.Devis;
import com.candle.devisarchi.repository.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/devis")
@CrossOrigin(origins = "http://localhost:4200")
public class DevisControler {

    @Autowired
    DevisRepository devisRepository;
    Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/all")
    public Iterable<Devis> getAllDevis() {
        return devisRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createDevis(@RequestBody Devis devis) {
        try {
            devisRepository.save(devis);
            logger.info("Le devis a été ajoutér " + devis);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de création du devis " + devis.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteDevis(@RequestParam int devisID) {
        try {
            devisRepository.deleteById(devisID);
            logger.info("Le devis a été supprimé id: " + devisID);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de suppression du devis " + devisID);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateDevis(@RequestBody Devis devis) {
        try {
            devisRepository.save(devis);
            logger.info("Le devis a été mis à jour " + devis);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de la mise à jour du devis " + devis.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }
}
