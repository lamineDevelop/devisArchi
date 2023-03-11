package com.candle.devisarchi.controler;

import com.candle.devisarchi.entite.Client;
import com.candle.devisarchi.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
@CrossOrigin("*")
public class ClientControler {

    @Autowired
    ClientRepository clientRepository;

    Logger logger  = LoggerFactory.getLogger(ClientControler.class);

    @GetMapping("/all")
    public List<Client> getAllClient() {
        logger.info("List des client ");

        return (List<Client>) clientRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createClient(@RequestBody Client client) {
        try {
            clientRepository.save(client);
            logger.info("Le client a été rajouté " + client.toString());

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de création du client " + client.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity deleteClient(@RequestParam int clientID) {
        try {
            clientRepository.deleteById(clientID);
            logger.info("Le client a été supprimé id: " + clientID);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de suppression du client " + clientID);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client) {
        try {
            clientRepository.save(client);
            logger.info("Le client a été mis à jour " + client);

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warn("Erreur lors de la tentative de la mise à jour du client " + client.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }
}
