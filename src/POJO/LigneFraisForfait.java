package POJO;

public class LigneFraisForfait {
	int idFiche;
	String idFraisForfait;
	int quantite;
	
	public LigneFraisForfait(int idFiche, String idFraisForfait, int quantite) {
		super();
		this.idFiche = idFiche;
		this.idFraisForfait = idFraisForfait;
		this.quantite = quantite;
	}

	public int getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public String getIdFraisForfait() {
		return idFraisForfait;
	}

	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "LigneFraisForfait [idFiche=" + idFiche + ", idFraisForfait=" + idFraisForfait + ", quantite=" + quantite
				+ "]";
	}
	
}