package com.candle.devisarchi.controler;

import com.candle.devisarchi.entite.SousCategorieTravauxProposes;
import com.candle.devisarchi.repository.SousCategorieTravauxProposesRepository;
import com.candle.devisarchi.repository.TravauxProposesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sousCategorieCategorieTravauxProposess")
@CrossOrigin("*")
public class SousCategorieTravauxProposessControler {

    @Autowired
    SousCategorieTravauxProposesRepository sousCategorieTravauxProposesRepository;

    @Autowired
    TravauxProposesRepository travauxProposesRepository;

    Logger logger  = LoggerFactory.getLogger(SousCategorieTravauxProposessControler.class);

    @GetMapping("/all")
    public Iterable<SousCategorieTravauxProposes> getAllCategorieTravauxProposess() {
        return sousCategorieTravauxProposesRepository.findAll();
    }

    @GetMapping("/souscategories")
    public Iterable<SousCategorieTravauxProposes> getSousCategoriesByTravauxId(@RequestParam int idTravaux) {
        return sousCategorieTravauxProposesRepository.findSousCategorieTravauxProposesByIdTravaux(idTravaux );
    }

    @PostMapping("/create")
    public ResponseEntity createCategorieTravauxProposess(@RequestBody SousCategorieTravauxProposes sousCategorieTravauxProposess) {
        try {
            sousCategorieTravauxProposesRepository.save(sousCategorieTravauxProposess);
            logger.info("Le CategorieTravauxProposess a été ajoutér " + sousCategorieTravauxProposess);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de création du CategorieTravauxProposess " + sousCategorieTravauxProposess.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteTravauxPorpose(@RequestParam int CategorieTravauxProposessID) {
        try {
            sousCategorieTravauxProposesRepository.deleteById(CategorieTravauxProposessID);
            logger.info("Le CategorieTravauxProposess a été supprimé id: " + CategorieTravauxProposessID);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de suppression du CategorieTravauxProposess " + CategorieTravauxProposessID);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateCategorieTravauxProposess(@RequestBody SousCategorieTravauxProposes sousCategorieTravauxProposess) {
        try {
            sousCategorieTravauxProposesRepository.save(sousCategorieTravauxProposess);
            logger.info("Le CategorieTravauxProposess a été mis à jour " + sousCategorieTravauxProposess);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de la mise à jour du CategorieTravauxProposess " + sousCategorieTravauxProposess.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }
}
