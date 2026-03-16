package POJO;

import java.sql.Date;

public class Utilisateur {
	int idUtilisateur;
	String nom;
	String prenom;
	String login;
	String mdp;
	String adresse;
	String cp;
	String ville;
	Date dateEmbauche;
	String idRole;
	Date date_modif_mdp;
	int idRegion;
	
	public Utilisateur(int idUtilisateur, String nom, String prenom, String login, String mdp, String adresse,
			String cp, String ville, Date dateEmbauche, String idRole, Date date_modif_mdp, int idRegion) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.dateEmbauche = dateEmbauche;
		this.idRole = idRole;
		this.date_modif_mdp = date_modif_mdp;
		this.idRegion = idRegion;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public Date getDate_modif_mdp() {
		return date_modif_mdp;
	}

	public void setDate_modif_mdp(Date date_modif_mdp) {
		this.date_modif_mdp = date_modif_mdp;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", login="
				+ login + ", mdp=" + mdp + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville
				+ ", dateEmbauche=" + dateEmbauche + ", idRole=" + idRole + ", date_modif_mdp=" + date_modif_mdp
				+ ", idRegion=" + idRegion + "]";
	}
	
}
