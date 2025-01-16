package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CommandeDAO {
	public int save(Commande obj) {
		int newid=0;
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commande set utilisateur_id=?,total=?,datec=?,etat=? WHERE id=?");
				preparedStatement.setInt(1,obj.getUtilisateur_id());
				preparedStatement.setDouble(2,obj.getTotal());
				preparedStatement.setDate(3,obj.getDatec());
				preparedStatement.setString(4, obj.getEtat());
				preparedStatement.setInt(5,obj.getId());
	            preparedStatement.executeUpdate();
	            newid=obj.getUtilisateur_id();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO commande (utilisateur_id,total,datec,etat) VALUES(?,?,?,'En attente')", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1,obj.getUtilisateur_id());
				preparedStatement.setDouble(2,obj.getTotal());
				preparedStatement.setDate(3,obj.getDatec());
	            preparedStatement.executeUpdate();
	            
	            ResultSet resultat = preparedStatement.getGeneratedKeys();
	            resultat.next();
	            newid= resultat.getInt(1) ;
	            
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
		return newid;
		
	}
		
	public void updateToCmdValidee(Commande obj) {
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commande SET etat='Validée' WHERE id=?");
				preparedStatement.setInt(1, obj.getId());
	            preparedStatement.executeUpdate();
			}
			System.out.println("UPDATE VALID OK");
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("UPDATE VALID NO");
	    }
	}
	
	public void updateToCmdExpediee(Commande obj) {
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commande SET etat='Expédiée' WHERE id=?");
				preparedStatement.setInt(1, obj.getId());
	            preparedStatement.executeUpdate();
			}
			System.out.println("UPDATE EXP OK");
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("UPDATE EXP NO");
	    }
	}
	
	
	public Commande getById(int id) {
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Commande u = new Commande();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getString( "etat" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public ArrayList<Commande> getAll() {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commande u = new Commande();
					u.setId(resultat.getInt( "id" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getString( "etat" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Commande> getAllCmdsAttente() {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande WHERE etat='En attente'");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commande u = new Commande();
					u.setId(resultat.getInt( "id" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getString( "etat" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Commande> getAllCmdsValidees() {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande WHERE etat='Validée'");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commande u = new Commande();
					u.setId(resultat.getInt( "id" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getString( "etat" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Commande> getAllCmdsExpediees() {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande WHERE etat='Expediée'");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commande u = new Commande();
					u.setId(resultat.getInt( "id" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getString( "etat" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Commande> getAllByUtilisateur(int utilisateurid) {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande WHERE utilisateur_id=?");
				preparedStatement.setInt(1,utilisateurid);
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commande u = new Commande();
					u.setId(resultat.getInt( "id" ));
					u.setUtilisateur_id(resultat.getInt( "utilisateur_id" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getString( "etat" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public int getCountCmdsByUtilisateur(int utilisateurid) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT COUNT(*) as nbr FROM commande WHERE utilisateur_id=?");
				preparedStatement.setInt(1,utilisateurid);
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();
	
				int nbr = resultat.getInt( "nbr" );
				return nbr;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return 0;
	    }
	}

	
	public void deleteById(int id) {
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM detail WHERE commande_id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
				
			PreparedStatement preparedStatement2  = Database.connexion.prepareStatement("DELETE FROM commande WHERE id=?");
			preparedStatement2.setInt(1,id);
			preparedStatement2.executeUpdate();
			
			System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}	
}
