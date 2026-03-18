package POJO;

public class Region {
	int idRegion;
	String libelleRegion;
	
	public Region(int idRegion, String libelleRegion) {
		super();
		this.idRegion = idRegion;
		this.libelleRegion = libelleRegion;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getLibelleRegion() {
		return libelleRegion;
	}

	public void setLibelleRegion(String libelleRegion) {
		this.libelleRegion = libelleRegion;
	}

	@Override
	public String toString() {
		return "\nRole : \nidRegion : " + idRegion + "\nlibelleRegion : " + libelleRegion;
	}
}