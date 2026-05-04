package VUES;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre affichant le menu des statistiques des visiteurs.
 * Permet de naviguer vers les différentes pages de statistiques selon le type choisi.
 */
public class menu_stats_visiteur extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Point d'entrée principal de l'application, lance la fenêtre.
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menu_stats_visiteur frame = new menu_stats_visiteur("r");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Crée la fenêtre du menu des statistiques des visiteurs.
     * Affiche trois boutons permettant d'accéder aux différentes statistiques : nombre de fiches hors forfait, montants hors forfait, et montants forfait.
     * @param role le rôle de l'utilisateur connecté
     */
    public menu_stats_visiteur(String role) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 682, 428);
        setTitle("Statistiques - Menu");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitre = new JLabel("Statistiques des visiteurs");
        lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblTitre.setBounds(190, 20, 350, 35);
        contentPane.add(lblTitre);

        JButton btnfichehorsforfait = new JButton("<html><center>Le nombre de fiches frais hors forfait par mois et par région pour chaque visiteur</center></html>");
        btnfichehorsforfait.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new statistiques_visiteur(role, "nb_hors_forfait").setVisible(true);
                dispose();
            }
        });
        btnfichehorsforfait.setBounds(44, 97, 233, 71);
        contentPane.add(btnfichehorsforfait);

        JButton btnMontanthorsForfait = new JButton("<html><center>Les montants totaux des fiches<br>hors forfait par mois et par region pour chaque visiteur</center></html>");
        btnMontanthorsForfait.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new statistiques_visiteur(role, "montant_hors_forfait").setVisible(true);
                dispose();
            }
        });
        btnMontanthorsForfait.setBounds(336, 97, 233, 71);
        contentPane.add(btnMontanthorsForfait);

        JButton btnMontantTotal = new JButton("<html><center>Les montants totaux des frais forfait par mois et par region pour chaque visiteur</center></html>");
        btnMontantTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new statistiques_visiteur(role, "montant_forfait").setVisible(true);
                dispose();
            }
        });
        btnMontantTotal.setBounds(199, 202, 233, 71);
        contentPane.add(btnMontantTotal);

        JButton btnRetour = new JButton("X");
        btnRetour.setBounds(630, 5, 30, 25);
        btnRetour.addActionListener(e -> {
            new Menu(role).setVisible(true);
            dispose();
        });
        contentPane.add(btnRetour);
    }
}