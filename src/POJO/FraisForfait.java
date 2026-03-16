package POJO;

public class FraisForfait {
	int idFraisForfait;
	String libelle;
	float  montant;
	
	public FraisForfait(int idFraisForfait, String libelle, float montant) {
		super();
		this.idFraisForfait = idFraisForfait;
		this.libelle = libelle;
		this.montant = montant;
	}

	public int getIdFraisForfait() {
		return idFraisForfait;
	}

	public void setIdFraisForfait(int idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "FraisForfait [idFraisForfait=" + idFraisForfait + ", libelle=" + libelle + ", montant=" + montant + "]";
	}
	
}
