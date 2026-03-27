
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BDD.ConnexionDB;
import POJO.Region;
import POJO.Role;

/**
 * DAO des Régions
 */
public class RegionDAO extends DAO<Region> {

	public RegionDAO() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Region find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Region findRegion(int idRegion) {
		Connection con = ConnexionDB.getConnection();

	    String sql = "SELECT * FROM region WHERE idRegion = '" + idRegion + "'";
	    try {
	        Statement requete = con.createStatement();
	        ResultSet result = requete.executeQuery(sql);

	        while (result.first()) {
	        	Region region = new Region(result.getInt("idRegion"),result.getString("libelleRegion"));
	        	return region;
	        }
	    } catch (SQLException e) {                                      
	        System.out.println("Il n'y a aucune region avec l'id " + idRegion);
	        e.printStackTrace(); // affiche l'erreur précise dans la console
	    }
		return null;
	}

	public ArrayList<Region> findAllRegions() {
		Connection con = ConnexionDB.getConnection();
	    ArrayList<Region> roles = new ArrayList<>();

	    String sql = "SELECT * FROM region";
	    try {
	        Statement requete = con.createStatement();
	        ResultSet result = requete.executeQuery(sql);

	        while (result.next()) {
	        	Region region = new Region(result.getInt("idRegion"),result.getString("libelleRegion"));
	        	roles.add(region);
	        }
	    } catch (SQLException e) {                                      
	        System.out.println("Il n'y a aucune Region");
	        e.printStackTrace(); // affiche l'erreur précise dans la console
	    }
	    return roles;
	}

}