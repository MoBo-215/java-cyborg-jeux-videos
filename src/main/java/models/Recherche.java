package models;

import java.sql.Date;

public class Recherche {
	private int id;
	private String mot;
	private int nb;
	private String dater;
	private int utilisateur_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public int getUtilisateur_id() {
		return utilisateur_id;
	}
	public void setUtilisateur_id(int id) {
		this.utilisateur_id = id;
	}
	
	public Recherche() {
		
	}
	public Recherche(int id, String mot, int nb, String dater, int utilisateur_id) {
		setId(id);
		setMot(mot);
		setNb(nb);
		setUtilisateur_id(utilisateur_id);
	}
	public Recherche(String mot, int nb, int utilisateur_id) {
		setMot(mot);
		setNb(nb);
		setUtilisateur_id(utilisateur_id);
	}
}
