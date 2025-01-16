package models;

public class Infos {
	private int id;
	private String petite_phrase;
	private String grande_phrase_pink;
	private String grande_phrase_white;
	private String texte_bouton;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPetite_phrase() {
		return petite_phrase;
	}
	public void setPetite_phrase(String petite_phrase) {
		this.petite_phrase = petite_phrase;
	}
	public String getGrande_phrase_pink() {
		return grande_phrase_pink;
	}
	public void setGrande_phrase_pink(String grande_phrase_pink) {
		this.grande_phrase_pink = grande_phrase_pink;
	}
	public String getGrande_phrase_white() {
		return grande_phrase_white;
	}
	public void setGrande_phrase_white(String grande_phrase_white) {
		this.grande_phrase_white = grande_phrase_white;
	}
	public String getTexte_bouton() {
		return texte_bouton;
	}
	public void setTexte_bouton(String texte_bouton) {
		this.texte_bouton = texte_bouton;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Infos(int id, String petite_phrase, String grande_phrase_pink, String grande_phrase_white, String texte_bouton, String email) {
		super();
		this.id = id;
		this.petite_phrase = petite_phrase;
		this.grande_phrase_pink = grande_phrase_pink;
		this.grande_phrase_white = grande_phrase_white;
		this.texte_bouton = texte_bouton;
		this.email = email;
	}
	public Infos(String petite_phrase, String grande_phrase_pink, String grande_phrase_white, String texte_bouton, String email) {
		super();
		this.petite_phrase = petite_phrase;
		this.grande_phrase_pink = grande_phrase_pink;
		this.grande_phrase_white = grande_phrase_white;
		this.texte_bouton = texte_bouton;
		this.email = email;
	}
	public Infos() {
		
	}
	
	@Override
	public String toString() {
		return "Infos [id=" + id + ", petite_phrase=" + petite_phrase + ", grande_phrase_pink=" + grande_phrase_pink
				+ ", grande_phrase_white=" + grande_phrase_white + ", texte_bouton=" + texte_bouton + ", email=" + email
				+ "]";
	}
	
}
