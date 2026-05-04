package VUES;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre affichant le menu des statistiques des régions.
 * Permet de naviguer vers les différentes pages de statistiques par région selon le type choisi.
 */
public class menu_stats_region extends JFrame {

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
                    menu_stats_region frame = new menu_stats_region("r");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Crée la fenêtre du menu des statistiques des régions.
     * Affiche deux boutons permettant d'accéder aux statistiques de moyenne des frais forfait et hors forfait par région.
     * @param role le rôle de l'utilisateur connecté
     */
    public menu_stats_region(String role) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 576, 362);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitre = new JLabel("Statistiques des régions");
        lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblTitre.setBounds(124, 11, 350, 35);
        contentPane.add(lblTitre);

        JButton btnMoyenneForfait = new JButton("<html><center>La moyenne des montants frais<br>forfait par mois et par région</center></html>");
        btnMoyenneForfait.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new statistiques_region(role, "moyenne_forfait").setVisible(true);
                dispose();
            }
        });
        btnMoyenneForfait.setBounds(10, 105, 233, 77);
        contentPane.add(btnMoyenneForfait);

        JButton btnMoyenneHorsForfait = new JButton("<html><center>La moyenne des montants frais<br>hors forfait par mois et par région</center></html>");
        btnMoyenneHorsForfait.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new statistiques_region(role, "moyenne_hors_forfait").setVisible(true);
                dispose();
            }
        });
        btnMoyenneHorsForfait.setBounds(317, 105, 233, 77);
        contentPane.add(btnMoyenneHorsForfait);

        JButton btnRetour = new JButton("X");
        btnRetour.setBounds(520, 11, 30, 25);
        btnRetour.addActionListener(e -> {
            new Menu(role).setVisible(true);
            dispose();
        });
        contentPane.add(btnRetour);
    }
}