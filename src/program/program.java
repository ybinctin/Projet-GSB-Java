package program;
import BDD.Connexion;
import DAO.UtilisateurDAO;

public class program {

	public static void main(String[] args) {
		Connexion.getInstance();
		UtilisateurDAO test = new UtilisateurDAO();
		System.out.println(test.identification("lvillachane", "motdepasse"));
	}
}