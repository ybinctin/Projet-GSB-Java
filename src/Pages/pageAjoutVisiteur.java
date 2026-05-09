package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.RegionDAO;
import DAO.RoleDAO;
import DAO.UtilisateurDAO;
import Objets.Region;
import Objets.Role;
import Objets.Utilisateur;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class pageAjoutVisiteur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private Panel menu;
	private JLabel labelMenu;
	private JTextField textPrenom;
	private JLabel labelPrenom;
	private JLabel labelNom;
	private JTextField textNom;
	private JTextField textAdresse;
	private JLabel labelAdresse;
	private JTextField textCp;
	private JLabel lblCp;
	private JTextField textVille;
	private JLabel lblVille;
	private JTextField textTelFix;
	private JLabel lblTelphone;
	private JTextField textTelPortable;
	private JLabel lblTelphoneFixe;
	private Utilisateur utilisateurConnecte;
	private JButton btnAnnuler;
	private Role roleChoisi;
	private JTextField textId;

	/**
	 * Create the frame.
	 */
	public pageAjoutVisiteur(Utilisateur utilisateur) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(724, 430);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		utilisateurConnecte = utilisateur;

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getMenu());
		contentPane.add(getTextPrenom());
		contentPane.add(getLabelPrenom());
		contentPane.add(getLabelNom());
		contentPane.add(getTextNom());
		contentPane.add(getTextAdresse());
		contentPane.add(getLabelAdresse());
		contentPane.add(getTextCp());
		contentPane.add(getLblCp());
		contentPane.add(getTextVille());
		contentPane.add(getLblVille());
		contentPane.add(getTextTelFix());
		contentPane.add(getLblTelphone());
		contentPane.add(getTextTelPortable());
		contentPane.add(getLblTelphoneFixe());

		getBtnAnnuler().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAjouter.setBounds(405, 354, 140, 30);

//		btnAjouter.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				UtilisateurDAO utilisateurdao = new UtilisateurDAO();
//				// TODO: finir la création de l'utilisateur
//				Utilisateur nouveauUtilisateur = new Utilisateur(getTextId(), getTextNom(), getTextPrenom(), );
//				utilisateurdao.create(utilisateur);
//			}
//		});

		contentPane.add(btnAjouter);
		contentPane.add(getBtnAnnuler()); 

		contentPane.add(getTextId());

		JLabel labelId = new JLabel("ID :");
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelId.setBounds(30, 88, 150, 14);
		contentPane.add(labelId);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Ajouter un visiteur");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 20));
			lblNewLabel.setBounds(10, 0, 231, 27);
		}
		return lblNewLabel;
	}

	private Panel getMenu() {
		if (menu == null) {
			menu = new Panel();
			menu.setBackground(new Color(228, 228, 228));
			menu.setBounds(0, 33, 712, 34);
			FlowLayout fl_menu = new FlowLayout(FlowLayout.LEFT, 5, 5);
			fl_menu.setAlignOnBaseline(true);
			menu.setLayout(fl_menu);
			menu.add(getLabelMenu());
		}
		return menu;
	}

	private JLabel getLabelMenu() {
		if (labelMenu == null) {
			labelMenu = new JLabel(utilisateurConnecte.getRole().getLibellerole());
			labelMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		}
		return labelMenu;
	}

	private JTextField getTextPrenom() {
		if (textPrenom == null) {
			textPrenom = new JTextField();
			textPrenom.setBounds(229, 115, 201, 20);
			textPrenom.setColumns(10);
		}
		return textPrenom;
	}

	private JLabel getLabelPrenom() {
		if (labelPrenom == null) {
			labelPrenom = new JLabel("Prénom :");
			labelPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelPrenom.setBounds(30, 115, 150, 14);
		}
		return labelPrenom;
	}

	private JLabel getLabelNom() {
		if (labelNom == null) {
			labelNom = new JLabel("Nom :");
			labelNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelNom.setBounds(30, 140, 150, 14);
		}
		return labelNom;
	}

	private JTextField getTextNom() {
		if (textNom == null) {
			textNom = new JTextField();
			textNom.setColumns(10);
			textNom.setBounds(229, 140, 201, 20);
		}
		return textNom;
	}

	private JTextField getTextAdresse() {
		if (textAdresse == null) {
			textAdresse = new JTextField();
			textAdresse.setColumns(10);
			textAdresse.setBounds(229, 165, 400, 20);
		}
		return textAdresse;
	}

	private JLabel getLabelAdresse() {
		if (labelAdresse == null) {
			labelAdresse = new JLabel("Adresse :");
			labelAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelAdresse.setBounds(30, 165, 150, 14);
		}
		return labelAdresse;
	}

	private JTextField getTextCp() {
		if (textCp == null) {
			textCp = new JTextField();
			textCp.setColumns(10);
			textCp.setBounds(229, 193, 201, 20);
		}
		return textCp;
	}

	private JLabel getLblCp() {
		if (lblCp == null) {
			lblCp = new JLabel("CP : ");
			lblCp.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCp.setBounds(30, 193, 150, 14);
		}
		return lblCp;
	}

	private JTextField getTextVille() {
		if (textVille == null) {
			textVille = new JTextField();
			textVille.setColumns(10);
			textVille.setBounds(229, 221, 400, 20);
		}
		return textVille;
	}

	private JLabel getLblVille() {
		if (lblVille == null) {
			lblVille = new JLabel("Ville :");
			lblVille.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblVille.setBounds(30, 221, 150, 14);
		}
		return lblVille;
	}

	private JTextField getTextTelFix() {
		if (textTelFix == null) {
			textTelFix = new JTextField();
			textTelFix.setColumns(10);
			textTelFix.setBounds(229, 249, 400, 20);
		}
		return textTelFix;
	}

	private JLabel getLblTelphone() {
		if (lblTelphone == null) {
			lblTelphone = new JLabel("Téléphone fixe :");
			lblTelphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTelphone.setBounds(30, 249, 150, 14);
		}
		return lblTelphone;
	}

	private JTextField getTextTelPortable() {
		if (textTelPortable == null) {
			textTelPortable = new JTextField();
			textTelPortable.setColumns(10);
			textTelPortable.setBounds(229, 277, 400, 20);
		}
		return textTelPortable;
	}

	private JLabel getLblTelphoneFixe() {
		if (lblTelphoneFixe == null) {
			lblTelphoneFixe = new JLabel("Téléphone portable :");
			lblTelphoneFixe.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTelphoneFixe.setBounds(30, 278, 150, 14);
		}
		return lblTelphoneFixe;
	}

	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAnnuler.setBounds(562, 354, 140, 30);
		}
		return btnAnnuler;
	}

	private JTextField getTextId() {
		if (textId == null) {
			textId = new JTextField();
			textId.setColumns(10);
			textId.setBounds(229, 87, 201, 20);
		}
		return textId;
	}
}
