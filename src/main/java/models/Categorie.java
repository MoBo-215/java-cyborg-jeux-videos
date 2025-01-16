package models;

public class Categorie {
	private int id;
	private String nom;
	private String image_url;
	
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
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	public Categorie(int id, String nom, String image_url) {
		super();
		this.id = id;
		this.nom = nom;
		this.image_url = image_url;
	}
	public Categorie(String nom, String image_url) {
		super();
		this.nom = nom;
		this.image_url = image_url;
	}
	public Categorie() {
		
	}
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", image_url=" + image_url +"]";
	}
}
