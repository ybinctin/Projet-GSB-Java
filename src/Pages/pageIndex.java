package Pages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.RegionDAO;
import DAO.UtilisateurDAO;
import Objets.Region;
import Objets.Utilisateur;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
	private DefaultTableModel model;
	private List<Utilisateur> listeUtilisateurs;
	public static pageIndex instance;
	private JLabel decoEspace;

	/**
	 * Create the frame.
	 */
	public pageIndex(Utilisateur utilisateurConnecte) {
		instance = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(724, 510);
		setLocationRelativeTo(null);
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
		menu.setBounds(0, 33, 708, 33);
		contentPane.add(menu);
		FlowLayout fl_menu = new FlowLayout(FlowLayout.LEFT, 5, 5);
		fl_menu.setAlignOnBaseline(true);
		menu.setLayout(fl_menu);

		JLabel labelMenu = new JLabel("Menu " + utilisateurConnecte.getRole().getLibellerole().toLowerCase());
		labelMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		menu.add(labelMenu);

		Panel zoneFiltre = new Panel();
		zoneFiltre.setBounds(0, 72, 708, 33);
		contentPane.add(zoneFiltre);
		zoneFiltre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		RegionDAO regiondao = new RegionDAO();
		List<Region> liste = regiondao.obtenirToutesRegions();

		JComboBox selectRegion = new JComboBox();
		selectRegion.setEditable(false);
		selectRegion.setModel(new DefaultComboBoxModel(new String[] { "Sélectionner la région" }));
		for (int i = 0; i < liste.size(); i++) {
			selectRegion.addItem(liste.get(i).getNomRegion());
		}
		selectRegion.setToolTipText("");
		zoneFiltre.add(selectRegion);

		filtreId = new JTextField();
		filtreId.setToolTipText("Saisissez un ID");
		// filtreId.setText("Recherche ID");
		zoneFiltre.add(filtreId);
		filtreId.setColumns(10);

		filtreId.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				filtrer();
			}
		});

		filtreNom = new JTextField();
		filtreNom.setToolTipText("Saisissez un nom");
		// filtreNom.setText("Recherche nom");
		zoneFiltre.add(filtreNom);
		filtreNom.setColumns(10);

		filtreNom.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				filtrer();
			}
		});

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // bloque toute modification
			}
		};

		table.setModel(model);

		// Création des colonnes
		model.addColumn("idUtilisateur");
		model.addColumn("Nom");
		model.addColumn("Prénom");

		updateListeUtilisateurs();

		table.setBounds(10, 111, 414, 139);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 111, 688, 316);
		contentPane.add(scrollPane);
		menu.add(getDecoEspace());

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(model.getValueAt(table.getSelectedRow(), 0));

				UtilisateurDAO utilisaDAO = new UtilisateurDAO();
				Utilisateur utilisateur = utilisaDAO.find(model.getValueAt(table.getSelectedRow(), 0).toString());
				pageEditionUtilisateur pageEU = new pageEditionUtilisateur(utilisateur, utilisateurConnecte,
						"modification");
				pageEU.show();
			}
		});

		JButton btnConsulter = new JButton("Consulter");

		// TODO: A terminer
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(model.getValueAt(table.getSelectedRow(), 0));

				UtilisateurDAO utilisaDAO = new UtilisateurDAO();
				Utilisateur utilisateur = utilisaDAO.find(model.getValueAt(table.getSelectedRow(), 0).toString());
				pageEditionUtilisateur pageEU = new pageEditionUtilisateur(utilisateur, utilisateurConnecte,
						"consultation");
				pageEU.show();
			}
		});

		JButton btnCreer = new JButton("Créer");
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menu.add(btnCreer);
		menu.add(btnConsulter);

		menu.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		menu.add(btnSupprimer);

		JButton btnNewButton = new JButton("Consulter les fiches");
		btnNewButton.setBounds(285, 438, 177, 23);
		contentPane.add(btnNewButton);

	}

	private void filtrer() {
		model.setRowCount(0);

		String nomRecherche = filtreNom.getText().toLowerCase();
		String idRecherche = filtreId.getText().toLowerCase();

		for (Utilisateur u : listeUtilisateurs) {
			boolean Nom = u.getNom().toLowerCase().contains(nomRecherche);
			boolean Id = String.valueOf(u.getIdUtilisateur().toLowerCase()).contains(idRecherche);

			if (Nom && Id) {
				model.addRow(new Object[] { u.getIdUtilisateur(), u.getNom(), u.getPrenom() });
			}
		}
	}

	public void updateListeUtilisateurs() {

		UtilisateurDAO utilisateurdao = new UtilisateurDAO();
		listeUtilisateurs = utilisateurdao.tousLesUtilisateurs();

		model.setRowCount(0);

		for (Utilisateur utilisateurActuel : listeUtilisateurs) {
			model.addRow(new Object[] { utilisateurActuel.getIdUtilisateur(), utilisateurActuel.getNom(),
					utilisateurActuel.getPrenom() });
		}
	}

	private JLabel getDecoEspace() {
		if (decoEspace == null) {
			decoEspace = new JLabel("                         ");
		}
		return decoEspace;
	}
}
