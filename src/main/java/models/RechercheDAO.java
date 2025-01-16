package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RechercheDAO {
	public void save(Recherche obj) {
			
			try {
				
				if(obj.getId() != 0) {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE recherche set mot=?,nb=?,dater=?,utilisateur_id=? WHERE id=?");
					preparedStatement.setString(1,obj.getMot());
					preparedStatement.setInt(2,obj.getNb());
					preparedStatement.setString(3,obj.getDater());
					preparedStatement.setInt(4,obj.getUtilisateur_id());
					preparedStatement.setInt(5,obj.getId());
		            preparedStatement.executeUpdate();
				}else {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO recherche (mot,nb,dater,utilisateur_id) VALUES(?,?,now(),?)");
					preparedStatement.setString(1,obj.getMot());
					preparedStatement.setInt(2,obj.getNb());
					preparedStatement.setInt(3,obj.getUtilisateur_id());
		            preparedStatement.executeUpdate();
				}
				System.out.println("SAVED SEARCH OK");
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	System.out.println("SAVED SEARCH NO");
	        }
		
	}
	
	public Recherche getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM recherche WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Recherche u = new Recherche();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setMot(resultat.getString( "mot" ));
					u.setNb(resultat.getInt( "nb" ));
					u.setDater(resultat.getString( "dater" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public ArrayList<Recherche> getAll() {
		ArrayList<Recherche> list = new ArrayList<Recherche>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM recherche");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Recherche u = new Recherche();
					u.setId(resultat.getInt( "id" ));
					u.setMot(resultat.getString( "mot" ));
					u.setNb(resultat.getInt( "nb" ));
					u.setDater(resultat.getString( "dater" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Recherche> rechercher(String mot) {
		ArrayList<Recherche> list = new ArrayList<Recherche>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM recherche WHERE mot like ?");
				preparedStatement.setString(1,"%"+mot+"%");
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Recherche u = new Recherche();
					u.setId(resultat.getInt( "id" ));
					u.setMot(resultat.getString( "mot" ));
					u.setNb(resultat.getInt( "nb" ));
					u.setDater(resultat.getString( "dater" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					list.add(u);
				}
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public void deleteById(int id) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM recherche WHERE id=?");
				preparedStatement.setInt(1,id);
				
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}
}
