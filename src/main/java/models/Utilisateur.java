package models;

public class Utilisateur {
	private int id;
	private String nom;
	private String email;
	private String mot_de_passe;
	private Boolean isban;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public Boolean getIsban() {
		return isban;
	}
	public void setIsban(Boolean isban) {
		this.isban = isban;
	}
	
	public Utilisateur(int id, String nom, String email, String mot_de_passe, Boolean isban, Boolean isadmin) {
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.isban = isban;
	}
	
	public Utilisateur(String nom, String email, String mot_de_passe, Boolean isban, Boolean isadmin) {
		this.nom = nom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.isban = isban;
	}
	
	public Utilisateur() {

	}
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email + ", mot_de_passe=" + mot_de_passe + ", isban="
				+ isban + "]";
	}
}
