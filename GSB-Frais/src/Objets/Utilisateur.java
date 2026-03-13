package Objets;

import java.sql.*;
import java.util.ArrayList;

public class Utilisateur {
	private String idUtilisateur;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private String adresse;
	private String cp;
	private String ville;
	private Date dateEmbauche;
	private String mail;
	private String telFixe;
	private String telPortable;
	private Region region;
	private Role role;
	private ArrayList<FicheFrais> ficheFrais;
	
	public Utilisateur(String idUtilisateur, String nom, String prenom, String login, String mdp, String adresse,
			String cp, String ville, Date dateEmbauche, String mail, String telFixe, String telPortable, Region region,
			Role role, ArrayList<FicheFrais> ficheFrais) {
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.dateEmbauche = dateEmbauche;
		this.mail = mail;
		this.telFixe = telFixe;
		this.telPortable = telPortable;
		this.region = region;
		this.role = role;
		this.ficheFrais = ficheFrais;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getTelPortable() {
		return telPortable;
	}

	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ArrayList<FicheFrais> getFicheFrais() {
		return ficheFrais;
	}

	public void setFicheFrais(ArrayList<FicheFrais> ficheFrais) {
		this.ficheFrais = ficheFrais;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", login="
				+ login + ", mdp=" + mdp + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville
				+ ", dateEmbauche=" + dateEmbauche + ", mail=" + mail + ", telFixe=" + telFixe + ", telPortable="
				+ telPortable + ", region=" + region + ", role=" + role + ", ficheFrais=" + ficheFrais + "]";
	}
}
