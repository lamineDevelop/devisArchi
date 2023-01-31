package com.candle.devisarchi;

import com.candle.devisarchi.entite.Client;
import com.candle.devisarchi.entite.DemandeTravaux;
import com.candle.devisarchi.entite.Devis;
import com.candle.devisarchi.repository.ClientRepository;
import com.candle.devisarchi.repository.DemandeTravauxRepository;
import com.candle.devisarchi.repository.DevisRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DevisArchiApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DevisArchiApplication.class, args);

        ClientRepository clientRepository = applicationContext.getBean(ClientRepository.class);
        DemandeTravauxRepository demandeTravauxRepository = applicationContext.getBean(DemandeTravauxRepository.class);
        DevisRepository devisRepository =  applicationContext.getBean(DevisRepository.class);

        Client client1 = new Client(1, "lamine1305", "17021987", "MEHIDI", "Lamine", new ArrayList<>());
        Client client2 = new Client(2, "adam1202", "28022016", "MEHIDI", "Adam", new ArrayList<>());
        List<Client> listClient = Arrays.asList(client1, client2);
        listClient.forEach(x -> clientRepository.save(x));


        DemandeTravaux demandeTravaux1 = new DemandeTravaux();
        demandeTravaux1.setClient(client1);
        demandeTravaux1.setTypeTravaux("Installation piscine ");
        demandeTravaux1.setDetail("mise en place d'une piscine de 50*70m");
        demandeTravaux1.setIntitule("Installation exterieure");
        demandeTravauxRepository.save(demandeTravaux1);

        Devis devis1 = new Devis();
        devis1.setDevisValide(true);
        devis1.setDemandeTravaux(demandeTravaux1);

        devisRepository.save(devis1);
        System.out.println("Bonjour ..... ");
    }
}
