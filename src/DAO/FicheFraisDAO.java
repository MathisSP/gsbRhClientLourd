package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDD.ConnexionDB;
import POJO.FicheFrais;
/**
 * DAO des fiches de frais
 */
public class FicheFraisDAO extends DAO<FicheFrais> {
	
	/**
	 * Instanciation du DAO
	 */
	public FicheFraisDAO() {
		super(null);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Méthode pour créer une fiche de frais
	 * @param ficheFrais prend un objet FicheFrais comme données
	 * @return boolean vrai ou faux si la création de la fiche de frais a bien été faite
	 */
	@Override
	public boolean create(FicheFrais ficheFrais) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* Méthode pour effacer une fiche de frais
	* @param ficheFrais prend un objet FicheFrais comme données
	* @return boolean vrai ou faux si la suppression de la fiche de frais a bien été faite
	*/
	@Override
	public boolean delete(FicheFrais ficheFrais) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* Méthode de mise à jour d'une fiche de frais
	* @param ficheFrais prend un objet FicheFrais comme données
	* @return boolean vrai ou faux si la mise a jour de la fiche de frais a bien été faite
	*/
	@Override
	public boolean update(FicheFrais ficheFrais) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	* Méthode de recherche des informations d'une fiche de frais
	* @param idFicheFrais un id d'une fiche de frais
	* @return FicheFrais un objet FicheFrais contenant les informations de la fiche de frais
	*/
	@Override
	public FicheFrais find(int idFicheFrais) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Méthode de recherche des informations de toutes les fiche de frais
	 * 
	 * @return {@code ArrayList<String>} Une Liste de fiches de frais
	 */
	public static ArrayList<String> selectAllFiche() {

		ArrayList<String> listFiche = new ArrayList<>();
	    Connection conn = null;
	    try {
	        conn = ConnexionDB.getConnection();
	        String sql = "SELECT fichefrais.idUtilisateur, utilisateur.nom, utilisateur.prenom" + "FROM fichefrais" + "JOIN utilisateur ON fichefrais.idUtilisateur = utilisateur.idUtilisateur";
	        ResultSet result = conn.createStatement().executeQuery(sql);
	        while(result.next()) {
	            String ligne = result.getString("idUtilisateur") + " - " + result.getString("nom") + " " + result.getString("prenom");
	            listFiche.add(ligne);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listFiche;
	}
}
