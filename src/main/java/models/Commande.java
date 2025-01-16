package models;

import java.sql.Date;

public class Commande {
	private int id;
	private int utilisateur_id;
	private double total;
	private Date datec;
	private String etat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(int utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDatec() {
		return datec;
	}

	public void setDatec(Date datec) {
		this.datec = datec;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Commande(int id, int utilisateur_id, double total, Date datec, String etat) {
		this.id = id;
		this.utilisateur_id = utilisateur_id;
		this.total = total;
		this.datec = datec;
		this.etat = etat;
	}
	
	public Commande(int utilisateur_id, double total, Date datec, String etat) {
		this.utilisateur_id = utilisateur_id;
		this.total = total;
		this.datec = datec;
		this.etat = etat;
	} 
	
	public Commande() {
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", utilisateur_id=" + utilisateur_id + ", total=" + total + ", datec=" + datec
				+ ", etat=" + etat + "]";
	} 
}
