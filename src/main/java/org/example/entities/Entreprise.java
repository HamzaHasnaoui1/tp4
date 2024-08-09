package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entreprise {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String nom;

    @OneToMany( cascade = CascadeType.ALL)
    private List<Employe> employes;


}
