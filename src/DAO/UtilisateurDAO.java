package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BDD.ConnexionDB;
import POJO.Region;
import POJO.Role;
import POJO.Utilisateur;

/**
 * DAO des Utilisateurs
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

	public UtilisateurDAO() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void deleteUtilisateurComplete(String idUtilisateur) {
	    try {
	        Connection conn = ConnexionDB.getConnection();
	        conn.setAutoCommit(false);

	        // 1. Vérifier que TOUTES les fiches sont en état RB
	        PreparedStatement requeteVerifFiche = conn.prepareStatement("SELECT idFiche, idEtat FROM fichefrais WHERE idUtilisateur = ?");
	        requeteVerifFiche.setString(1, idUtilisateur);
	        ResultSet resultatVerif = requeteVerifFiche.executeQuery();

	        while (resultatVerif.next()) {
	            String etat = resultatVerif.getString("idEtat");
	            if (!etat.equals("RB")) {
	                conn.rollback();
	                JOptionPane.showMessageDialog(null,"Impossible de supprimer l'utilisateur , une fiche au moins n'est pas rembourser ");
	                return;
	            }
	        }

	        // 2. Récupérer les idFiche pour supprimer les lignes associées
	        PreparedStatement requeteFiches = conn.prepareStatement("SELECT idFiche FROM fichefrais WHERE idUtilisateur = ?");
	        requeteFiches.setString(1, idUtilisateur);
	        ResultSet resultatFiches = requeteFiches.executeQuery();

	        while (resultatFiches.next()) {
	            int idFiche = resultatFiches.getInt("idFiche");

	            // 3. Supprimer les lignes forfait
	            PreparedStatement psLFF = conn.prepareStatement("DELETE FROM lignefraisforfait WHERE idFiche = ?");
	            psLFF.setInt(1, idFiche);
	            psLFF.executeUpdate();

	            // 4. Supprimer les lignes hors forfait
	            PreparedStatement psLFHF = conn.prepareStatement("DELETE FROM lignefraishorsforfait WHERE idFiche = ?");
	            psLFHF.setInt(1, idFiche);
	            psLFHF.executeUpdate();
	        }

	        // 5. Supprimer les fiches de frais
	        PreparedStatement psFiche = conn.prepareStatement("DELETE FROM fichefrais WHERE idUtilisateur = ?");
	        psFiche.setString(1, idUtilisateur);
	        psFiche.executeUpdate();

	        // 6. Supprimer l'utilisateur
	        PreparedStatement psUser = conn.prepareStatement("DELETE FROM utilisateur WHERE idUtilisateur = ?");
	        psUser.setString(1, idUtilisateur);
	        psUser.executeUpdate();

	        conn.commit();
	        JOptionPane.showMessageDialog(null, "Utilisateur supprimé avec succès !");

	    } 
	    
	    catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Erreur lors de la suppression : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
	    }
	}

	public static void updateUtilisateur(String id, String nom, String prenom, String login, 
            String mdp, String adresse, String cp, String ville, String idRole) {
		String requeteSql = "UPDATE utilisateur SET nom=?, prenom=?, login=?, mdp=?, adresse=?, cp=?, ville=?, idRole=? WHERE idUtilisateur=?";
		try {
			Connection conn = ConnexionDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement(requeteSql);
			stmt.setString(1, nom);
			stmt.setString(2, prenom);
			stmt.setString(3, login);
			stmt.setString(4, mdp);
			stmt.setString(5, adresse);
			stmt.setString(6, cp);
			stmt.setString(7, ville);
			stmt.setString(8, idRole);
			stmt.setString(9, id);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Utilisateur modifié avec succès !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur find(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}


	public static ArrayList<Utilisateur> findAllUtilisateur() {
	    ArrayList<Utilisateur> liste = new ArrayList<>();

	    try {
	        Connection conn = ConnexionDB.getConnection();

	        String sql = "SELECT u.*, ro.libelleRole, re.libelleRegion " +
	                     "FROM utilisateur u " +
	                     "LEFT JOIN role ro ON u.idRole = ro.idRole " +
	                     "LEFT JOIN region re ON u.idRegion = re.idRegion";

	        ResultSet result = conn.createStatement().executeQuery(sql);

	        while (result.next()) {
	            // Reconstruction du Role et de la Region
	            Role role = new Role(
	                result.getString("idRole"),
	                result.getString("libelleRole")
	            );
	            Region region = new Region(
	                result.getInt("idRegion"),
	                result.getString("libelleRegion")
	            );

	            // Construction de l'Utilisateur complet
	            Utilisateur u = new Utilisateur(
	                result.getString("idUtilisateur"),
	                result.getString("nom"),
	                result.getString("prenom"),
	                result.getString("login"),
	                result.getString("mdp"),
	                result.getString("adresse"),
	                result.getString("cp"),
	                result.getString("ville"),
	                result.getDate("dateEmbauche"),
	                role,
	                result.getDate("date_modif_mdp"),
	                region
	            );

	            liste.add(u);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return liste;
	}

}