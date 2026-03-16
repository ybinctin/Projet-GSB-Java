package Objets;

public class LigneFraisForfait {
	
	private FicheFrais ficheFrais;
	private FraisForfait fraisForfait;
	private int quantite;
	
	public LigneFraisForfait(FicheFrais ficheFrais, FraisForfait fraisForfait, int quantite) {
		super();
		this.ficheFrais = ficheFrais;
		this.fraisForfait = fraisForfait;
		this.quantite = quantite;
	}

	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}

	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}

	public FraisForfait getFraisForfait() {
		return fraisForfait;
	}

	public void setFraisForfait(FraisForfait fraisForfait) {
		this.fraisForfait = fraisForfait;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "LigneFraisForfait [ficheFrais=" + ficheFrais + ", quantite=" + quantite + "]";
	}
}
