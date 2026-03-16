package POJO;

import java.sql.Date;

public class LigneFraisHorsForfait {
	int idLigneFHF;
	int idFiche;
	String libelle;
	Date dateFrais;
	float montant;
	
	public LigneFraisHorsForfait(int idLigneFHF, int idFiche, String libelle, Date dateFrais, float montant) {
		super();
		this.idLigneFHF = idLigneFHF;
		this.idFiche = idFiche;
		this.libelle = libelle;
		this.dateFrais = dateFrais;
		this.montant = montant;
	}

	public int getIdLigneFHF() {
		return idLigneFHF;
	}

	public void setIdLigneFHF(int idLigneFHF) {
		this.idLigneFHF = idLigneFHF;
	}

	public int getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateFrais() {
		return dateFrais;
	}

	public void setDateFrais(Date dateFrais) {
		this.dateFrais = dateFrais;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "LigneFraisHorsForfait [idLigneFHF=" + idLigneFHF + ", idFiche=" + idFiche + ", libelle=" + libelle
				+ ", dateFrais=" + dateFrais + ", montant=" + montant + "]";
	}
	
}
