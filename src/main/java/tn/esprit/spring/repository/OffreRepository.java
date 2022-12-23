package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Offre;



public interface OffreRepository extends JpaRepository<Offre, Long> {

}
