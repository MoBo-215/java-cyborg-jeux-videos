package models;

import java.sql.Date;

public class Jeu {
	private int id;
	private String titre;
	private String description;
	private Date date_sortie;
	private double prix;
	private String video_un_url;
	private String video_deux_url;
	private String image_un_url;
	private String image_deux_url;
	private String image_trois_url;
	private String image_quatre_url;
	private String image_cinq_url;
	private int age_minimum;
	private int langue_id;
	private int developpeur_id;
	private int categorie_id;
	private int plateforme_id;
	private int stock;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getVideo_un_url() {
		return video_un_url;
	}
	public void setVideo_un_url(String video_un_url) {
		this.video_un_url = video_un_url;
	}
	public String getVideo_deux_url() {
		return video_deux_url;
	}
	public void setVideo_deux_url(String video_deux_url) {
		this.video_deux_url = video_deux_url;
	}
	public String getImage_un_url() {
		return image_un_url;
	}
	public void setImage_un_url(String image_un_url) {
		this.image_un_url = image_un_url;
	}
	public String getImage_deux_url() {
		return image_deux_url;
	}
	public void setImage_deux_url(String image_deux_url) {
		this.image_deux_url = image_deux_url;
	}
	public String getImage_trois_url() {
		return image_trois_url;
	}
	public String getImage_quatre_url() {
		return image_quatre_url;
	}
	public void setImage_quatre_url(String image_quatre_url) {
		this.image_quatre_url = image_quatre_url;
	}
	public String getImage_cinq_url() {
		return image_cinq_url;
	}
	public void setImage_cinq_url(String image_cinq_url) {
		this.image_cinq_url = image_cinq_url;
	}
	public void setImage_trois_url(String image_trois_url) {
		this.image_trois_url = image_trois_url;
	}
	public int getAge_minimum() {
		return age_minimum;
	}
	public void setAge_minimum(int age_minimum) {
		this.age_minimum = age_minimum;
	}
	public int getLangue_id() {
		return langue_id;
	}
	public void setLangue_id(int langue_id) {
		this.langue_id = langue_id;
	}
	public int getDeveloppeur_id() {
		return developpeur_id;
	}
	public void setDeveloppeur_id(int developpeur_id) {
		this.developpeur_id = developpeur_id;
	}
	public int getCategorie_id() {
		return categorie_id;
	}
	public void setCategorie_id(int categorie_id) {
		this.categorie_id = categorie_id;
	}
	public int getPlateforme_id() {
		return plateforme_id;
	}
	public void setPlateforme_id(int plateforme_id) {
		this.plateforme_id = plateforme_id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Jeu(int id, String titre, String description, Date date_sortie, double prix, String video_un_url,
			String video_deux_url, String image_un_url, String image_deux_url, String image_trois_url,
			String image_quatre_url, String image_cinq_url, int age_minimum, int langue_id, int developpeur_id,
			int categorie_id, int plateforme_id, int stock) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.date_sortie = date_sortie;
		this.prix = prix;
		this.video_un_url = video_un_url;
		this.video_deux_url = video_deux_url;
		this.image_un_url = image_un_url;
		this.image_deux_url = image_deux_url;
		this.image_trois_url = image_trois_url;
		this.image_quatre_url = image_quatre_url;
		this.image_cinq_url = image_cinq_url;
		this.age_minimum = age_minimum;
		this.langue_id = langue_id;
		this.developpeur_id = developpeur_id;
		this.categorie_id = categorie_id;
		this.plateforme_id = plateforme_id;
		this.stock = stock;
	}
	public Jeu(String titre, String description, Date date_sortie, double prix, String video_un_url,
			String video_deux_url, String image_un_url, String image_deux_url, String image_trois_url,
			String image_quatre_url, String image_cinq_url, int age_minimum, int langue_id, int developpeur_id,
			int categorie_id, int plateforme_id, int stock) {
		super();
		this.titre = titre;
		this.description = description;
		this.date_sortie = date_sortie;
		this.prix = prix;
		this.video_un_url = video_un_url;
		this.video_deux_url = video_deux_url;
		this.image_un_url = image_un_url;
		this.image_deux_url = image_deux_url;
		this.image_trois_url = image_trois_url;
		this.image_quatre_url = image_quatre_url;
		this.image_cinq_url = image_cinq_url;
		this.age_minimum = age_minimum;
		this.langue_id = langue_id;
		this.developpeur_id = developpeur_id;
		this.categorie_id = categorie_id;
		this.plateforme_id = plateforme_id;
		this.stock = stock;
	}
	public Jeu() {
		
	}
	
	@Override
	public String toString() {
		return "Jeu [id=" + id + ", titre=" + titre + ", description=" + description + ", date_sortie=" + date_sortie
				+ ", prix=" + prix + ", video_un_url=" + video_un_url + ", video_deux_url=" + video_deux_url
				+ ", image_un_url=" + image_un_url + ", image_deux_url=" + image_deux_url + ", image_trois_url="
				+ image_trois_url + ", image_quatre_url=" + image_quatre_url + ", image_cinq_url=" + image_cinq_url
				+ ", age_minimum=" + age_minimum + ", langue_id=" + langue_id + ", developpeur_id=" + developpeur_id
				+ ", categorie_id=" + categorie_id + ", plateforme_id=" + plateforme_id + ", stock=" + stock + "]";
	}
	
	
}
