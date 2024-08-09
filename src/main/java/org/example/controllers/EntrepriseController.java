package org.example.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.Employe;
import org.example.entities.Entreprise;
import org.example.entities.Taches;
import org.example.services.IEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employes")
public class EntrepriseController {
    @Autowired
    private IEntrepriseService entrepriseService;

    @GetMapping("/saveEmploye")
    //@PreAuthorize("hasAuthority('Admin')")
    public Employe saveEmploye(@RequestBody Employe employe) {
        return entrepriseService.saveEmploye(employe);
    }

    @PutMapping("/updateEmploye/{id}")
    //@PreAuthorize("hasAuthority('Admin')")
    public Employe updateEmploye(@PathVariable Long id,@RequestBody Employe employe) {
        return entrepriseService.updateEmploye(id,employe);
    }

    @PostMapping("/{id}/taches")
    public void assignTache( @PathVariable Long employeId ,@RequestBody Taches taches) {
       entrepriseService.assignerTache(employeId,taches);
    }

    @GetMapping("/etat")
    public double etatAvancement(@PathVariable Long employeId) {
        return entrepriseService.etatTache(employeId);
    }

}
