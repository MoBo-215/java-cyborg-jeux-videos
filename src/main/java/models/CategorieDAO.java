package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategorieDAO {
	public void save(Categorie obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE categorie set nom=?,image_url=? WHERE id=?");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2, obj.getImage_url());
				preparedStatement.setInt(3,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO categorie (nom,image_url) VALUES(?,?)");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2, obj.getImage_url());
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
	}
	
	public int getCountJeuxById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT COUNT(*) as nbr FROM jeu WHERE categorie_id=?");
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
	
	
	public Categorie getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM categorie WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Categorie u = new Categorie();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setImage_url(resultat.getString( "image_url" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public Categorie getMostBuyCatByUserId(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM categorie c JOIN jeu j ON c.id = j.categorie_id JOIN detail d ON j.id = d.jeu_id JOIN commande co ON d.commande_id = co.id JOIN utilisateur u ON u.id = co.utilisateur_id AND u.id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Categorie u = new Categorie();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setImage_url(resultat.getString( "image_url" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public ArrayList<Categorie> getAll() {
		ArrayList<Categorie> list = new ArrayList<Categorie>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM categorie");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Categorie o = new Categorie();
					o.setId(resultat.getInt( "id" ));
					o.setNom(resultat.getString( "nom" ));
					o.setImage_url(resultat.getString( "image_url" ));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public void deleteById(int id) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM jeu WHERE categorie_id=?");
				preparedStatement.setInt(1,id);
				preparedStatement.executeUpdate();
				
				PreparedStatement preparedStatement3  = Database.connexion.prepareStatement("DELETE FROM categorie WHERE id=?");
				preparedStatement3.setInt(1,id);
				preparedStatement3.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}

}
