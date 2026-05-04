package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDD.ConnexionDB;
import POJO.FicheFrais;
import POJO.LigneFraisForfait;
import POJO.LigneFraisHorsForfait;
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
	    Connection con = ConnexionDB.getConnection();
	    // Correction : suppression des apostrophes autour du ? 
	    String sql = "SELECT * FROM fichefrais WHERE idFiche = ?";
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, idFicheFrais);
	        ResultSet result = stmt.executeQuery();

	        if (result.next()) {
	            return new FicheFrais(
	                result.getInt("idFiche"),
	                result.getString("idUtilisateur"), // Correction : "idUtilisaateur" -> "idUtilisateur"
	                result.getInt("annee"),
	                result.getInt("mois"),
	                result.getInt("nbJustificatifs"),
	                result.getFloat("montantValide"),
	                result.getDate("dateModif"),
	                result.getString("idEtat")
	            );
	        }
	        result.close();
	        stmt.close();
	    } catch (SQLException e) {
	        System.out.println("Il n'y a aucune fiche avec l'id " + idFicheFrais);
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	/**
	 * Méthode de recherche des informations de toutes les fiche de frais
	 * 
	 * @return Une Liste de fiches de frais
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
	
	/**
	 * Récupère toutes les fiches de frais d'un visiteur spécifique.
	 * @param idUtilisateur l'ID du visiteur
	 * @return liste des fiches du visiteur
	 */
	public static ArrayList<FicheFrais> selectFicheByIdUtilisateur(String idUtilisateur) {
	    ArrayList<FicheFrais> fiches = new ArrayList<>();
	    Connection conn = null;
	    try {
	        conn = ConnexionDB.getConnection();
	        String requete = "SELECT * FROM fichefrais WHERE idUtilisateur = ?";
	        PreparedStatement pst = conn.prepareStatement(requete);
	        pst.setString(1, idUtilisateur);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            // Utiliser le constructeur complet de FicheFrais
	            FicheFrais f = new FicheFrais(
	                rs.getInt("idFiche"),
	                rs.getString("idUtilisateur"),
	                rs.getInt("annee"),
	                rs.getInt("mois"),
	                rs.getInt("nbJustificatifs"),
	                rs.getFloat("montantValide"),
	                rs.getDate("dateModif"),
	                rs.getString("idEtat")
	            );
	            fiches.add(f);
	        }
	        rs.close();
	        pst.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return fiches;
	}
	
	/**
	 * Récupère les lignes de frais forfaitaires d'une fiche.
	 * @param idFiche l'identifiant de la fiche
	 * @return les lignes forfaitaires de la fiche
	 */
	public static ArrayList<LigneFraisForfait> selectLignesForfaitByIdFiche(int idFiche) {
	    ArrayList<LigneFraisForfait> lignes = new ArrayList<>();
	    try {
	        Connection conn = ConnexionDB.getConnection();
	        String sql = "SELECT * FROM lignefraisforfait WHERE idFiche = ?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, idFiche);
	        ResultSet result = pst.executeQuery();
	        while (result.next()) {
	            lignes.add(new LigneFraisForfait(
	            	result.getInt("idFiche"),
	            	result.getString("idFraisForfait"),
	            	result.getInt("quantite")
	            ));
	        }
	        result.close();
	        pst.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lignes;
	}
	
	/**
	 * Récupère les lignes de frais hors forfait d'une fiche.
	 * @param idFiche l'identifiant de la fiche
	 * @return les lignes hors forfait de la fiche
	 */
	public static ArrayList<LigneFraisHorsForfait> selectLignesHorsForfaitByIdFiche(int idFiche) {
	    ArrayList<LigneFraisHorsForfait> lignes = new ArrayList<>();
	    try {
	        Connection conn = ConnexionDB.getConnection();
	        String sql = "SELECT * FROM lignefraishorsforfait WHERE idFiche = ?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, idFiche);
	        ResultSet result = pst.executeQuery();
	        while (result.next()) {
	            lignes.add(new LigneFraisHorsForfait(
	            	result.getInt("idLigneFHF"),
	            	result.getInt("idFiche"),
	            	result.getString("libelle"),
	            	result.getDate("dateFrais"),
	            	result.getFloat("montant")
	            ));
	        }
	        result.close();
	        pst.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lignes;
	}
	
	/**
	 * Nombre de fiches hors forfait par visiteur pour un mois donné
	 * @param mois l'identifiant du mois
	 * @return les lignes ayant l utilisateur , le mois et le nombre total de frais hors forfait de la fiche du mois
	 */
	public static ArrayList<Object[]> getNbHorsForfaitParMois(int mois) {
	    ArrayList<Object[]> resultats = new ArrayList<>();
	    try {
	        Connection conn = ConnexionDB.getConnection();
	        String sql = "SELECT u.idUtilisateur, u.nom, u.prenom, f.mois, COUNT(lhf.idLigneFHF) as nbHorsForfait "
	                   + "FROM utilisateur u "
	                   + "JOIN fichefrais f ON u.idUtilisateur = f.idUtilisateur "
	                   + "JOIN lignefraishorsforfait lhf ON f.idFiche = lhf.idFiche "
	                   + "WHERE f.mois = ? "
	                   + "GROUP BY u.idUtilisateur, u.nom, u.prenom, f.mois";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, mois);
	        ResultSet result = pst.executeQuery();
	        while (result.next()) {
	            resultats.add(new Object[]{
	            	result.getString("idUtilisateur"),
	            	result.getString("nom"),
	            	result.getString("prenom"),
	            	result.getInt("mois"),
	            	result.getInt("nbHorsForfait")
	            });
	        }
	        result.close(); pst.close();
	    } catch (SQLException e) { e.printStackTrace(); }
	    return resultats;
	}

	/**
	 * Montant total des fiches hors forfait par visiteur pour un mois donné
	 * @param mois l'identifiant du mois
	 * @return les lignes ayant l utilisateur , le mois et le montant total hors forfait de la fiche du mois
	 */
	public static ArrayList<Object[]> getMontantHorsForfaitParMois(int mois) {
	    ArrayList<Object[]> resultats = new ArrayList<>();
	    try {
	        Connection conn = ConnexionDB.getConnection();
	        String sql = "SELECT u.idUtilisateur, u.nom, u.prenom, f.mois, SUM(lhf.montant) as montantTotal "
	                   + "FROM utilisateur u "
	                   + "JOIN fichefrais f ON u.idUtilisateur = f.idUtilisateur "
	                   + "JOIN lignefraishorsforfait lhf ON f.idFiche = lhf.idFiche "
	                   + "WHERE f.mois = ? "
	                   + "GROUP BY u.idUtilisateur, u.nom, u.prenom, f.mois";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, mois);
	        ResultSet result = pst.executeQuery();
	        while (result.next()) {
	            resultats.add(new Object[]{
	            	result.getString("idUtilisateur"),
	            	result.getString("nom"),
	            	result.getString("prenom"),
	                result.getInt("mois"),
	                String.format("%.2f €", result.getFloat("montantTotal"))
	            });
	        }
	        result.close(); pst.close();
	    } catch (SQLException e) { e.printStackTrace(); }
	    return resultats;
	}

	/**
	 * Montant total des frais forfait par visiteur pour un mois donné
	 * @param mois l'identifiant du mois
	 * @return les lignes ayant l utilisateur , le mois et le montant total de la fiche du mois	 
	 */
	public static ArrayList<Object[]> getMontantForfaitParMois(int mois) {
	    ArrayList<Object[]> resultats = new ArrayList<>();
	    try {
	        Connection conn = ConnexionDB.getConnection();
	        String sql = "SELECT u.idUtilisateur, u.nom, u.prenom, f.mois, f.montantValide as montantTotal "
	                   + "FROM utilisateur u "
	                   + "JOIN fichefrais f ON u.idUtilisateur = f.idUtilisateur "
	                   + "WHERE f.mois = ?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, mois);
	        ResultSet result = pst.executeQuery();
	        while (result.next()) {
	            resultats.add(new Object[]{
	            	result.getString("idUtilisateur"),
	            	result.getString("nom"),
	            	result.getString("prenom"),
	            	result.getInt("mois"),
	                String.format("%.2f €", result.getFloat("montantTotal"))
	            });
	        }
	        result.close(); pst.close();
	    } catch (SQLException e) { e.printStackTrace(); }
	    return resultats;
	}
	
	/**
	 * Calcule la moyenne des montants de frais forfait par région pour un mois donné.
	 * Inclut le nombre de visiteurs concernés par région.
	 * @param mois le numéro du mois
	 * @return une liste de tableaux contenant : idRegion , libelleRegion , mois, nbVisiteurs , moyenne
	 */
	public static ArrayList<Object[]> getMoyenneForfaitParRegion(int mois) {
	    ArrayList<Object[]> resultats = new ArrayList<>();
	    try {
	        Connection conn = ConnexionDB.getConnection();
	        String sql = "SELECT r.idRegion, r.libelleRegion, f.mois, "
	                   + "COUNT(DISTINCT u.idUtilisateur) as nbVisiteurs, "
	                   + "AVG(f.montantValide) as moyenne "
	                   + "FROM region r "
	                   + "JOIN utilisateur u ON u.idRegion = r.idRegion "
	                   + "JOIN fichefrais f ON f.idUtilisateur = u.idUtilisateur "
	                   + "WHERE f.mois = ? "
	                   + "GROUP BY r.idRegion, r.libelleRegion, f.mois";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, mois);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            resultats.add(new Object[]{
	                rs.getInt("idRegion"),
	                rs.getString("libelleRegion"),
	                rs.getInt("mois"),
	                rs.getInt("nbVisiteurs"),
	                String.format("%.2f €", rs.getFloat("moyenne"))
	            });
	        }
	        rs.close(); pst.close();
	    } catch (SQLException e) { e.printStackTrace(); }
	    return resultats;
	}

	/**
	 * Calcule la moyenne des montants de frais hors forfait par région pour un mois donné.
	 * Inclut le nombre de visiteurs concernés par région.
	 * @param mois le numéro du mois
	 * @return une liste de tableaux contenant : idRegion, libelleRegion , mois , nbVisiteurs , moyenne
	 */
	public static ArrayList<Object[]> getMoyenneHorsForfaitParRegion(int mois) {
	    ArrayList<Object[]> resultats = new ArrayList<>();
	    try {
	        Connection conn = ConnexionDB.getConnection();
	        String sql = "SELECT r.idRegion, r.libelleRegion, f.mois, "
	                   + "COUNT(DISTINCT u.idUtilisateur) as nbVisiteurs, "
	                   + "AVG(lhf.montant) as moyenne "
	                   + "FROM region r "
	                   + "JOIN utilisateur u ON u.idRegion = r.idRegion "
	                   + "JOIN fichefrais f ON f.idUtilisateur = u.idUtilisateur "
	                   + "JOIN lignefraishorsforfait lhf ON lhf.idFiche = f.idFiche "
	                   + "WHERE f.mois = ? "
	                   + "GROUP BY r.idRegion, r.libelleRegion, f.mois";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setInt(1, mois);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            resultats.add(new Object[]{
	                rs.getInt("idRegion"),
	                rs.getString("libelleRegion"),
	                rs.getInt("mois"),
	                rs.getInt("nbVisiteurs"),
	                String.format("%.2f €", rs.getFloat("moyenne"))
	            });
	        }
	        rs.close(); pst.close();
	    } catch (SQLException e) { e.printStackTrace(); }
	    return resultats;
	}
}
