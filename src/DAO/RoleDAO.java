package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import POJO.Role;
import BDD.ConnexionDB;

public class RoleDAO extends DAO<Role> {

	public RoleDAO() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Role findRole(String idRole) {
		Connection con = ConnexionDB.getConnection();

	    String sql = "SELECT * FROM role WHERE idRole = '" + idRole + "'";
	    try {
	        Statement requete = con.createStatement();
	        ResultSet result = requete.executeQuery(sql);

	        while (result.first()) {
	        	Role role = new Role(result.getString("idRole"),result.getString("libelleRole"));
	        	return role;
	        }
	    } catch (SQLException e) {                                      
	        System.out.println("Il n'y a aucun Role avec l'id" + idRole);
	        e.printStackTrace(); // affiche l'erreur précise dans la console
	    }
		return null;
	}

	public ArrayList<Role> findAllRoles() {
		Connection con = ConnexionDB.getConnection();
	    ArrayList<Role> roles = new ArrayList<>();

	    String sql = "SELECT * FROM role";
	    try {
	        Statement requete = con.createStatement();
	        ResultSet result = requete.executeQuery(sql);

	        while (result.next()) {
	        	Role role = new Role(result.getString("idRole"),result.getString("libelleRole"));
	        	roles.add(role);
	        }
	    } catch (SQLException e) {                                      
	        System.out.println("Il n'y a aucun Role");
	        e.printStackTrace(); // affiche l'erreur précise dans la console
	    }
	    return roles;
	}
}