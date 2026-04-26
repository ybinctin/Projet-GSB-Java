package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BDD.Connexion;
import Objets.Region;
import Objets.Utilisateur;

public class RegionDAO extends DAO<Region> {

	public boolean create(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public Region find(String id) {
		String request = "SELECT * FROM regions where id_region = ?";

		try (Connection con = Connexion.getInstance(); PreparedStatement requete = con.prepareStatement(request);) {
			requete.setInt(1, Integer.parseInt(id));
			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {
				Region region = new Region(resultat.getInt("id_region"), resultat.getString("nom_region"));
				return region;
			}
			;

		} catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}
		return null;
	}

	public List<Region> obtenirToutesRegions() {
		String request = "SELECT * FROM regions;";
		List<Region> liste = new ArrayList<>();

		try {
			Connection con = Connexion.getInstance();
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);

			while (resultat.next()) {
				Region region = new Region(resultat.getInt("id_region"), resultat.getString("nom_region"));
				liste.add(region);
			}
			;
		} catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}

		return liste;
	}
}
