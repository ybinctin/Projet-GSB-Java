package Objets;

public class FraisForfait {
	String idFraisForfait;
	String libelleFraisForfait;
	Double montant;
	
	
	public String getIdFraisForfait() {
		return idFraisForfait;
	}
	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}
	public String getLibelleFraisForfait() {
		return libelleFraisForfait;
	}
	public void setLibelleFraisForfait(String libelleFraisForfait) {
		this.libelleFraisForfait = libelleFraisForfait;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	
	public String toString() {
		return "FraisForfait [idFraisForfait=" + idFraisForfait + ", libelleFraisForfait=" + libelleFraisForfait
				+ ", montant=" + montant + "]";
	}
}
