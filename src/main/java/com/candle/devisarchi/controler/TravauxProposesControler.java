package com.candle.devisarchi.controler;

import com.candle.devisarchi.entite.TravauxProposes;
import com.candle.devisarchi.repository.TravauxProposesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/travauxProposes")
@CrossOrigin("*")
public class TravauxProposesControler {

    @Autowired
    TravauxProposesRepository TravauxProposesRepository;
    Logger logger  = LoggerFactory.getLogger(TravauxProposesControler.class);

    @GetMapping("/all")
    public Iterable<TravauxProposes> getAllTravauxProposes() {
        return TravauxProposesRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createTravauxProposes(@RequestBody TravauxProposes travauxProposes) {
        try {
            TravauxProposesRepository.save(travauxProposes);
            logger.info("Le TravauxProposes a été ajoutér " + travauxProposes);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de création du TravauxProposes " + travauxProposes.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteTravauxPorpose(@RequestParam int travauxProposesID) {
        try {
            TravauxProposesRepository.deleteById(travauxProposesID);
            logger.info("Le TravauxProposes a été supprimé id: " + travauxProposesID);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de suppression du TravauxProposes " + travauxProposesID);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateTravauxProposes(@RequestBody TravauxProposes travauxProposes) {
        try {
            TravauxProposesRepository.save(travauxProposes);
            logger.info("Le TravauxProposes a été mis à jour " + travauxProposes);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de la mise à jour du TravauxProposes " + travauxProposes.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }
}
