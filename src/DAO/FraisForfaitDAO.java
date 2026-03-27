package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Objets.FraisForfait;

public class FraisForfaitDAO extends DAO<FraisForfait>{
	
	private Connection con;

	public FraisForfaitDAO() {
		this.con = connect;
	}

	@Override
	public boolean create(FraisForfait obj) {
		String sql = "INSERT INTO fraisforfait VALUES (?,?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setString(1, obj.getIdFraisForfait());
			preparedStatement.setString(2, obj.getLibelleFraisForfait());
			preparedStatement.setDouble(3, obj.getMontant());
			preparedStatement.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(FraisForfait obj) {
		String sql = "DELETE * FROM fraisforfait WHERE idfraisforfait = '" + obj.getIdFraisForfait() + "'";
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
	public boolean update(FraisForfait obj) {
		return false;
	}

	@Override
	public FraisForfait find(String id) {
		return null;
	}
}
