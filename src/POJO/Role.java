package POJO;

public class Role {
	int idRole;
	String libelleRole;
	
	public Role(int idRole, String libelleRole) {
		super();
		this.idRole = idRole;
		this.libelleRole = libelleRole;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
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
		return "Role [idRole=" + idRole + ", libelleRole=" + libelleRole + "]";
	}
	
}
