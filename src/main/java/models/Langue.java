package models;

public class Langue {
	private int id;
	private String nom;
	
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
	
	public Langue(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Langue(String nom) {
		super();
		this.nom = nom;
	}
	public Langue() {
		
	}
	
	@Override
	public String toString() {
		return "Langue [id=" + id + ", nom=" + nom + "]";
	}
}
