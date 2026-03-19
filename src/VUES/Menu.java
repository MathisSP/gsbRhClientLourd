package VUES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Menu frame = new Menu("s"); // rôle par défaut pour les tests
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
	public Menu(String role) {

	    // Bouton Secrétaire RH — visible uniquement pour le rôle "s" (à adapter)
	    JButton btnlistVisiteur = new JButton("Liste des visiteurs");
	    btnlistVisiteur.setBounds(10, 91, 164, 40);
	    btnlistVisiteur.setVisible(false);
	    btnlistVisiteur.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            new PageTest().setVisible(true);
	        }
	    });
	    getContentPane().setLayout(null);
	    getContentPane().add(btnlistVisiteur);

	    // Bouton Directeur RH — visible uniquement pour le rôle "d"
	    JButton btnFicheVisiteur = new JButton("Consulter les fiches des visiteurs");
	    btnFicheVisiteur.setBounds(276, 91, 183, 40);
	    btnFicheVisiteur.setVisible(false);
	    btnFicheVisiteur.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            new PageTest().setVisible(true);
	        }
	    });
	    getContentPane().add(btnFicheVisiteur);

	    // Bouton Responsable Frais — visible uniquement pour le rôle "r"
	    JButton btnStatVisiteur = new JButton("Les statistiques des visiteurs");
	    btnStatVisiteur.setBounds(10, 158, 196, 40);
	    btnStatVisiteur.setVisible(false);
	    btnStatVisiteur.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            new PageTest().setVisible(true);
	        }
	    });
	    getContentPane().add(btnStatVisiteur);
	    
	    JButton btnStatRegion = new JButton("Les Statistiques des Régions");
	    btnStatRegion.setVisible(false);
	    btnStatRegion.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnStatRegion.setBounds(282, 158, 177, 40);
	    getContentPane().add(btnStatRegion);

	    // Affichage selon le rôle
	    if (role.equals("s")) {
	    	btnlistVisiteur.setVisible(true);
	  	    btnFicheVisiteur.setVisible(true);
	    }
	    if(role.equals("d")) {
	    	btnFicheVisiteur.setVisible(true);
	    }
	    if(role.equals("r")) {
	    	btnStatVisiteur.setVisible(true);
		    btnStatRegion.setVisible(true);
	    }
	    
	    
	    setTitle("GSB - Accueil");
	    setSize(500, 300);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
