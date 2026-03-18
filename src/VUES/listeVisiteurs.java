package VUES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JList;
import java.awt.List;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listeVisiteurs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelVisiteurs;
	private JLabel labelListVis;
	private JButton btnCreationVisiteur;
	private JButton btnModification;
	private JButton btnSupprimer;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listeVisiteurs frame = new listeVisiteurs();
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
	public listeVisiteurs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabelVisiteurs());
		contentPane.add(getLabelListVis());
		contentPane.add(getBtnCreationVisiteur());
		contentPane.add(getBtnModification());
		contentPane.add(getBtnSupprimer());
		contentPane.add(getList());

	}
	public JLabel getLabelVisiteurs() {
		if (labelVisiteurs == null) {
			labelVisiteurs = new JLabel("Visiteurs");
			labelVisiteurs.setBounds(176, 11, 69, 20);
			labelVisiteurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelVisiteurs.setBackground(new Color(240, 240, 240));
		}
		return labelVisiteurs;
	}
	public JLabel getLabelListVis() {
		if (labelListVis == null) {
			labelListVis = new JLabel("Liste des visiteurs(id, nom, prénom))");
			labelListVis.setBounds(124, 102, 176, 30);
			labelListVis.setForeground(Color.BLACK);
			labelListVis.setFont(new Font("Arial", labelListVis.getFont().getStyle(), labelListVis.getFont().getSize()));
			labelListVis.setBackground(new Color(0, 0, 0));
		}
		return labelListVis;
	}
	public JButton getBtnCreationVisiteur() {
		if (btnCreationVisiteur == null) {
			btnCreationVisiteur = new JButton("Créer");
			btnCreationVisiteur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					informationVisiteur newVisiteur = new informationVisiteur();
					newVisiteur.setVisible(true);
					dispose();
				}
			});
			btnCreationVisiteur.setBounds(92, 198, 75, 20);
		}
		return btnCreationVisiteur;
	}
	public JButton getBtnModification() {
		if (btnModification == null) {
			btnModification = new JButton("Modifier");
			btnModification.setBounds(176, 198, 75, 20);
		}
		return btnModification;
	}
	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setBounds(261, 197, 75, 20);
		}
		return btnSupprimer;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(92, 42, 244, 145);
		}
		return list;
	}
}
