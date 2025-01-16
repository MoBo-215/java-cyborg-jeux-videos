package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetailDAO {
	public void save(Detail obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE detail set commande_id=?,jeu_id=?,nb=?,prixu=? WHERE id=?");
				preparedStatement.setInt(1,obj.getCommande_id());
				preparedStatement.setInt(2,obj.getJeu_id());
				preparedStatement.setInt(3,obj.getNb());
				preparedStatement.setDouble(4,obj.getPrixu());
				preparedStatement.setInt(5,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO detail (commande_id,jeu_id,nb,prixu) VALUES(?,?,?,?)");
				preparedStatement.setInt(1,obj.getCommande_id());
				preparedStatement.setInt(2,obj.getJeu_id());
				preparedStatement.setInt(3,obj.getNb());
				preparedStatement.setDouble(4,obj.getPrixu());
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
		
	}
	
	public Detail getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM detail WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Detail u = new Detail();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setCommande_id(resultat.getInt( "commande_id" ));
					u.setJeu_id(resultat.getInt( "jeu_id" ));
					u.setNb(resultat.getInt( "nb" ));
					u.setPrixu(resultat.getDouble( "prixu" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public int getCountVentesByJeu(int jeuid) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT SUM(nb) as nbr FROM detail WHERE jeu_id=?");
				preparedStatement.setInt(1,jeuid);
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();
	
				int nbr = resultat.getInt( "nbr" );
				return nbr;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return 0;
	    }
	}
	
	
	
	public ArrayList<Detail> getAllByCommande(int commandeid) {
		ArrayList<Detail> list = new ArrayList<Detail>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM detail WHERE commande_id=?");
				preparedStatement.setInt(1,commandeid);
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Detail u = new Detail();
					u.setId(resultat.getInt( "id" ));
					u.setCommande_id(resultat.getInt( "commande_id" ));
					u.setJeu_id(resultat.getInt( "jeu_id" ));
					u.setNb(resultat.getInt( "nb" ));
					u.setPrixu(resultat.getDouble( "prixu" ));
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
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM detail WHERE id=?");
				preparedStatement.setInt(1,id);
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}	
}
