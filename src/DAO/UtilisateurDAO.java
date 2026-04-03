package DAO;

import Objets.Utilisateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import BDD.Connexion;
import DAO.RegionDAO;
import DAO.RoleDAO;

public class UtilisateurDAO extends DAO<Utilisateur> {
	
	private Connection con;

	public UtilisateurDAO() {
		this.con = connect;
	}

	@Override
	public boolean create(Utilisateur obj) {
		// TODO Auto-generated method stub
		
		boolean ajoutReussi = false;
		String request = "INSERT INTO utilisateur (idUtilisateur, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche, idrole, dernier_changement_mdp, mail, num_fixe, num_portable, id_region)" 
		+ " VALUES"
				+ "(" + obj.getIdUtilisateur() + ", " + obj.getNom() +  ", " + obj.getPrenom() + ", " + obj.getLogin() + ", " + obj.getMdp() + ", " + obj.getAdresse() + ", " + obj.getCp() + ", " + obj.getVille() + ", " + obj.getDateEmbauche() + ", " + obj.getMail() + ", " + obj.getTelFixe() + ", " + obj.getTelPortable() + ", " + obj.getRegion().getIdRegion() + ")";
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
				+ "' , dernier_changement_mdp = '" + null + "' , mail = '" + obj.getMail() + "' , num_fixe = " + obj.getTelFixe() + "' , num_portable = '" + obj.getTelPortable() + "' , id_region = '" + obj.getRegion().getIdRegion()
				+ "WHERE idutilisateur='" + obj.getIdUtilisateur() + "';";
		return false;
	}

	public Utilisateur identification(String login, String mdp) {
		boolean utilisateurConnecté = false;
		String request = "SELECT * " + " FROM utilisateur " + "WHERE login = \'" + login + "\'"
				+ " AND mdp = \'" + mdp + "\';";
		try {
			Connection con = Connexion.getInstance();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);

			if (resultat.first() && !"VS".equals(resultat.getString("idrole")) && !"CP".equals(resultat.getString("idrole"))) {
				System.out.println(resultat.getString("idrole"));
				String utilisateurID = resultat.getString("idutilisateur");
				System.out.println("Utilisateur connecté: " + utilisateurID);
				
				RoleDAO roledao = new RoleDAO();

				Utilisateur user = new Utilisateur(resultat.getString("idutilisateur"), resultat.getString("nom"),
						resultat.getString("prenom"), resultat.getString("login"), resultat.getString("mdp"),
						resultat.getString("adresse"), resultat.getString("cp"), resultat.getString("ville"),
						resultat.getDate("dateEmbauche"), resultat.getString("mail"), resultat.getString("num_fixe"),
						resultat.getString("num_portable"), null, roledao.find(resultat.getString("idrole")), null);
				return user;
			}
			else {
				System.out.println("Utilisateur non trouvé.");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public Utilisateur find(String id) {
		// TODO Auto-generated method stub
		String request = "SELECT * FROM utilisateur WHERE idUtilisateur = '" + id + "';";
		try {
			Connection con = Connexion.getInstance();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);
			RegionDAO ReDAO = new RegionDAO();
			RoleDAO RoDAO = new RoleDAO();
			while (resultat.next()) {
				Utilisateur user = new Utilisateur(resultat.getString("idutilisateur"), resultat.getString("nom"),
						resultat.getString("prenom"), resultat.getString("login"), resultat.getString("mdp"),
						resultat.getString("adresse"), resultat.getString("cp"), resultat.getString("ville"),
						resultat.getDate("dateEmbauche"), resultat.getString("mail"), resultat.getString("num_fixe"),
						resultat.getString("num_portable"), ReDAO.find(resultat.getInt("id_region")), RoDAO.find(resultat.getString("idutilisateur")), null);
				return user;
			}
			;
		} catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}
		return null;
	}
}
