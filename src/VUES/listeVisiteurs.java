
package VUES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import DAO.UtilisateurDAO;
import POJO.Utilisateur;

public class listeVisiteurs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelVisiteurs;
	private JButton btnCreationVisiteur;
	private JButton btnModification;
	private JButton btnSupprimer;
	private JTable table;
	private ArrayList<Utilisateur> utilisateurs; // ajout ici
	private JButton btnRetour;
	private String role; // ajouter cet attribut

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listeVisiteurs frame = new listeVisiteurs("s");
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
	public listeVisiteurs(String role) {
		this.role = role;
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 550, 400);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    contentPane.add(getLabelVisiteurs());
	    contentPane.add(getBtnCreationVisiteur());
	    contentPane.add(getBtnModification());
	    contentPane.add(getBtnSupprimer());

	    // Colonnes du tableau
	    String[] colonnes = {"ID", "Nom", "Prénom", "Login", "Ville", "Rôle"};

	    // Récupération des utilisateurs
	    utilisateurs = UtilisateurDAO.findAllUtilisateur();

	    // Remplissage des données
	    String[][] data = new String[utilisateurs.size()][6];
	    for (int i = 0; i < utilisateurs.size(); i++) {
	        Utilisateur u = utilisateurs.get(i);
	        data[i][0] = String.valueOf(u.getIdUtilisateur());
	        data[i][1] = u.getNom();
	        data[i][2] = u.getPrenom();
	        data[i][3] = u.getLogin();
	        data[i][4] = u.getVille();
	        data[i][5] = u.getIdRole().getLibelleRole();
	    }

	    // Création du tableau avec les données
	    table = new JTable(data, colonnes) {
	        // Empêche la modification des cellules en cliquant dessus
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };
	    
	    // Sélection d'une seule ligne à la fois
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    // Ajout du tableau dans un ScrollPane pour avoir la barre de défilement
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(50, 69, 410, 229);
	    contentPane.add(scrollPane);
	    contentPane.add(getBtnRetour());
	}
	public JLabel getLabelVisiteurs() {
		if (labelVisiteurs == null) {
			labelVisiteurs = new JLabel("Visiteurs");
			labelVisiteurs.setBounds(225, 11, 69, 20);
			labelVisiteurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelVisiteurs.setBackground(new Color(240, 240, 240));
		}
		return labelVisiteurs;
	}
	
	private Utilisateur getUtilisateurSelectionne() {
	    int ligneSelectionnee = table.getSelectedRow();
	    if (ligneSelectionnee == -1) {
	        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur.", "Attention", JOptionPane.WARNING_MESSAGE);
	        return null;
	    }
	    return utilisateurs.get(ligneSelectionnee);
	}
	public JButton getBtnCreationVisiteur() {
		if (btnCreationVisiteur == null) {
			btnCreationVisiteur = new JButton("Créer");
			btnCreationVisiteur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					informationVisiteur newVisiteur = new informationVisiteur(null, role);
					newVisiteur.setVisible(true);
					dispose();
				}
			});
			btnCreationVisiteur.setBounds(50, 318, 75, 20);
		}
		return btnCreationVisiteur;
	}
	public JButton getBtnModification() {
	    if (btnModification == null) {
	        btnModification = new JButton("Modifier");
	        btnModification.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Utilisateur u = getUtilisateurSelectionne();
	                if (u != null) {
	                    informationVisiteur modif = new informationVisiteur(u, role);
	                    modif.setVisible(true);
	                    dispose();
	                }
	            }
	        });
	        btnModification.setBounds(225, 318, 75, 20);
	    }
	    return btnModification;
	}

	public JButton getBtnSupprimer() {
	    if (btnSupprimer == null) {
	        btnSupprimer = new JButton("Supprimer");
	        btnSupprimer.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Utilisateur u = getUtilisateurSelectionne();
	                if (u != null) {
	                    int confirmation = JOptionPane.showConfirmDialog(null, 
	                        "Supprimer " + u.getNom() + " " + u.getPrenom() + " ?", 
	                        "Confirmation", JOptionPane.YES_NO_OPTION);
	                    if (confirmation == JOptionPane.YES_OPTION) {
	                        UtilisateurDAO.deleteUtilisateurComplete(u.getIdUtilisateur()); // appel DAO
	                        
	                        // Rafraîchir la page
	                        listeVisiteurs nouvelleListe = new listeVisiteurs(role);
	                        nouvelleListe.setVisible(true);
	                        dispose();
	                    }
	                }
	            }
	        });
	        btnSupprimer.setBounds(389, 318, 75, 20);
	    }
	    return btnSupprimer;
	}
	
	private JButton getBtnRetour() {
	    if (btnRetour == null) {
	        btnRetour = new JButton("X");
	        btnRetour.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Menu reMenu = new Menu(role); // role est maintenant connu
	                reMenu.setVisible(true);
	                dispose();
	            }
	        });
	        btnRetour.setBounds(501, 13, 23, 20);
	    }
	    return btnRetour;
	}
}