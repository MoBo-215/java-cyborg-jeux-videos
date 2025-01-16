package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlateformeDAO {
	public void save(Plateforme obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE plateforme set nom=? WHERE id=?");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setInt(2,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO plateforme (nom) VALUES(?)");
				preparedStatement.setString(1,obj.getNom());
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
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT COUNT(*) as nbr FROM jeu WHERE plateforme_id=?");
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
	
	
	public Plateforme getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM plateforme WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Plateforme u = new Plateforme();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public ArrayList<Plateforme> getAll() {
		ArrayList<Plateforme> list = new ArrayList<Plateforme>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM plateforme");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Plateforme o = new Plateforme();
					o.setId(resultat.getInt( "id" ));
					o.setNom(resultat.getString( "nom" ));
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
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM jeu WHERE plateforme_id=?");
				preparedStatement.setInt(1,id);
				preparedStatement.executeUpdate();
			
				PreparedStatement preparedStatement3  = Database.connexion.prepareStatement("DELETE FROM plateforme WHERE id=?");
				preparedStatement3.setInt(1,id);
				preparedStatement3.executeUpdate();
				
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}
}
