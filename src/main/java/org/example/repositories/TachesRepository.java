package org.example.repositories;

import org.example.entities.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TachesRepository extends JpaRepository<Taches, Long> {
}
