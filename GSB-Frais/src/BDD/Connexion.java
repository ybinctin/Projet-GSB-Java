package BDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	private static final String URL = "jdbc:mysql://localhost:3306/gsbfrais-2025";
	private static final String UTILISATEUR = "myroot";
	private static final String MOT_DE_PASSE = "root123*";
	
	private static Connection con = null;
	
	public static Connection getInstance() {
		try {
			con = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if (con != null) {
			System.out.println("Connexion à la base de données réuissie.");
		}
		return con;
	}
	
	public static void close() {
		try {
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problème lors de la fermeture de la connexion.");
		}
	}
}