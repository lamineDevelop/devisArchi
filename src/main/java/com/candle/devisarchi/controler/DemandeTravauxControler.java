package com.candle.devisarchi.controler;

import com.candle.devisarchi.entite.DemandeTravaux;
import com.candle.devisarchi.repository.DemandeTravauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/demande")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeTravauxControler {

    @Autowired
    DemandeTravauxRepository demandeTravauxRepository;
    Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/all")
    public List<DemandeTravaux> getAllDemandeTravaux() {
        return (List<DemandeTravaux>) demandeTravauxRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createDemandeTravaux(@RequestBody DemandeTravaux demandeTravaux) {
        try {
            demandeTravauxRepository.save(demandeTravaux);
            logger.info("La demande de travaux  a été rajoutée " + demandeTravaux);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de création d'une deannde de travaux " + demandeTravaux.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteDemandeTravaux(@RequestParam int DemandeTravauxID) {
        try {
            demandeTravauxRepository.deleteById(DemandeTravauxID);
            logger.info("La demande  a été supprimée id: " + DemandeTravauxID);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de suppression d'une demande de travaux " + DemandeTravauxID);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateDemandeTravaux(@RequestBody DemandeTravaux demande) {
        try {
            demandeTravauxRepository.save(demande);
            logger.info("La demande de travaux  a été mise à jour " + demande);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de la mise à jour de la demande de travaux " + demande.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }
}