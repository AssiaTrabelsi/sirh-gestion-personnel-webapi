package spring.sgp.entitie;

import javax.persistence.Embeddable;

@Embeddable
public class Banque {

	private String nomBanque;
	private String bic;
	private String iban;

	

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

}
