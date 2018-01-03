package spring.sgp.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.sgp.entitie.Banque;
import spring.sgp.entitie.Collaborateur;

import spring.sgp.repository.CollaborateurRepository;
import spring.sgp.repository.DepartementRepository;

@RestController
@RequestMapping("api/collaborateurs")
public class CollaborateursController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private DepartementRepository departementRepository;

	public List<Collaborateur> listercollaborateurs() {
		return this.collaborateurRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Collaborateur> getCollabId(@RequestParam(value = "departement", required = false) Integer dept_id) {
		return dept_id == null ? listercollaborateurs()
				: collaborateurRepository.findByDepartement(departementRepository.findOne(dept_id));

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{matricule}")

	public Collaborateur getCollabMatricule(@PathVariable String matricule) {

		return collaborateurRepository.findByMatricule(matricule).orElse(null);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{matricule}/banque")

	public Banque getBankCollab(@PathVariable String matricule) {
		Optional<Collaborateur> collabOpt = collaborateurRepository.findByMatricule(matricule);
		if (collabOpt.isPresent()) {
			return collabOpt.get().getBanque();
		} else {
			return null;
		}
	}

		}
