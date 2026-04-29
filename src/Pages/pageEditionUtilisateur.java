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

	/**
	 * Create the frame.
	 */
	public pageEditionUtilisateur(Utilisateur utilisateur, boolean editable) {
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
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btn_cancel);
		
		
		text_idUtilisateur = new JTextField();
		text_idUtilisateur.setEditable(editable);
		text_idUtilisateur.setBounds(145, 70, 250, 20);
		text_idUtilisateur.setText(utilisateur.getIdUtilisateur());
		contentPane.add(text_idUtilisateur);
		text_idUtilisateur.setColumns(10);
		
		text_nom = new JTextField();
		text_nom.setEditable(editable);
		text_nom.setBounds(145, 95, 250, 20);
		text_nom.setText(utilisateur.getNom());
		contentPane.add(text_nom);
		text_nom.setColumns(10);
		
		text_prenom = new JTextField();
		text_prenom.setEditable(editable);
		text_prenom.setBounds(145, 120, 250, 20);
		text_prenom.setText(utilisateur.getPrenom());
		contentPane.add(text_prenom);
		text_prenom.setColumns(10);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editable) {
					UtilisateurDAO utilDAO = new UtilisateurDAO();
					utilisateur.setIdUtilisateur(text_idUtilisateur.getText());
					utilisateur.setNom(text_nom.getText());
					utilisateur.setPrenom(text_prenom.getText());
					boolean resultatUpdate = utilDAO.update(utilisateur);
					if (resultatUpdate) {
						dispose();
					}
				}
			}
		});
		btn_ok.setBounds(240, 231, 89, 23);
		contentPane.add(btn_ok);

	}
}
