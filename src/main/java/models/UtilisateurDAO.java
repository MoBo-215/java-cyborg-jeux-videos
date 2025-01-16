package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UtilisateurDAO {

	public void save(Utilisateur obj) {
		try {
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE utilisateur SET nom=?,email=?,mot_de_passe=?,isban=? WHERE id=?");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getEmail());
				preparedStatement.setString(3,obj.getMot_de_passe());
				preparedStatement.setBoolean(4, obj.getIsban());
				preparedStatement.setInt(5,obj.getId());
	            preparedStatement.executeUpdate();
				System.out.println("UPDATE ADMIN OK");
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO utilisateur (nom,email,mot_de_passe,isban) VALUES(?,?,?,0)");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getEmail());
				preparedStatement.setString(3,obj.getMot_de_passe());
	            preparedStatement.executeUpdate();
	            System.out.println("SAVED ADMIN OK");
			}
				
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("SAVED ADMIN NO");
	    }
	
	}
	
	public Utilisateur getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM utilisateur WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Utilisateur u = new Utilisateur();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
					u.setIsban(resultat.getBoolean( "isban" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public Utilisateur connexion(String email,String mot_de_passe) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM utilisateur WHERE email=? AND mot_de_passe=?");
				preparedStatement.setString(1,email);
				preparedStatement.setString(2,mot_de_passe);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Utilisateur u = new Utilisateur();
				if(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
					u.setIsban(resultat.getBoolean( "isban" ));
					return u;
				}else {
					return null;
				}
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	
	public ArrayList<Utilisateur> getAll() {
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM utilisateur");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Utilisateur u = new Utilisateur();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
					u.setIsban(resultat.getBoolean( "isban" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Utilisateur> getAllUsersNotBan() {
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM utilisateur WHERE isban=0");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Utilisateur u = new Utilisateur();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
					u.setIsban(resultat.getBoolean( "isban" ));
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
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM commentaire WHERE utilisateur_id=?");
				preparedStatement.setInt(1,id);
				preparedStatement.executeUpdate();
			
				PreparedStatement preparedStatement1  = Database.connexion.prepareStatement("DELETE FROM detail WHERE commande_id IN (SELECT id FROM commande WHERE utilisateur_id=?)");
				preparedStatement1.setInt(1,id);
				preparedStatement1.executeUpdate();
				
				PreparedStatement preparedStatement2  = Database.connexion.prepareStatement("DELETE FROM commande WHERE utilisateur_id=?");
				preparedStatement2.setInt(1,id);
				preparedStatement2.executeUpdate();
				
				PreparedStatement preparedStatement3  = Database.connexion.prepareStatement("DELETE FROM utilisateur WHERE id=?");
				preparedStatement3.setInt(1,id);
				preparedStatement3.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}
	
	public void banById(Utilisateur obj) {
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE utilisateur SET isban=1 WHERE id=?");
				preparedStatement.setInt(1,obj.getId());
	            preparedStatement.executeUpdate();
			}
			System.out.println("BAN OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("BAN NO");
	    }
	}
	
	public void debanById(Utilisateur obj) {
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE utilisateur SET isban=0 WHERE id=?");
				preparedStatement.setInt(1,obj.getId());
	            preparedStatement.executeUpdate();
			}
			System.out.println("DEBAN OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DEBAN NO");
	    }
	}
	
	
	public Utilisateur rechercher(String mot) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM utilisateur WHERE nom like ? OR email like ?");
				preparedStatement.setString(1,"%"+mot+"%");
				preparedStatement.setString(2,"%"+mot+"%");
				ResultSet resultat=preparedStatement.executeQuery();
	
				Utilisateur u = new Utilisateur();
				while(resultat.next()) {
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
					u.setIsban(resultat.getBoolean( "isban" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
}
