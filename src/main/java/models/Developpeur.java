package models;

public class Developpeur {
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
	
	public Developpeur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Developpeur(String nom) {
		super();
		this.nom = nom;
	}
	public Developpeur() {
		
	}
	
	@Override
	public String toString() {
		return "Developpeur [id=" + id + ", nom=" + nom + "]";
	}
}
