package org.example.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entities.Employe;
import org.example.entities.Status;
import org.example.entities.Taches;
import org.example.repositories.EmployeRepository;
import org.example.repositories.EntrepriseRepository;
import org.example.repositories.TachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class IEntrepriseServiceImpl implements IEntrepriseService {
private final EmployeRepository employeRepository;
private final EntrepriseRepository entrepriseRepository;
private final TachesRepository tachesRepository;

    @Override
    public Employe saveEmploye(Employe employee) {
        log.info("Saving employee " + employee.getNom());
        return employeRepository.save(employee);
    }

    @Override
    public Employe updateEmploye(Long id, Employe updatedEmployee) {
        Employe employe=employeRepository.findById(id).orElseThrow();
        employe.setNom(updatedEmployee.getNom());
        employe.setRole(updatedEmployee.getRole());
        employe.setTachesList(updatedEmployee.getTachesList());
        log.info("Updating employee " + updatedEmployee.getNom());
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public void assignerTache(Long employeId, Taches taches) {
    Employe employe=employeRepository.findById(employeId)
            .orElseThrow(() -> new IllegalArgumentException("Employé non trouvé avec l'ID: " + employeId));
    employe.getTachesList().add(taches);
    taches.setEmploye(employe);
    employeRepository.save(employe);
    }

    @Override
    public double etatTache(Long employeId) {
        Employe employe=employeRepository.findById(employeId).orElseThrow();
        long totalTaches=employe.getTachesList().size();
        long tachesTerminees=employe.getTachesList()
                .stream().filter(t -> t.getStatus().equals(Status.terminee)).count();
        if (tachesTerminees==0){
            return 0.0;
        }
        return (double) totalTaches/tachesTerminees * 100;
    }
}
