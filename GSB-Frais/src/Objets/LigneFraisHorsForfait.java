package Objets;

import java.sql.Date;

public class LigneFraisHorsForfait {

	private int idFraisHorsForfait;
	private FicheFrais ficheFrais;
	private String libelle;
	private Date dateFrais;
	private double montant;
	
	public LigneFraisHorsForfait(int idFraisHorsForfait, FicheFrais ficheFrais, String libelle, Date dateFrais,
			double montant) {
		this.idFraisHorsForfait = idFraisHorsForfait;
		this.ficheFrais = ficheFrais;
		this.libelle = libelle;
		this.dateFrais = dateFrais;
		this.montant = montant;
	}

	public int getIdFraisHorsForfait() {
		return idFraisHorsForfait;
	}

	public void setIdFraisHorsForfait(int idFraisHorsForfait) {
		this.idFraisHorsForfait = idFraisHorsForfait;
	}

	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}

	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateFrais() {
		return dateFrais;
	}

	public void setDateFrais(Date dateFrais) {
		this.dateFrais = dateFrais;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "LigneFraisHorsForfait [idFraisHorsForfait=" + idFraisHorsForfait + ", ficheFrais=" + ficheFrais
				+ ", libelle=" + libelle + ", dateFrais=" + dateFrais + ", montant=" + montant + "]";
	}
}
