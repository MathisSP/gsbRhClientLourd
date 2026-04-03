package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDD.ConnexionDB;
import POJO.FicheFrais;
import POJO.Region;
import POJO.Role;
import POJO.Utilisateur;
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
		Connection con = ConnexionDB.getConnection();

	    String sql = "SELECT * FROM fichefrais WHERE idFiche = '" + idFicheFrais + "'";
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, idFicheFrais);
	        ResultSet result = stmt.executeQuery();

	        if (result.next()) {
	            Role role = new Role(
	                result.getString("idRole"),
	                result.getString("libelleRole")
	            );
	            Region region = new Region(
	                result.getInt("idRegion"),
	                result.getString("libelleRegion")
	            );
	            return new FicheFrais(
	                result.getInt("idFiche"),
	                result.getString("idUtilisaateur"),
	                result.getInt("annee"),
	                result.getInt("mois"),
	                result.getInt("nbJustificatifs"),
	                result.getFloat("montantValide"),
	                result.getDate("dateModif"),
	                result.getString("idEtat")
	            );
	        }
	    } catch (SQLException e) {                                      
	        System.out.println("Il n'y a aucune fiche avec l'id " + idFicheFrais);
	        e.printStackTrace(); // affiche l'erreur précise dans la console
	    }
		return null;
	}
	
	
	/**
	 * Méthode de recherche des informations de toutes les fiche de frais
	 * 
	 * @return {@code ArrayList<String>} Une Liste de fiches de frais
	 */
	public static ArrayList<FicheFrais> selectAllFiche() {

        ArrayList<FicheFrais> listFiche = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnexionDB.getConnection();
            String sql = "SELECT fichefrais.idFiche, fichefrais.idUtilisateur, fichefrais.annee, fichefrais.mois, fichefrais.nbJustificatifs, fichefrais.montantValide, fichefrais.dateModif, fichefrais.idEtat "
                    + "FROM fichefrais "
                    + "JOIN utilisateur ON fichefrais.idUtilisateur = utilisateur.idUtilisateur";

            ResultSet result = conn.createStatement().executeQuery(sql);
            while(result.next()) {
                FicheFrais ligne = new FicheFrais(result.getInt("idFiche"),result.getString("idUtilisateur"),result.getInt("annee"),result.getInt("mois"),result.getInt("nbJustificatifs"),result.getFloat("montantValide"),result.getDate("dateModif"),result.getString("idEtat"));
                listFiche.add(ligne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFiche;
    }
}
