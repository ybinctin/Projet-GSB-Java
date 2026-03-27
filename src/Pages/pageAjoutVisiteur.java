package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class pageAjoutVisiteur extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private Panel menu;
	private JLabel labelMenu;
	private JButton btnConsulter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JTextField textField;
	private JLabel labelPrenom;
	private JLabel labelNom;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel labelAdresse;
	private JTextField textField_3;
	private JLabel lblCp;
	private JTextField textField_4;
	private JLabel lblVille;
	private JTextField textField_5;
	private JLabel lblTlphone;
	private JTextField textField_6;
	private JLabel lblTlphoneFixe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageAjoutVisiteur frame = new pageAjoutVisiteur();
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
	public pageAjoutVisiteur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getMenu());
		contentPane.add(getTextField());
		contentPane.add(getLabelPrenom());
		contentPane.add(getLabelNom());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
		contentPane.add(getLabelAdresse());
		contentPane.add(getTextField_3());
		contentPane.add(getLblCp());
		contentPane.add(getTextField_4());
		contentPane.add(getLblVille());
		contentPane.add(getTextField_5());
		contentPane.add(getLblTlphone());
		contentPane.add(getTextField_6());
		contentPane.add(getLblTlphoneFixe());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("{role}");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 20));
			lblNewLabel.setBounds(10, 0, 51, 27);
		}
		return lblNewLabel;
	}
	private Panel getMenu() {
		if (menu == null) {
			menu = new Panel();
			menu.setBackground(new Color(228, 228, 228));
			menu.setBounds(0, 33, 434, 34);
			FlowLayout fl_menu = new FlowLayout(FlowLayout.LEFT, 5, 5);
			fl_menu.setAlignOnBaseline(true);
			menu.setLayout(fl_menu);
			menu.add(getLabelMenu());
			menu.add(getBtnConsulter());
			menu.add(getBtnModifier());
			menu.add(getBtnSupprimer());
		}
		return menu;
	}
	private JLabel getLabelMenu() {
		if (labelMenu == null) {
			labelMenu = new JLabel("Menu {role]");
			labelMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		}
		return labelMenu;
	}
	private JButton getBtnConsulter() {
		if (btnConsulter == null) {
			btnConsulter = new JButton("Statistiques");
		}
		return btnConsulter;
	}
	private JButton getBtnModifier() {
		if (btnModifier == null) {
			btnModifier = new JButton("Fiches F.");
		}
		return btnModifier;
	}
	private JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton("Visiteur");
		}
		return btnSupprimer;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(130, 73, 196, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLabelPrenom() {
		if (labelPrenom == null) {
			labelPrenom = new JLabel("Prénom :");
			labelPrenom.setBounds(52, 76, 68, 14);
		}
		return labelPrenom;
	}
	private JLabel getLabelNom() {
		if (labelNom == null) {
			labelNom = new JLabel("Nom :");
			labelNom.setBounds(52, 101, 68, 14);
		}
		return labelNom;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(130, 98, 196, 20);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(130, 123, 196, 20);
		}
		return textField_2;
	}
	private JLabel getLabelAdresse() {
		if (labelAdresse == null) {
			labelAdresse = new JLabel("Adresse :");
			labelAdresse.setBounds(52, 126, 68, 14);
		}
		return labelAdresse;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(130, 151, 196, 20);
		}
		return textField_3;
	}
	private JLabel getLblCp() {
		if (lblCp == null) {
			lblCp = new JLabel("CP : ");
			lblCp.setBounds(52, 154, 68, 14);
		}
		return lblCp;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(130, 179, 196, 20);
		}
		return textField_4;
	}
	private JLabel getLblVille() {
		if (lblVille == null) {
			lblVille = new JLabel("Ville :");
			lblVille.setBounds(52, 182, 68, 14);
		}
		return lblVille;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(130, 207, 196, 20);
		}
		return textField_5;
	}
	private JLabel getLblTlphone() {
		if (lblTlphone == null) {
			lblTlphone = new JLabel("Téléphone fixe :");
			lblTlphone.setBounds(52, 210, 68, 14);
		}
		return lblTlphone;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(130, 235, 196, 20);
		}
		return textField_6;
	}
	private JLabel getLblTlphoneFixe() {
		if (lblTlphoneFixe == null) {
			lblTlphoneFixe = new JLabel("Téléphone portable :");
			lblTlphoneFixe.setBounds(52, 238, 68, 14);
		}
		return lblTlphoneFixe;
	}
}
