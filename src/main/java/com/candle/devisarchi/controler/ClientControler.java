package com.candle.devisarchi.controler;

import com.candle.devisarchi.entite.Client;
import com.candle.devisarchi.repository.ClientRepository;
import com.candle.devisarchi.utils.ArchitectureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientControler {

    @Autowired
    ClientRepository clientRepository;
    Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/all")
    public List<Client> getAllClient() {
        return (List<Client>) clientRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createClient(@RequestBody Client client) {
        try {
            clientRepository.save(client);
            logger.info("Le client a été rajouté " + client.toString());

            return ResponseEntity.status(HttpStatus.OK).body("appel ok");
        } catch (Exception e) {
            logger.warning("Erreur lors de la tentative de création du client " + client.toString());
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
            logger.warning("Erreur lors de la tentative de suppression du client " + clientID);
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
            logger.warning("Erreur lors de la tentative de la mise à jour du client " + client.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erreur interne");
        }
    }
}
