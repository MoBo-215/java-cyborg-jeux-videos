package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdministrateurDAO {
	public void save(Administrateur obj) {
		try {
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE administrateur SET nom=?,email=?,mot_de_passe=? WHERE id=?");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getEmail());
				preparedStatement.setString(3,obj.getMot_de_passe());
				preparedStatement.setInt(4,obj.getId());
	            preparedStatement.executeUpdate();
				System.out.println("UPDATE ADMIN OK");
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO administrateur (nom,email,mot_de_passe) VALUES(?,?,?)");
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
	
	public Administrateur getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM administrateur WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Administrateur u = new Administrateur();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public Administrateur connexion(String email,String mot_de_passe) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM administrateur WHERE email=? AND mot_de_passe=?");
				preparedStatement.setString(1,email);
				preparedStatement.setString(2,mot_de_passe);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Administrateur u = new Administrateur();
				if(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
					return u;
				}else {
					return null;
				}
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	
	public ArrayList<Administrateur> getAll() {
		ArrayList<Administrateur> list = new ArrayList<Administrateur>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM administrateur");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Administrateur u = new Administrateur();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
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
				
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM administrateur WHERE id=?");
				preparedStatement.setInt(1,id);
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}
	
	public Administrateur rechercher(String mot) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM administrateur WHERE nom like ? OR email like ?");
				preparedStatement.setString(1,"%"+mot+"%");
				preparedStatement.setString(2,"%"+mot+"%");
				ResultSet resultat=preparedStatement.executeQuery();
	
				Administrateur u = new Administrateur();
				while(resultat.next()) {
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMot_de_passe(resultat.getString( "mot_de_passe" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
}
