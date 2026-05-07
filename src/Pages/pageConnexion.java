package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UtilisateurDAO;
import Objets.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class pageConnexion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textMdp;
	private JLabel labelErreur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageConnexion frame = new pageConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pageConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(724, 430);
		setLocationRelativeTo(null);
		setTitle("| Page de connexion");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titrePageConnexion = new JLabel("Connexion à son espace");
		titrePageConnexion.setFont(new Font("Tahoma", Font.BOLD, 30));
		titrePageConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		titrePageConnexion.setBounds(10, 35, 688, 50);
		contentPane.add(titrePageConnexion);

		JLabel labelLogin = new JLabel("Login :");
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelLogin.setBounds(122, 150, 172, 33);
		contentPane.add(labelLogin);

		JLabel labelMdp = new JLabel("Mot de passe :");
		labelMdp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelMdp.setBounds(60, 212, 172, 29);
		contentPane.add(labelMdp);

		textLogin = new JTextField();
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textLogin.setToolTipText("Saisissez votre login");
		textLogin.setBounds(209, 154, 371, 30);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		textMdp = new JPasswordField();
		textMdp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMdp.setToolTipText("Saissiez votre mot de passe");
		textMdp.setBounds(209, 214, 371, 30);
		contentPane.add(textMdp);

		labelErreur = new JLabel("ERREUR");
		labelErreur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelErreur.setForeground(new Color(255, 0, 0));
		labelErreur.setBounds(211, 249, 369, 66);
		labelErreur.setVisible(false);
		contentPane.add(labelErreur);

		JButton btnValider = new JButton("Se connecter");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textLogin.getText();
				String Mdp = textMdp.getText();

				UtilisateurDAO utilisateurdao = new UtilisateurDAO();
				Utilisateur user = utilisateurdao.identification(login, Mdp);

				if (user != null) {
					if (user.getRole().getIdrole().equals("SC")) {
						pageSecretaire page = new pageSecretaire(user);
						page.show();
						dispose();
					} else if (user.getRole().getIdrole().equals("RS")) {

					} else if (user.getRole().getIdrole().equals("DR")) {
						pageDirecteur page = new pageDirecteur(user);
						page.show();
						dispose();

					} else {
						labelErreur.setText("Accès non autorisé.");
						labelErreur.setVisible(true);
					}
				} else {
					labelErreur.setText("Login / mot de passe incorrect.");
					labelErreur.setVisible(true);
				}

			}
		});

		btnValider.setBounds(526, 347, 172, 33);
		contentPane.add(btnValider);
	}
}