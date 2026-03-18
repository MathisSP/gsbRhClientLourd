package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDD.ConnexionDB;
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

	@Override
	public Utilisateur find(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}


	public static List<String> selectAllUtilisateur() {

	    List<String> liste = new ArrayList<>();
	    Connection conn = null;

	    try {
	        conn = ConnexionDB.getConnection();

	        String sql = "SELECT idUtilisateur, nom, prenom FROM utilisateur";
	        ResultSet result = conn.createStatement().executeQuery(sql);

	        while(result.next()) {

	            String ligne = result.getString("idUtilisateur") + " - " +
	                           result.getString("nom") + " " +
	                           result.getString("prenom");

	            liste.add(ligne);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return liste;
	}

}
