package spring.sgp.listenner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import spring.sgp.entitie.Banque;
import spring.sgp.entitie.Collaborateur;
import spring.sgp.entitie.Departement;
import spring.sgp.repository.CollaborateurRepository;
import spring.sgp.repository.DepartementRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	CollaborateurRepository collaborateurRepository;
	@Autowired
	DepartementRepository departementRepository;

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		// creation departement
		Departement dept = new Departement();
		dept.setNom("informatique");
		Departement dept1 = new Departement();
		dept1.setNom("Comptabilité");
		Departement dept2 = new Departement();
		dept2.setNom("RH");
		List<Departement> departements = new ArrayList<>();
		departements.add(dept);
		departements.add(dept1);
		departements.add(dept2);

		departementRepository.save(departements);
		// creation Banque
		Banque banque1 = new Banque();
		banque1.setNomBanque("Société Générale");
		banque1.setBic("SOGEFRPP");
		banque1.setIban("IBAN 2006 3053 3309");
		// creation collab
		Collaborateur collab1 = new Collaborateur("Johny", "MAGRE");
		collab1.setMatricule("M001");
		collab1.setAdresse("2 rue de la Paix, 75000 Paris");
		collab1.setBanque(banque1);
		collab1.setDepartement(dept1);
		collab1.setDate_naissance(LocalDate.now().minusYears(42));
		collab1.setNum_secu_sociale("1234567891234567");

		collaborateurRepository.save(collab1);

		Banque banque2 = new Banque();
		banque2.setNomBanque("LCL");
		banque2.setBic("LCLFRPP");
		banque2.setIban("IBAN 2006 3053 4452");
		Collaborateur collab2 = new Collaborateur("Laurent", "Natale");
		collab2.setMatricule("M002");
		collab2.setAdresse("2 rue de la Soif, Rennes");
		collab2.setBanque(banque2);
		collab2.setDepartement(dept2);
		collab2.setDate_naissance(LocalDate.now().minusYears(55));
		collab2.setNum_secu_sociale("1234567891234567");

		collaborateurRepository.save(collab2);

		return;

	}

}
