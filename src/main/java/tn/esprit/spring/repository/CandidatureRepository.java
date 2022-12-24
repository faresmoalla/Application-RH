package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Candidature;


public interface CandidatureRepository  extends JpaRepository<Candidature, Long> {

}
