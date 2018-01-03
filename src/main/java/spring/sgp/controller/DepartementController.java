package spring.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.sgp.entitie.Departement;
import spring.sgp.repository.DepartementRepository;



@RestController
@RequestMapping("api/departements")
public class DepartementController {
	
	@Autowired
	private DepartementRepository departementRepository;
	

	@GetMapping
	public List<Departement> listerdepartements() {
		return this.departementRepository.findAll();
	}
}
