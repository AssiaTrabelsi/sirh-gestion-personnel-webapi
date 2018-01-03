package spring.sgp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.sgp.entitie.Collaborateur;
import spring.sgp.entitie.Departement;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	 List<Collaborateur>findByDepartement(Departement dept);
	 
	 Optional<Collaborateur> findByMatricule(String matricule);
}
