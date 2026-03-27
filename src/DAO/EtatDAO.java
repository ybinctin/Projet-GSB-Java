package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Objets.Etat;
import Objets.Role;

public abstract class EtatDAO extends DAO<Etat>{
	
	private Connection con;

	public EtatDAO() {
		this.con = connect;
	}

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

	@Override
	public boolean update(Etat obj) {
		return false;
	}

	public Etat find(String id) {
		try {
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery("select * from etatfrais where idetat = '" + id + "'");
			while (resultat.next()) {
				Etat etat = new Etat(resultat.getString("idetat"), resultat.getString("libelle"));
				return etat;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Etat> tousLesEtats() {
		try {
			ArrayList<Etat> listeEtats = new ArrayList<>();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery("select * from etatfrais");
			while (resultat.next()) {
				Etat etat = new Etat(resultat.getString("idetat"), resultat.getString("libelle"));
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