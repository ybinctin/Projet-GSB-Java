package Objets;

import java.sql.*;
import java.util.ArrayList;

public class FicheFrais {
	
	private int idFiche;
	private Utilisateur utilisateur;
	private String annee;
	private String mois;
	private int nbJustificatifs;
	private double montantValide;
	private Date dateModif;
	private Etat etat;
	private ArrayList<LigneFraisHorsForfait> fraisHorsForfait;
	private ArrayList<LigneFraisForfait> fraisForfait;
	
	public FicheFrais(int idFiche, Utilisateur utilisateur, String annee, String mois, int nbJustificatifs,
			double montantValide, Date dateModif, Etat etat, ArrayList<LigneFraisHorsForfait> fraisHorsForfait,
			ArrayList<LigneFraisForfait> fraisForfait) {
		this.idFiche = idFiche;
		this.utilisateur = utilisateur;
		this.annee = annee;
		this.mois = mois;
		this.nbJustificatifs = nbJustificatifs;
		this.montantValide = montantValide;
		this.dateModif = dateModif;
		this.etat = etat;
		this.fraisHorsForfait = fraisHorsForfait;
		this.fraisForfait = fraisForfait;
	}

	public int getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public int getNbJustificatifs() {
		return nbJustificatifs;
	}

	public void setNbJustificatifs(int nbJustificatifs) {
		this.nbJustificatifs = nbJustificatifs;
	}

	public double getMontantValide() {
		return montantValide;
	}

	public void setMontantValide(double montantValide) {
		this.montantValide = montantValide;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public ArrayList<LigneFraisHorsForfait> getFraisHorsForfait() {
		return fraisHorsForfait;
	}

	public void setFraisHorsForfait(ArrayList<LigneFraisHorsForfait> fraisHorsForfait) {
		this.fraisHorsForfait = fraisHorsForfait;
	}

	public ArrayList<LigneFraisForfait> getFraisForfait() {
		return fraisForfait;
	}

	public void setFraisForfait(ArrayList<LigneFraisForfait> fraisForfait) {
		this.fraisForfait = fraisForfait;
	}

	@Override
	public String toString() {
		return "FicheFrais [idFiche=" + idFiche + ", utilisateur=" + utilisateur + ", annee=" + annee + ", mois=" + mois
				+ ", nbJustificatifs=" + nbJustificatifs + ", montantValide=" + montantValide + ", dateModif="
				+ dateModif + "]";
	}
	
	
}
