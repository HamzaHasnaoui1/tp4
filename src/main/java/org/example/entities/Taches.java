package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Taches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employe_id")
    private Employe employe;


}
