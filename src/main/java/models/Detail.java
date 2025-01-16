package models;

public class Detail {
	private int id;
	private int commande_id;
	private int jeu_id;
	private int nb;
	private double prixu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommande_id() {
		return commande_id;
	}
	public void setCommande_id(int commande_id) {
		this.commande_id = commande_id;
	}
	public int getJeu_id() {
		return jeu_id;
	}
	public void setJeu_id(int jeu_id) {
		this.jeu_id = jeu_id;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	public double getPrixu() {
		return prixu;
	}
	public void setPrixu(double prixu) {
		this.prixu = prixu;
	}
	
	public Detail(int id, int commande_id, int jeu_id, int nb, double prixu) {
		this.id = id;
		this.commande_id = commande_id;
		this.jeu_id = jeu_id;
		this.nb = nb;
		this.prixu = prixu;
	}
	public Detail(int commande_id, int jeu_id, int nb, double prixu) {
		this.commande_id = commande_id;
		this.jeu_id = jeu_id;
		this.nb = nb;
		this.prixu = prixu;
	}
	public Detail() {

	}
}
