package spring.sgp.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Collaborateur>getCollabId(@RequestParam(value = "departement", required=false) Integer dept_id) {
		return dept_id == null ? listercollaborateurs() : collaborateurRepository.findByDepartement(departementRepository.findOne(dept_id));

	}
	
	
}

	

	
