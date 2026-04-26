package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BDD.Connexion;
import Objets.Role;

public class RoleDAO extends DAO<Role> {

	private Connection con;

	public RoleDAO() {
		this.con = connect;
	}

	@Override
	public boolean create(Role obj) {
		String sql = "INSERT INTO role VALUES (?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setString(1, obj.getIdrole());
			preparedStatement.setString(2, obj.getLibellerole());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Role obj) {
		String sql = "DELETE * FROM role WHERE idrole = '" + obj.getIdrole() + "'";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Role obj) {
		return false;
	}

	public Role find(String id) {
		String request = "select * from role where idrole = ?";

		try (Connection con = Connexion.getInstance(); PreparedStatement requete = con.prepareStatement(request);) {
			// Premier paramètre = id
			requete.setString(1, id);
			ResultSet resultat = requete.executeQuery();
			
			while (resultat.next()) {
				Role role = new Role(resultat.getString("idrole"), resultat.getString("libellerole"));
				return role;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Role> tousLesRoles() {
		try {
			ArrayList<Role> listeRoles = new ArrayList<>();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery("select * from role");
			while (resultat.next()) {
				Role role = new Role(resultat.getString("idrole"), resultat.getString("libellerole"));
				listeRoles.add(role);
			}
			return listeRoles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
