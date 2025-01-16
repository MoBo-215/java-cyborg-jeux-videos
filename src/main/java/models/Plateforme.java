package models;

public class Plateforme {
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
	
	public Plateforme(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Plateforme(String nom) {
		super();
		this.nom = nom;
	}
	public Plateforme() {
		
	}
	
	@Override
	public String toString() {
		return "Plateforme [id=" + id + ", nom=" + nom + "]";
	}
	
}
