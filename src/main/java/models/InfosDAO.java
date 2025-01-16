package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InfosDAO {
	public void save(Infos obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE infos_accueil set petite_phrase=?,grande_phrase_pink=?,grande_phrase_white=?,texte_bouton=?,email=? WHERE id=?");
				preparedStatement.setString(1,obj.getPetite_phrase());
				preparedStatement.setString(2, obj.getGrande_phrase_pink());
				preparedStatement.setString(3, obj.getGrande_phrase_white());
				preparedStatement.setString(4, obj.getTexte_bouton());
				preparedStatement.setString(5, obj.getEmail());
				preparedStatement.setInt(6,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO infos_accueil (petite_phrase,grande_phrase_pink,grande_phrase_white,texte_bouton,email) VALUES(?,?,?,?,?)");
				preparedStatement.setString(1,obj.getPetite_phrase());
				preparedStatement.setString(2, obj.getGrande_phrase_pink());
				preparedStatement.setString(3, obj.getGrande_phrase_white());
				preparedStatement.setString(4, obj.getTexte_bouton());
				preparedStatement.setString(5, obj.getEmail());
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
	}
	
	public Infos getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM infos_accueil WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Infos u = new Infos();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setPetite_phrase(resultat.getString( "petite_phrase" ));
					u.setGrande_phrase_pink(resultat.getString( "grande_phrase_pink" ));
					u.setGrande_phrase_white(resultat.getString( "grande_phrase_white" ));
					u.setTexte_bouton(resultat.getString( "texte_bouton" ));
					u.setEmail(resultat.getString( "email" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	
	public ArrayList<Infos> getAll() {
		ArrayList<Infos> list = new ArrayList<Infos>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM infos_accueil");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Infos o = new Infos();
					o.setId(resultat.getInt( "id" ));
					o.setPetite_phrase(resultat.getString( "petite_phrase" ));
					o.setGrande_phrase_pink(resultat.getString( "grande_phrase_pink" ));
					o.setGrande_phrase_white(resultat.getString( "grande_phrase_white" ));
					o.setTexte_bouton(resultat.getString( "texte_bouton" ));
					o.setEmail(resultat.getString( "email" ));
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
			
				PreparedStatement preparedStatement3  = Database.connexion.prepareStatement("DELETE FROM infos_accueil WHERE id=?");
				preparedStatement3.setInt(1,id);
				preparedStatement3.executeUpdate();
				
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}
}
