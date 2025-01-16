package models;

public class Commentaire {
	private int id;
	private int note;
	private String texte;
	private int utilisateur_id;
	private int jeu_id;
	private boolean approuve;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public int getUtilisateur_id() {
		return utilisateur_id;
	}
	public void setUtilisateur_id(int utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}
	public int getJeu_id() {
		return jeu_id;
	}
	public void setJeu_id(int jeu_id) {
		this.jeu_id = jeu_id;
	}
	public boolean isApprouve() {
		return approuve;
	}
	public void setApprouve(boolean approuve) {
		this.approuve = approuve;
	}
	
	public Commentaire(int id, int note, String texte, int utilisateur_id, int jeu_id, boolean approuve) {
		super();
		this.id = id;
		this.note = note;
		this.texte = texte;
		this.utilisateur_id = utilisateur_id;
		this.jeu_id = jeu_id;
		this.approuve = approuve;
	}
	public Commentaire(int note, String texte, int utilisateur_id, int jeu_id, boolean approuve) {
		super();
		this.note = note;
		this.texte = texte;
		this.utilisateur_id = utilisateur_id;
		this.jeu_id = jeu_id;
		this.approuve = approuve;
	}
	public Commentaire() {
		
	}
	
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", note=" + note + ", texte=" + texte + ", utilisateur_id=" + utilisateur_id
				+ ", jeu_id=" + jeu_id + ", approuve=" + approuve + "]";
	}
	
}
