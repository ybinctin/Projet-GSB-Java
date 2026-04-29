package DAO;

import Objets.Region;
import Objets.Role;
import Objets.Utilisateur;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				+ " VALUES" + "(" + obj.getIdUtilisateur() + ", " + obj.getNom() + ", " + obj.getPrenom() + ", "
				+ obj.getLogin() + ", " + obj.getMdp() + ", " + obj.getAdresse() + ", " + obj.getCp() + ", "
				+ obj.getVille() + ", " + obj.getDateEmbauche() + ", " + obj.getMail() + ", " + obj.getTelFixe() + ", "
				+ obj.getTelPortable() + ", " + obj.getRegion().getIdRegion() + ")";
		// Manque le idrole
		try {
			Connection con = Connexion.getInstance();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);

			System.out.println("L'utilisateur suivant à été ajouté: " + obj);
			ajoutReussi = true;
		} catch (Exception e) {
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
		} catch (Exception e) {
			System.out.println(e);
		}
		return suppressionReussi;
	}

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		String request = "UPDATE utilisateur SET idutilisateur = ?, nom = ?, prenom = ?, login = ?, mdp = ?, adresse = ?, cp = ?, dateEmbauche = ?, idrole = ?, mail = ?, num_fixe = ?, num_portable = ? WHERE idutilisateur = ?";

		try (Connection con = Connexion.getInstance(); PreparedStatement requete = con.prepareStatement(request);) {

			requete.setString(1, obj.getIdUtilisateur());
			requete.setString(2, obj.getNom());
			requete.setString(3, obj.getPrenom());
			requete.setString(4, obj.getLogin());
			requete.setString(5, obj.getMdp());
			requete.setString(6, obj.getAdresse());
			requete.setString(7, obj.getCp());
			requete.setDate(8, obj.getDateEmbauche());
			requete.setString(9, obj.getRole().getIdrole()); 
			// requete.setString(10, null); // dernier_changement_mdp
			requete.setString(10, obj.getMail());
			requete.setString(11, obj.getTelFixe());
			requete.setString(12, obj.getTelPortable());
			// id région ?
			requete.setString(13, obj.getIdUtilisateur());

			int resultatLignes = requete.executeUpdate();

			if (resultatLignes > 0) {
				return true;
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public Utilisateur identification(String login, String mdp) {
		String request = "SELECT * FROM utilisateur WHERE login = ? AND mdp = ?";
		try (Connection con = Connexion.getInstance(); PreparedStatement requete = con.prepareStatement(request);) {
			requete.setString(1, login);
			requete.setString(2, mdp);
			ResultSet resultat = requete.executeQuery();

			// Vérification que l'utilisateur soit un Directeur RH, Secrétaire RH ou
			// Responsable RH
			if (resultat.next() && !"VS".equals(resultat.getString("idrole"))
					&& !"CP".equals(resultat.getString("idrole"))) {
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
			} else {
				System.out.println("Utilisateur non trouvé.");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public Utilisateur find(String id) {

		String request = "SELECT * FROM utilisateur WHERE idUtilisateur = ?";
		try {
			PreparedStatement requete = con.prepareStatement(request);
			requete.setString(1, id);
			ResultSet resultat = requete.executeQuery();
			RegionDAO ReDAO = new RegionDAO();
			RoleDAO RoDAO = new RoleDAO();

			if (resultat.next()) {

				String idUser = resultat.getString("idutilisateur");
				String idRole = resultat.getString("idrole");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String login = resultat.getString("login");
				String mdp = resultat.getString("mdp");
				String adresse = resultat.getString("adresse");
				String cp = resultat.getString("cp");
				String ville = resultat.getString("ville");
				Date dateEmbauche = resultat.getDate("dateEmbauche");
				String mail = resultat.getString("mail");
				String numFixe = resultat.getString("num_fixe");
				String numPortable = resultat.getString("num_portable");
				// int idRegion = resultat.getInt("id_region");

				resultat.close();
				requete.close();

				// Region region = ReDAO.find(Integer.toString(idRegion));
				Role role = RoDAO.find(idRole);

				Utilisateur user = new Utilisateur(idUser, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche,
						mail, numFixe, numPortable, null, role, null);

				return user;
			}
			;
		} catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}
		return null;
	}

	public List<Utilisateur> tousLesUtilisateurs() {

		String request = "SELECT * FROM utilisateur";
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		try {
			PreparedStatement requete = con.prepareStatement(request);
			ResultSet resultat = requete.executeQuery();

			// RegionDAO ReDAO = new RegionDAO();
			RoleDAO RoDAO = new RoleDAO();

			while (resultat.next()) {

				String idUser = resultat.getString("idutilisateur");
				String idrole = resultat.getString("idrole");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String login = resultat.getString("login");
				String mdp = resultat.getString("mdp");
				String adresse = resultat.getString("adresse");
				String cp = resultat.getString("cp");
				String ville = resultat.getString("ville");
				Date dateEmbauche = resultat.getDate("dateEmbauche");
				String mail = resultat.getString("mail");
				String numFixe = resultat.getString("num_fixe");
				String numPortable = resultat.getString("num_portable");
				String idRegion = null;

				// Region region = ReDAO.find(Integer.toString(idRegion));
				Role role = RoDAO.find(idrole);

				Utilisateur user = new Utilisateur(idUser, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche,
						mail, numFixe, numPortable, null, role, null);
				
				listeUtilisateurs.add(user);
			}
			;
		} catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}
		return listeUtilisateurs;
	}
}
