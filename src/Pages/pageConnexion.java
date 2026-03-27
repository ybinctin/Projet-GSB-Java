package Pages;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UtilisateurDAO;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titrePageConnexion = new JLabel("Page de connexion");
		titrePageConnexion.setFont(new Font("Tahoma", Font.BOLD, 20));
		titrePageConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		titrePageConnexion.setBounds(125, 22, 198, 20);
		contentPane.add(titrePageConnexion);
		
		JLabel labelLogin = new JLabel("Login :");
		labelLogin.setBounds(45, 103, 39, 14);
		contentPane.add(labelLogin);
		
		JLabel labelMdp = new JLabel("Mot de passe :");
		labelMdp.setBounds(45, 133, 89, 14);
		contentPane.add(labelMdp);
		
		textLogin = new JTextField();
		textLogin.setToolTipText("");
		textLogin.setBounds(178, 100, 190, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textMdp = new JPasswordField();
		textMdp.setBounds(178, 130, 190, 20);
		contentPane.add(textMdp);
		
		labelErreur = new JLabel("Login / mot de passe incorrecte.");
		labelErreur.setForeground(new Color(255, 0, 0));
		labelErreur.setBounds(178, 161, 206, 14);
		labelErreur.setVisible(false);
		contentPane.add(labelErreur);
		
		JButton btnValider = new JButton("☑︎   Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textLogin.getText();
				String Mdp = textMdp.getText();
				
				UtilisateurDAO utilisateurdao = new UtilisateurDAO();
				
				if(utilisateurdao.identification(login, Mdp) == true) {
					pageIndex page_accueil = new pageIndex();
					page_accueil.show();
					dispose();
				}
				
			}
		});
		btnValider.setBounds(308, 227, 116, 23);
		contentPane.add(btnValider);
	}
}