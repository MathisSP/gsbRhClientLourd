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

	public static void updateUtilisateur(String id, String nom, String prenom, String login, 
            String mdp, String adresse, String cp, String ville, String idRole) {
		String sql = "UPDATE utilisateur SET nom=?, prenom=?, login=?, mdp=?, adresse=?, cp=?, ville=?, idRole=? WHERE idUtilisateur=?";
		try {
			Connection conn = ConnexionDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
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