package POJO;

public class Role {
	String idRole;
	String libelleRole;
	
	public Role(String idRole, String libelleRole) {
		super();
		this.idRole = idRole;
		this.libelleRole = libelleRole;
	}

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getLibelleRole() {
		return libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

	@Override
	public String toString() {
		return "\nRole : \nidRole : " + idRole + "\nlibelleRole : " + libelleRole;
	}
	
}