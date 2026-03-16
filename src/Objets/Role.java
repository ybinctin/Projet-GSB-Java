package Objets;

public class Role {
	
	private String idrole;
	private String libellerole;
	
	public Role(String idrole, String libellerole) {
		this.idrole = idrole;
		this.libellerole = libellerole;
	}

	public String getIdrole() {
		return idrole;
	}

	public void setIdrole(String idrole) {
		this.idrole = idrole;
	}

	public String getLibellerole() {
		return libellerole;
	}

	public void setLibellerole(String libellerole) {
		this.libellerole = libellerole;
	}

	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", libellerole=" + libellerole + "]";
	}
}
