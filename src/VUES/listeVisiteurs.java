
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
import javax.swing.JTextField;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class listeVisiteurs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCreationVisiteur;
	private JButton btnModification;
	private JButton btnSupprimer;
	private JTable tableVisiteurs;
	private ArrayList<Utilisateur> utilisateurs; // ajout ici
	private JButton btnRetour;
	private String role; // ajouter cet attribut
	private JTextField tfRechercheVisiteurs;

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
	    contentPane.add(getBtnCreationVisiteur());
	    contentPane.add(getBtnModification());
	    contentPane.add(getBtnSupprimer());

	    // Label Visiteurs en haut de la page
	    JLabel labelVisiteurs = new JLabel("Visiteurs");
	    labelVisiteurs.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelVisiteurs.setBounds(201, 24, 114, 34);
		contentPane.add(labelVisiteurs);
		
		// Colonnes du tableau utiliser
		String[] colonnes = {"ID", "Nom", "Prénom", "Login", "Ville", "Rôle"};

		// Récupération des utilisateurs par le DAO
		utilisateurs = UtilisateurDAO.findAllUtilisateur();

		// tableau en empechant la modification des cellules
		DefaultTableModel tableVisiteursModel = new DefaultTableModel(colonnes, 0) {
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};

		// Remplissage du tableau avec les visiteurs
		for (Utilisateur u : utilisateurs) {
			tableVisiteursModel.addRow(new String[]{u.getIdUtilisateur(),u.getNom(),u.getPrenom(),u.getLogin(),u.getVille(),u.getIdRole().getLibelleRole()});
		}

		tableVisiteurs = new JTable(tableVisiteursModel);
		tableVisiteurs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(tableVisiteurs);
		scrollPane.setBounds(50, 69, 410, 229);
		contentPane.add(scrollPane);
		contentPane.add(getBtnRetour());

		// Label recherche
		JLabel lblRechercheVisiteurs = new JLabel("Rechercher : ");
		lblRechercheVisiteurs.setBounds(50, 16, 85, 14);
		contentPane.add(lblRechercheVisiteurs);

		// Champ de recherche avec filtrage en temps réel
		tfRechercheVisiteurs = new JTextField();
		tfRechercheVisiteurs.setBounds(49, 38, 139, 20);
		tfRechercheVisiteurs.setColumns(10);
		contentPane.add(tfRechercheVisiteurs);

		// Modification du tableau pour afficher seulement ce qui correspond à la recherche de la barre de recherche
		tfRechercheVisiteurs.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate(DocumentEvent e)  { filtrer(); }
		    public void removeUpdate(DocumentEvent e)  { filtrer(); }
		    public void changedUpdate(DocumentEvent e) { filtrer(); }

		    private void filtrer() {
		        String recherche = tfRechercheVisiteurs.getText().toLowerCase().trim();
		        tableVisiteursModel.setRowCount(0); // Vider le tableau

		        for (Utilisateur u : utilisateurs) {
		        	// recherche dans chaque colonne si ce qui a été écrit dans la barre de recherche existe aussi dans le tableau
		            if (u.getIdUtilisateur().toLowerCase().contains(recherche)|| u.getNom().toLowerCase().contains(recherche)|| u.getPrenom().toLowerCase().contains(recherche)|| u.getLogin().toLowerCase().contains(recherche)|| u.getVille().toLowerCase().contains(recherche)|| u.getIdRole().getLibelleRole().toLowerCase().contains(recherche)) 
		            {
		            	// ajouter la ligne à la recherche faite
		            	tableVisiteursModel.addRow(new String[]{u.getIdUtilisateur(),u.getNom(),u.getPrenom(),u.getLogin(),u.getVille(),u.getIdRole().getLibelleRole()});
		            }
		        }
		    }
		});
	}
	
	private Utilisateur getUtilisateurSelectionne() {
	    int ligneSelectionnee = tableVisiteurs.getSelectedRow();
	    if (ligneSelectionnee == -1) {
	        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur.",
	            "Attention", JOptionPane.WARNING_MESSAGE);
	        return null;
	    }
	    // Récupérer l'ID affiché dans la ligne sélectionnée
	    String idSelectionne = (String) tableVisiteurs.getValueAt(ligneSelectionnee, 0);
	    // Retrouver l'utilisateur correspondant dans la liste complète
	    for (Utilisateur u : utilisateurs) {
	        if (u.getIdUtilisateur().equals(idSelectionne)) {
	            return u;
	        }
	    }
	    return null;
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
			btnCreationVisiteur.setBounds(50, 318, 99, 20);
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
	        btnModification.setBounds(201, 318, 99, 20);
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
	        btnSupprimer.setBounds(358, 318, 106, 20);
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