package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.RegionDAO;
import Objets.Region;
import Objets.Utilisateur;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class pageIndex extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filtreNom;
	private JTextField filtreId;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public pageIndex(Utilisateur user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 450, 300);
		setTitle("Page d'accueil");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fiche visiteur");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 195, 27);
		contentPane.add(lblNewLabel);

		Panel menu = new Panel();
		menu.setBackground(new Color(228, 228, 228));
		menu.setBounds(0, 33, 434, 33);
		contentPane.add(menu);
		FlowLayout fl_menu = new FlowLayout(FlowLayout.LEFT, 5, 5);
		fl_menu.setAlignOnBaseline(true);
		menu.setLayout(fl_menu);

		JLabel labelMenu = new JLabel("Menu " + user.getRole().getLibellerole().toLowerCase());
		labelMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		menu.add(labelMenu);

		JButton btnConsulter = new JButton("Consulter");
		menu.add(btnConsulter);

		JButton btnModifier = new JButton("Modifier");
		menu.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		menu.add(btnSupprimer);

		Panel zoneFiltre = new Panel();
		zoneFiltre.setBounds(0, 72, 434, 33);
		contentPane.add(zoneFiltre);
		zoneFiltre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		RegionDAO regiondao = new RegionDAO();
		List<Region> liste = regiondao.obtenirToutesRegions();

		JComboBox selectRegion = new JComboBox();
		selectRegion.setEditable(true);
		selectRegion.setModel(new DefaultComboBoxModel(new String[] { "Sélectionner la région" }));
		for (int i = 0; i < liste.size(); i++) {
			selectRegion.addItem(liste.get(i).getNomRegion());
		}
		selectRegion.setToolTipText("");
		zoneFiltre.add(selectRegion);

		filtreNom = new JTextField();
		filtreNom.setToolTipText("Saisissez un nom");
		filtreNom.setText("Recherche nom");
		zoneFiltre.add(filtreNom);
		filtreNom.setColumns(10);

		filtreId = new JTextField();
		filtreId.setText("Recherche ID");
		zoneFiltre.add(filtreId);
		filtreId.setColumns(10);

		table = new JTable();
		table.setBounds(10, 111, 414, 139);
		contentPane.add(table);
	}
}
