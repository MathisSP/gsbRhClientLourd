package VUES;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DAO.FicheFraisDAO;

/**
 * Fenêtre affichant les statistiques des visiteurs sous forme de tableau.
 * Le contenu du tableau varie selon le type de statistique sélectionné.
 */
public class statistiques_visiteur extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableVisiteurs;
    private String role;
    private String type;
    private DefaultTableModel model;

    /**
     * Point d'entrée principal de l'application, lance la fenêtre.
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new statistiques_visiteur("r", "nb_hors_forfait").setVisible(true);
            } catch (Exception e) { e.printStackTrace(); }
        });
    }

    /**
     * Crée la fenêtre des statistiques des visiteurs.
     * Affiche un tableau dont les colonnes et les données varient selon le type, ainsi qu'un sélecteur de mois pour filtrer les résultats.
     * @param role le rôle de l'utilisateur connecté
     * @param type le type de statistique à afficher :
     *    - "nb_hors_forfait" = pour le nombre de fiches hors forfait,
     *    - "montant_hors_forfait" = pour les montants totaux hors forfait,
     *    - "montant_forfait" = pour les montants totaux forfait
     */
    public statistiques_visiteur(String role, String type) {
        this.role = role;
        this.type = type;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        setContentPane(contentPane = new JPanel());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        String titrePage;
        String[] colonnes;
        switch (type) {
            case "nb_hors_forfait":
                titrePage = "Nombre de fiches hors forfait par mois";
                colonnes = new String[]{"ID", "Nom", "Prénom", "Mois", "Nb hors forfait"};
                break;
            case "montant_hors_forfait":
                titrePage = "Montants totaux des fiches hors forfait par mois";
                colonnes = new String[]{"ID", "Nom", "Prénom", "Mois", "Montant hors forfait"};
                break;
            default:
                titrePage = "Montants totaux des frais forfait par mois";
                colonnes = new String[]{"ID", "Nom", "Prénom", "Mois", "Montant forfait"};
        }
        setTitle(titrePage);

        JLabel lblTitre = new JLabel("<html><center>" + titrePage + "</center></html>");
        lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTitre.setBounds(100, 10, 480, 45);
        contentPane.add(lblTitre);

        model = new DefaultTableModel(colonnes, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tableVisiteurs = new JTable(model);
        tableVisiteurs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(tableVisiteurs);
        scrollPane.setBounds(30, 65, 620, 300);
        contentPane.add(scrollPane);

        JLabel lblMois = new JLabel("Sélectionnez un mois :");
        lblMois.setBounds(100, 385, 150, 20);
        contentPane.add(lblMois);

        String[] mois = {"Janvier","Février","Mars","Avril","Mai","Juin",
                         "Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
        JComboBox<String> comboMois = new JComboBox<>(mois);
        comboMois.setBounds(255, 382, 160, 28);
        comboMois.addActionListener(e -> {
            int moisSelectionne = comboMois.getSelectedIndex() + 1;
            chargerDonnees(moisSelectionne);
        });
        contentPane.add(comboMois);

        JButton btnRetour = new JButton("X");
        btnRetour.setBounds(648, 5, 30, 25);
        btnRetour.addActionListener(e -> {
            new menu_stats_visiteur(role).setVisible(true);
            dispose();
        });
        contentPane.add(btnRetour);

        chargerDonnees(1);
    }

    /**
     * Recharge les données du tableau selon le mois sélectionné et le type de statistique.
     * Vide d'abord le tableau, puis appelle le DAO correspondant au type
     * @param mois le numéro du mois à afficher (1 = Janvier, 12 = Décembre)
     */
    private void chargerDonnees(int mois) {
        model.setRowCount(0);
        ArrayList<Object[]> donnees;

        switch (type) {
            case "nb_hors_forfait":
                donnees = FicheFraisDAO.getNbHorsForfaitParMois(mois);
                break;
            case "montant_hors_forfait":
                donnees = FicheFraisDAO.getMontantHorsForfaitParMois(mois);
                break;
            default:
                donnees = FicheFraisDAO.getMontantForfaitParMois(mois);
        }

        for (Object[] ligne : donnees) {
            model.addRow(ligne);
        }
    }
}