package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Objets.Etat;
import Objets.Role;

/**
 * Classe DAO permettant de gérer les opérations CRUD
 * sur les objets Etat dans la base de données.
 * Cette classe interagit avec la table etatfrais.
 */
public abstract class EtatDAO extends DAO<Etat>{
	
	/**
	 * Connexion à la base de données.
	 */
	private Connection con;

	/**
	 * Constructeur de la classe EtatDAO.
	 * Initialise la connexion à la base de données.
	 */
	public EtatDAO() {
		this.con = connect;
	}

	/**
	 * Ajoute un nouvel état dans la table etatfrais.
	 * 
	 * @param obj objet Etat à ajouter
	 * @return true si l'insertion a réussi, false sinon
	 */
	@Override
	public boolean create(Etat obj) {
		String sql = "INSERT INTO etatfrais VALUES (?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setString(1, obj.getIdEtat());
			preparedStatement.setString(2, obj.getLibelleEtat());
			preparedStatement.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Supprime un état de la base de données.
	 * 
	 * @param obj objet Etat à supprimer
	 * @return true si la suppression a réussi, false sinon
	 */
	@Override
	public boolean delete(Etat obj) {
		String sql = "DELETE * FROM etatfrais WHERE idetat = '" + obj.getIdEtat() + "'";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Met à jour un état dans la base de données.
	 * Méthode non implémentée actuellement.
	 * 
	 * @param obj objet Etat à mettre à jour
	 * @return false par défaut
	 */
	@Override
	public boolean update(Etat obj) {
		return false;
	}

	/**
	 * Recherche un état à partir de son identifiant.
	 * 
	 * @param id identifiant de l'état recherché
	 * @return l'objet Etat correspondant,
	 *         ou null si aucun état n'est trouvé
	 */
	public Etat find(String id) {
		try {
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(
				"select * from etatfrais where idetat = '" + id + "'"
			);

			while (resultat.next()) {
				Etat etat = new Etat(
					resultat.getString("idetat"),
					resultat.getString("libelle")
				);
				return etat;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Récupère la liste de tous les états présents
	 * dans la table etatfrais.
	 * 
	 * @return une ArrayList contenant tous les objets
	 * Etat, ou null en cas d'erreur
	 */
	public ArrayList<Etat> tousLesEtats() {
		try {
			ArrayList<Etat> listeEtats = new ArrayList<>();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery("select * from etatfrais");

			while (resultat.next()) {
				Etat etat = new Etat(
					resultat.getString("idetat"),
					resultat.getString("libelle")
				);

				listeEtats.add(etat);
			}

			return listeEtats; 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}