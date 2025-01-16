package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommentaireDAO {
public void save(Commentaire obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commentaire set note=?,texte=?,utilisateur_id=?,jeu_id=?,approuve=? WHERE id=?");
				preparedStatement.setInt(1,obj.getNote());
				preparedStatement.setString(2, obj.getTexte());
				preparedStatement.setInt(3, obj.getUtilisateur_id());
				preparedStatement.setInt(4, obj.getJeu_id());
				preparedStatement.setBoolean(5, obj.isApprouve());
				preparedStatement.setInt(6,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO commentaire (note,texte,utilisateur_id,jeu_id,approuve) VALUES(?,?,?,?,1)");
				preparedStatement.setInt(1,obj.getNote());
				preparedStatement.setString(2, obj.getTexte());
				preparedStatement.setInt(3, obj.getUtilisateur_id());
				preparedStatement.setInt(4, obj.getJeu_id());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
	}
	
	public int getCountCommentairesByJeu(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT COUNT(*) as nbr FROM commentaire WHERE jeu_id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();
	
				int nbr = resultat.getInt( "nbr" );
				return nbr;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return 0;
	    }
	}
	
	
	public Commentaire getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaire WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Commentaire u = new Commentaire();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNote(resultat.getInt( "note" ));
					u.setTexte(resultat.getString( "texte" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					u.setJeu_id(resultat.getInt( "jeu_id" ));
					u.setApprouve(resultat.getBoolean("approuve"));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public ArrayList<Commentaire> getAll() {
		ArrayList<Commentaire> list = new ArrayList<Commentaire>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaire");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commentaire o = new Commentaire();
					o.setId(resultat.getInt( "id" ));
					o.setNote(resultat.getInt( "note" ));
					o.setTexte(resultat.getString( "texte" ));
					o.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					o.setJeu_id(resultat.getInt( "jeu_id" ));
					o.setApprouve(resultat.getBoolean("approuve"));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Commentaire> getAllByJeu(int id) {
		ArrayList<Commentaire> list = new ArrayList<Commentaire>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaire WHERE jeu_id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commentaire o = new Commentaire();
					o.setId(resultat.getInt( "id" ));
					o.setNote(resultat.getInt( "note" ));
					o.setTexte(resultat.getString( "texte" ));
					o.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					o.setJeu_id(resultat.getInt( "jeu_id" ));
					o.setApprouve(resultat.getBoolean("approuve"));
					list.add(o);
				}
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public double getMoyenneNotesByJeuId(int id) {
		try {
				
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT ROUND(AVG(note), 2) AS moy FROM commentaire WHERE jeu_id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();
				
				double moy = resultat.getDouble( "moy" );
				return moy;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return 0;
	    }
	}
	
	public void banById(Commentaire obj) {
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commentaire SET approuve=0 WHERE id=?");
				preparedStatement.setInt(1,obj.getId());
	            preparedStatement.executeUpdate();
			}
			System.out.println("BAN OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("BAN NO");
	    }
	}
	
	public void debanById(Commentaire obj) {
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commentaire SET approuve=1 WHERE id=?");
				preparedStatement.setInt(1,obj.getId());
	            preparedStatement.executeUpdate();
			}
			System.out.println("DEBAN OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DEBAN NO");
	    }
	}
	
	public void deleteById(int id) {
		try {
			
				PreparedStatement preparedStatement3  = Database.connexion.prepareStatement("DELETE FROM commentaire WHERE id=?");
				preparedStatement3.setInt(1,id);
				preparedStatement3.executeUpdate();
				
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}
}
