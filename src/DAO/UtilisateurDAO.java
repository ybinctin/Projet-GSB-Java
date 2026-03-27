package DAO;

import Objets.Utilisateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import BDD.Connexion;

public class UtilisateurDAO extends DAO<Utilisateur> {

	public UtilisateurDAO() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Utilisateur obj) {
		// TODO Auto-generated method stub
		
		boolean ajoutReussi = false;
		String request = "INSERT INTO utilisateur (idUtilisateur, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche, idrole, dernier_changement_mdp, mail, telFixe, telPortable)" 
		+ " VALUES"
				+ "(" + obj.getIdUtilisateur() + ", " + obj.getNom() +  ", " + obj.getPrenom() + ", " + obj.getLogin() + ", " + obj.getMdp() + ", " + obj.getAdresse() + ", " + obj.getCp() + ", " + obj.getVille() + ", " + obj.getDateEmbauche() + ", " + obj.getMail() + ", " + obj.getTelFixe() + ", " + obj.getTelPortable() + ")";
		// Manque le idrole
		try {
			Connection con = Connexion.getInstance();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);
			
			System.out.println("L'utilisateur suivant à été ajouté: " + obj);
			ajoutReussi = true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return ajoutReussi;
	}
	

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		boolean suppressionReussi = false;
		String request = "DELETE FROM utilisateur WHERE idUtilisateur='" + obj.getIdUtilisateur() + "';";
		
		try {
			Connection con = Connexion.getInstance();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);
			
			System.out.println("L'utilisateur à été supprimé.");
			suppressionReussi = true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return suppressionReussi;
	}
	

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		String request = "UPDATE utilisateur"
				+ "SET idutilisateur = '" + obj.getIdUtilisateur() + "' , nom = '" + obj.getNom() + "' , prenom = '" + obj.getPrenom() + "' , login = '" + obj.getLogin() + "' , mdp = '" + obj.getMdp() + "' , adresse = '" + obj.getAdresse() + "' , cp = '" + obj.getCp() + "' , dateEmbauche = '" + obj.getDateEmbauche() + "' , idrole = '" + obj.getRole().getIdrole() 
				+ "' , dernier_changement_mdp = '" + null + "' , mail = '" + obj.getMail() + "' , telFixe = " + obj.getTelFixe() + "' , telPortable = '" + obj.getTelPortable()
				+ "WHERE idutilisateur='" + obj.getIdUtilisateur() + "';";
		return false;
	}

	public Utilisateur find(String id) {
		String request = "SELECT * FROM utilisateur WHERE idUtilisateur = '" + id + "';";
		try {
			Connection con = Connexion.getInstance();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);

			while (resultat.next()) {
				Utilisateur user = new Utilisateur(resultat.getString("idutilisateur"), resultat.getString("nom"),
						resultat.getString("prenom"), resultat.getString("login"), resultat.getString("mdp"),
						resultat.getString("adresse"), resultat.getString("cp"), resultat.getString("ville"),
						resultat.getDate("dateEmbauche"), resultat.getString("mail"), resultat.getString("telFixe"),
						resultat.getString("telPortable"), null, null, null);
				return user;
			}
			;
		} catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}
		return null;
	}

	public boolean identification(String login, String mdp) {
		boolean utilisateurConnecté = false;
		String request = "SELECT login, mdp" + " FROM utilisateur " + "WHERE login = \'" + login + "\'"
				+ " AND mdp = \'" + mdp + "\';";
		try {
			Connection con = Connexion.getInstance();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);

			if (resultat.first()) {
				System.out.println("Good good");
				utilisateurConnecté = true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return utilisateurConnecté;
	}

	@Override
	public Utilisateur find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
