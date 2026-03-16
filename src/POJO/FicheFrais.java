package POJO;

import java.sql.Date;

public class FicheFrais {
	int idFiche;
	String idUtilisateur;
	int annee;
	int mois;
	int nbJustificatifs;
	float montantValide;
	Date dateModif;
	String idEtat;
	
	public FicheFrais(int idFiche, String idUtilisateur, int annee, int mois, int nbJustificatifs, float montantValide,
			Date dateModif, String idEtat) {
		super();
		this.idFiche = idFiche;
		this.idUtilisateur = idUtilisateur;
		this.annee = annee;
		this.mois = mois;
		this.nbJustificatifs = nbJustificatifs;
		this.montantValide = montantValide;
		this.dateModif = dateModif;
		this.idEtat = idEtat;
	}

	public int getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getNbJustificatifs() {
		return nbJustificatifs;
	}

	public void setNbJustificatifs(int nbJustificatifs) {
		this.nbJustificatifs = nbJustificatifs;
	}

	public float getMontantValide() {
		return montantValide;
	}

	public void setMontantValide(float montantValide) {
		this.montantValide = montantValide;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public String getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}

	@Override
	public String toString() {
		return "FicheFrais [idFiche=" + idFiche + ", idUtilisateur=" + idUtilisateur + ", annee=" + annee + ", mois="
				+ mois + ", nbJustificatifs=" + nbJustificatifs + ", montantValide=" + montantValide + ", dateModif="
				+ dateModif + ", idEtat=" + idEtat + "]";
	}
	
}