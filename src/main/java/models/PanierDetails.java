package models;

public class PanierDetails {
	private Jeu jeu;
	private int qte;
	
	public PanierDetails() {
	}
	public PanierDetails(Jeu jeu, int qte) {
		super();
		this.jeu = jeu;
		this.qte = qte;
	}
	
	public Jeu getJeu() {
		return jeu;
	}
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	@Override
	public String toString() {
		return "Panier [jeu=" + jeu + ", qte=" + qte + "]";
	}
}
