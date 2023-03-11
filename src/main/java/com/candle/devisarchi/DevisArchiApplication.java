package com.candle.devisarchi;

import com.candle.devisarchi.entite.Client;
import com.candle.devisarchi.entite.DemandeTravaux;
import com.candle.devisarchi.entite.Devis;
import com.candle.devisarchi.entite.Utilisateur;
import com.candle.devisarchi.repository.ClientRepository;
import com.candle.devisarchi.repository.DemandeTravauxRepository;
import com.candle.devisarchi.repository.DevisRepository;
import com.candle.devisarchi.repository.UtilisateurRepository;
import com.candle.devisarchi.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DevisArchiApplication extends WebMvcConfigurationSupport {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DemandeTravauxRepository demandeTravauxRepository;
    @Autowired
    DevisRepository devisRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    MailService mailService;
    @PostConstruct
    public void init() throws MessagingException {

        Client client1 = new Client(1, "lamine1305", "17021987", "MEHIDI", "Lamine");
        Client client2 = new Client(2, "adam1202", "28022016", "MEHIDI", "Adam");
        List<Client> listClient = Arrays.asList(client1, client2);
        clientRepository.saveAll(listClient);

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

        List<Utilisateur> utilisateurs = Stream.of(new Utilisateur(101,"","",""),
                new Utilisateur(102,"lamine","17021987","lamine1305@gmail.com"),
                new Utilisateur(103,"adam","28022016","adam1305@gmail.com")
        ).collect(Collectors.toList());

        utilisateurRepository.saveAll(utilisateurs);

/*
        //Envoi de mail
        mailService.sendMail("bessaa.amirouche@outlook.fr",
                "envoi de mail depuis le backend",
                "contenu",
               "C:\\Users\\PRIVE\\Documents\\factures\\doc.pdf" );

 */
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DevisArchiApplication.class, args);

        System.out.println("Bonjour ..... ");
    }
}
