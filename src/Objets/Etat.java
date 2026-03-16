package Objets;

public class Etat {
	String idEtat;
	String libelleEtat;
	
	public Etat(String idEtat, String libelleEtat) {
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
	}

	public String getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}

	public String getLibelleEtat() {
		return libelleEtat;
	}

	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}

	public String toString() {
		return "Etat [idEtat=" + idEtat + ", libelleEtat=" + libelleEtat + "]";
	}
	
	
	
	
}
