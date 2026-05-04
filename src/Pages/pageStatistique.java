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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class pageStatistique extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private Panel menu;
	private JLabel labelMenu;
	private JButton btnConsulter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageStatistique frame = new pageStatistique();
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
	public pageStatistique() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(724, 510);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getMenu());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getComboBox());
		contentPane.add(getComboBox_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("{role}");
			lblNewLabel.setBounds(10, 0, 51, 27);
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		}
		return lblNewLabel;
	}
	private Panel getMenu() {
		if (menu == null) {
			menu = new Panel();
			menu.setBounds(0, 33, 434, 34);
			menu.setBackground(new Color(228, 228, 228));
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
			btnSupprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnSupprimer;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Visiteur", "Nombre fiches hors forfait", "Montant fiches hors forfait", "Montant fiches fortfait"
				}
			));
		}
		return table;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 111, 414, 79);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable_1_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Moyenne fiche hors forfait", "Moyenne montant fiches forfait"
				}
			));
		}
		return table_1;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 196, 414, 54);
			scrollPane_1.setViewportView(getTable_1_1());
		}
		return scrollPane_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Séléctionner la régions --"}));
			comboBox.setBounds(100, 78, 156, 22);
		}
		return comboBox;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-- Sélectionner le mois --"}));
			comboBox_1.setBounds(266, 78, 142, 22);
		}
		return comboBox_1;
	}
}
