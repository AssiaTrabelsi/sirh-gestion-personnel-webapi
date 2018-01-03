package spring.sgp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(method = RequestMethod.PUT, value = "/{matricule}")

	public boolean modifierCollab(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {

		Optional<Collaborateur> optCollab = this.collaborateurRepository.findByMatricule(matricule);

		if (optCollab.isPresent()) {

			collaborateur.setId(optCollab.get().getId());

			collaborateurRepository.save(collaborateur);

			return true;

		} else {

			return false;

		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{matricule}/banque")

	public boolean modifierBanqueCollab(@PathVariable String matricule, @RequestBody Banque banque) {

		Optional<Collaborateur> CollabOpt = this.collaborateurRepository.findByMatricule(matricule);

		if (CollabOpt.isPresent()) {

			Collaborateur collaborateur = CollabOpt.get();
			collaborateur.setBanque(banque);
			collaborateurRepository.save(collaborateur);
			return true;

		} else {

			return false;

		}
	}
}
