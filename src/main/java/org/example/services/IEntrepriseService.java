package org.example.services;

import org.example.entities.Employe;
import org.example.entities.Taches;

public interface IEntrepriseService {
    Employe saveEmploye(Employe employee);
    Employe updateEmploye(Long id, Employe updatedEmployee);
    void assignerTache(Long employeId, Taches taches);
    double etatTache(Long employeId);
}
