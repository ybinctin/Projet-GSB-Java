package Pages;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UtilisateurDAO;
import Objets.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class pageEditionUtilisateur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_idUtilisateur;
	private JTextField text_nom;
	private JTextField text_prenom;
	private JTextField textAdresse;
	private JTextField textCp;
	private JTextField textVille;

	/**
	 * Create the frame.
	 */
	public pageEditionUtilisateur(Utilisateur utilisateur, Utilisateur utilisateurConnecte, String etat) {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdutilisateur = new JLabel("IdUtilisateur:");
		lblIdutilisateur.setBounds(10, 43, 125, 14);
		contentPane.add(lblIdutilisateur);

		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(10, 68, 125, 14);
		contentPane.add(lblNom);

		JLabel lblPrenom = new JLabel("Prénom:");
		lblPrenom.setBounds(10, 93, 125, 14);
		contentPane.add(lblPrenom);

		JButton btn_cancel = new JButton("Annuler");
		btn_cancel.setBounds(339, 231, 89, 23);
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btn_cancel);

		text_idUtilisateur = new JTextField();
		text_idUtilisateur.setBounds(145, 40, 250, 20);
		text_idUtilisateur.setText(utilisateur.getIdUtilisateur());
		contentPane.add(text_idUtilisateur);
		text_idUtilisateur.setColumns(10);

		text_nom = new JTextField();
		text_nom.setBounds(145, 65, 250, 20);
		text_nom.setText(utilisateur.getNom());
		contentPane.add(text_nom);
		text_nom.setColumns(10);

		text_prenom = new JTextField();
		text_prenom.setBounds(145, 90, 250, 20);
		text_prenom.setText(utilisateur.getPrenom());
		contentPane.add(text_prenom);
		text_prenom.setColumns(10);

		textCp = new JTextField();
		textCp.setText(utilisateur.getCp());
		textCp.setColumns(10);
		textCp.setBounds(145, 146, 250, 20);
		contentPane.add(textCp);

		textVille = new JTextField();
		textVille.setText(utilisateur.getVille());
		textVille.setColumns(10);
		textVille.setBounds(145, 174, 250, 20);
		contentPane.add(textVille);

		textAdresse = new JTextField();
		textAdresse.setText(utilisateur.getAdresse());
		textAdresse.setColumns(10);
		textAdresse.setBounds(145, 118, 250, 20);
		contentPane.add(textAdresse);

		if (etat.equals("modification")) {
			setTitle("| Modification de " + utilisateur.getNom() + " " + utilisateur.getPrenom());
		} else if (etat.equals("consultation")) {
			setTitle("| Consultation de " + utilisateur.getNom() + " " + utilisateur.getPrenom());
		}

		if (etat.equals("modification")) {
			text_idUtilisateur.setEditable(true);
			text_nom.setEditable(true);
			text_prenom.setEditable(true);
			textAdresse.setEditable(true);
			textCp.setEditable(true);
			textVille.setEditable(true);

		} else {
			text_idUtilisateur.setEditable(false);
			text_nom.setEditable(false);
			text_prenom.setEditable(false);
			textAdresse.setEditable(false);
			textCp.setEditable(false);
			textVille.setEditable(false);
		}

		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etat.equals("modification")) {
					UtilisateurDAO utilDAO = new UtilisateurDAO();

					utilisateur.setIdUtilisateur(text_idUtilisateur.getText());
					utilisateur.setNom(text_nom.getText());
					utilisateur.setPrenom(text_prenom.getText());
					utilisateur.setAdresse(textAdresse.getText());
					utilisateur.setCp(textCp.getText());
					utilisateur.setVille(textVille.getText());

					boolean resultatUpdate = utilDAO.update(utilisateur);

					if (resultatUpdate) {
						pageSecretaire.instance.updateListeUtilisateurs();
						dispose();
					}
				} else {
					dispose();
				}
			}
		});
		btn_ok.setBounds(240, 231, 89, 23);
		contentPane.add(btn_ok);

		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(10, 121, 125, 14);
		contentPane.add(lblAdresse);

		JLabel lblCp = new JLabel("CP:");
		lblCp.setBounds(10, 149, 125, 14);
		contentPane.add(lblCp);

		JLabel lblVille = new JLabel("Ville:");
		lblVille.setBounds(10, 177, 125, 14);
		contentPane.add(lblVille);

	}
}
