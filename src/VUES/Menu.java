package VUES;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Fenêtre permettant d'afficher le menu principal de l'application.
 * Les boutons affichés varient selon le rôle de l'utilisateur connecté.
 */
public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Point d'entrée principal de l'application, lance la fenêtre.
	 * @param args arguments de la ligne de commande
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Menu frame = new Menu("s");
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

	/**
	 * Crée la fenêtre du menu principal et affiche les boutons selon le rôle.
	 * @param role le rôle de l'utilisateur connecté (ex: "s", "d", "r")
	 */
	public Menu(String role) {
	    JButton btnlistVisiteur = new JButton("Liste des visiteurs");
	    btnlistVisiteur.setBounds(62, 155, 183, 54);
	    btnlistVisiteur.setVisible(false);
	    btnlistVisiteur.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            listeVisiteurs liste = new listeVisiteurs(role);
	            liste.setVisible(true);
	            dispose();
	        }
	    });
	    getContentPane().setLayout(null);
	    getContentPane().add(btnlistVisiteur);

	    JButton btnFicheVisiteur = new JButton("Consulter les fiches des visiteurs");
	    btnFicheVisiteur.setBounds(381, 155, 189, 54);
	    btnFicheVisiteur.setVisible(false);
	    btnFicheVisiteur.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	consulterFicheVisiteurs liste = new consulterFicheVisiteurs(role);
	            liste.setVisible(true);
	            dispose();
	        }
	    });
	    getContentPane().add(btnFicheVisiteur);

	    JButton btnFicheVisiteurDirecteur = new JButton("Consulter les fiches des visiteurs");
	    btnFicheVisiteurDirecteur.setBounds(229, 155, 183, 54);
	    btnFicheVisiteurDirecteur.setVisible(false);
	    btnFicheVisiteurDirecteur.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            new PageTest().setVisible(true);
	        }
	    });
	    getContentPane().add(btnFicheVisiteurDirecteur);

	    JButton btnStatVisiteur = new JButton("Les statistiques des visiteurs");
	    btnStatVisiteur.setBounds(62, 155, 183, 54);
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
	    btnStatRegion.setBounds(381, 155, 189, 54);
	    getContentPane().add(btnStatRegion);

	    if (role.equals("s")) {
	    	btnlistVisiteur.setVisible(true);
	  	    btnFicheVisiteur.setVisible(true);
	    }
	    if (role.equals("d")) {
	    	btnFicheVisiteurDirecteur.setVisible(true);
	    }
	    if (role.equals("r")) {
	    	btnStatVisiteur.setVisible(true);
		    btnStatRegion.setVisible(true);
	    }

	    setTitle("GSB - Accueil");
	    setSize(650, 400);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}