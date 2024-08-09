package org.example;

import org.example.entities.*;
import org.example.repositories.EntrepriseRepository;
import org.example.services.IEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp4Application {
    @Autowired
    private IEntrepriseService entrepriseService;

    public static void main(String[] args) {
        SpringApplication.run(Tp4Application.class, args);
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    @Bean
    CommandLineRunner start() {
        return args -> {
            Employe employe1 = new Employe();
            employe1.setId(2L);
            employe1.setNom("hamza");
            employe1.setRole(Role.admin);
            entrepriseService.saveEmploye(employe1);
            System.out.println(employe1);

            employe1.setNom("adil");
            entrepriseService.updateEmploye(2L,employe1);
            System.out.println(employe1.getNom());


            LocalDateTime dateDebut = LocalDateTime.parse("24/10/2010 08:00", formatter);
            LocalDateTime dateFin = LocalDateTime.parse("01/12/2011 10:00", formatter);

            Taches tache1 = new Taches();
            tache1.setTitre("Test");
            tache1.setStatus(Status.non_terminee);
            tache1.setDescription("Test description");
            tache1.setDateDebut(dateDebut);
            tache1.setDateFin(dateFin);
            tache1.setEmploye(employe1);
            entrepriseService.assignerTache(employe1.getId(), tache1);


            Taches tache2 = new Taches();
            tache2.setTitre("Test2");
            tache2.setStatus(Status.non_terminee);
            tache2.setDescription("Test description");
            tache2.setDateDebut(dateDebut);
            tache2.setDateFin(dateFin);
            tache2.setEmploye(employe1);
            entrepriseService.assignerTache(employe1.getId(), tache2);


            Taches tache3 = new Taches();
            tache3.setTitre("Test3");
            tache3.setStatus(Status.terminee);
            tache3.setDescription("Test description");
            tache3.setDateDebut(dateDebut);
            tache3.setDateFin(dateFin);
            tache3.setEmploye(employe1);
            entrepriseService.assignerTache(employe1.getId(), tache3);


            Taches tache4 = new Taches();
            tache4.setTitre("Test4");
            tache4.setStatus(Status.terminee);
            tache4.setDescription("Test description");
            tache4.setDateDebut(dateDebut);
            tache4.setDateFin(dateFin);
            tache4.setEmploye(employe1);
            entrepriseService.assignerTache(employe1.getId(), tache4);


            Taches tache5 = new Taches();
            tache5.setTitre("Test5");
            tache5.setStatus(Status.non_terminee);
            tache5.setDescription("Test description");
            tache5.setDateDebut(dateDebut);
            tache5.setDateFin(dateFin);
            tache5.setEmploye(employe1);
            entrepriseService.assignerTache(employe1.getId(), tache5);



            double pourcentage = entrepriseService.etatTache(employe1.getId());
            System.out.println("Pourcentage des tâches terminées : " + pourcentage + "%");
        };


    }
}
