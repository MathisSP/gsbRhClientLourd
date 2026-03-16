package POJO;

public class EtatFrais {
	String idEtat;
	String libelleEtat;
	
	public EtatFrais(String idEtat, String libelleEtat) {
		super();
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
	}

	public String getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}

	public String getLibelleEtat() {
		return libelleEtat;
	}

	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}

	@Override
	public String toString() {
		return "EtatFrais [idEtat=" + idEtat + ", libelleEtat=" + libelleEtat + "]";
	}
	
}
