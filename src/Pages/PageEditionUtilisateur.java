package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objets.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PageEditionUtilisateur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_idUtilisateur;
	private JTextField text_nom;
	private JTextField text_prenom;

	/**
	 * Create the frame.
	 */
	public PageEditionUtilisateur(Utilisateur utilisateur, boolean editable) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdutilisateur = new JLabel("IdUtilisateur:");
		lblIdutilisateur.setBounds(10, 73, 125, 14);
		contentPane.add(lblIdutilisateur);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(10, 98, 125, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom:");
		lblPrenom.setBounds(10, 123, 125, 14);
		contentPane.add(lblPrenom);
		
		JButton btn_cancel = new JButton("Annuler");
		btn_cancel.setBounds(339, 231, 89, 23);
		contentPane.add(btn_cancel);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.setBounds(240, 231, 89, 23);
		contentPane.add(btn_ok);
		
		text_idUtilisateur = new JTextField();
		text_idUtilisateur.setBounds(145, 70, 250, 20);
		text_idUtilisateur.setText(utilisateur.getIdUtilisateur());
		contentPane.add(text_idUtilisateur);
		text_idUtilisateur.setColumns(10);
		
		text_nom = new JTextField();
		text_nom.setBounds(145, 95, 250, 20);
		text_nom.setText(utilisateur.getNom());
		contentPane.add(text_nom);
		text_nom.setColumns(10);
		
		text_prenom = new JTextField();
		text_prenom.setBounds(145, 120, 250, 20);
		text_prenom.setText(utilisateur.getPrenom());
		contentPane.add(text_prenom);
		text_prenom.setColumns(10);

	}
}
