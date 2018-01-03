package spring.sgp.entitie;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "collaborateur")
public class Collaborateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_collab")
	private Integer id_collab;
	
	@Column(name = "matricule")
	private String matricule;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "date_naissance")
	private LocalDate date_naissance;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "num_secu_sociale")
	private String num_secu_sociale;
	
	@Column(name = "dateHeureCreation")
	private ZonedDateTime dateHeureCreation;
	
	@ManyToOne
	private Departement departement;
	@Embedded
	private Banque banque;

	public Collaborateur() {

		this.dateHeureCreation = ZonedDateTime.now();

	}

	public Collaborateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;

	}

	public Integer getId() {
		return id_collab;
	}

	public void setId(Integer id) {
		this.id_collab = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNum_secu_sociale() {
		return num_secu_sociale;
	}

	public void setNum_secu_sociale(String num_secu_sociale) {
		this.num_secu_sociale = num_secu_sociale;
	}

	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
