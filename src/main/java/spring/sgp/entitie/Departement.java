package spring.sgp.entitie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departement")
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private Integer dept_id;
	@Column(name = "nom")
	private String nom;


	public int getId() {
		return dept_id;
	}

	public void setId(int id) {
		this.dept_id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
