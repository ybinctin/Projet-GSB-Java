package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Objets.FicheFrais;

public class FicheFraisDAO extends DAO<FicheFrais> {
	
	private Connection con;

	public FicheFraisDAO() {
		this.con = connect;
	}

	@Override
	public boolean create(FicheFrais obj) {
		String sql = "INSERT INTO fichefrais VALUES (?,?,?,?,?,?,?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setInt(1, obj.getIdFiche());
			preparedStatement.setString(2, obj.getUtilisateur().getIdUtilisateur());
			preparedStatement.setString(3, obj.getAnnee());
			preparedStatement.setString(4, obj.getMois());
			preparedStatement.setInt(5, obj.getNbJustificatifs());
			preparedStatement.setDouble(6, obj.getMontantValide());
			preparedStatement.setDate(7, obj.getDateModif());
			preparedStatement.setString(8, obj.getEtat().getIdEtat());
			preparedStatement.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(FicheFrais obj) {
		return false;
	}

	@Override
	public boolean update(FicheFrais obj) {
		return false;
	}

	@Override
	public FicheFrais find(String id) {
		return null;
	}
}