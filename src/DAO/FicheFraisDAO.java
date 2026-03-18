package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDD.ConnexionDB;
import POJO.FicheFrais;

public class FicheFraisDAO extends DAO<FicheFrais> {

	public FicheFraisDAO() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(FicheFrais obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(FicheFrais obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(FicheFrais obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FicheFrais find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<String> selectAllFiche() {

	    List<String> listFiche = new ArrayList<>();
	    Connection conn = null;

	    try {
	        conn = ConnexionDB.getConnection();

	        String sql = "SELECT fichefrais.idUtilisateur, utilisateur.nom, utilisateur.prenom"
	        		+ "FROM fichefrais"
	        		+ "JOIN utilisateur ON fichefrais.idUtilisateur = utilisateur.idUtilisateur";

	        ResultSet result = conn.createStatement().executeQuery(sql);

	        while(result.next()) {

	            String ligne = result.getString("idUtilisateur") + " - " +
	                           result.getString("nom") + " " +
	                           result.getString("prenom");

	            listFiche.add(ligne);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listFiche;
	}

}
