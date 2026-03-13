package BDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	private static final String URL = "jdbc:mysql://localhost:3306/gsb-frais2025";
	private static final String Utilisateur = "myroot";
	private static final String MDP = "root123*";
	
	private static Connection con = null;
	
	public static Connection getInstance() {
		try {
			con = DriverManager.getConnection(URL,Utilisateur,MDP);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close() {
		try {
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("-- Problème lors de la fermeture --");
		}
	}
}