package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class JeuDAO {
	public void save(Jeu obj) {
			
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE jeu set titre=?,description=?,date_sortie=?,prix=?,video_un_url=?,video_deux_url=?,image_un_url=?,image_deux_url=?,image_trois_url=?,image_quatre_url=?,image_cinq_url=?,age_minimum=?,langue_id=?,developpeur_id=?,categorie_id=?,plateforme_id=?,stock=? WHERE id=?");
				preparedStatement.setString(1,obj.getTitre());
				preparedStatement.setString(2, obj.getDescription());
				preparedStatement.setDate(3, obj.getDate_sortie());
				preparedStatement.setDouble(4, obj.getPrix());
				preparedStatement.setString(5, obj.getVideo_un_url());
				preparedStatement.setString(6, obj.getVideo_deux_url());
				preparedStatement.setString(7, obj.getImage_un_url());
				preparedStatement.setString(8, obj.getImage_deux_url());
				preparedStatement.setString(9, obj.getImage_trois_url());
				preparedStatement.setString(10, obj.getImage_quatre_url());
				preparedStatement.setString(11, obj.getImage_cinq_url());
				preparedStatement.setInt(12,obj.getAge_minimum());
				preparedStatement.setInt(13,obj.getLangue_id());
				preparedStatement.setInt(14,obj.getDeveloppeur_id());
				preparedStatement.setInt(15,obj.getCategorie_id());
				preparedStatement.setInt(16,obj.getPlateforme_id());
				preparedStatement.setInt(17,obj.getStock());
				preparedStatement.setInt(18,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO jeu (titre,description,date_sortie,prix,video_un_url,video_deux_url,image_un_url,image_deux_url,image_trois_url,image_quatre_url,image_cinq_url,age_minimum,langue_id,developpeur_id,categorie_id,plateforme_id,stock) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1,obj.getTitre());
				preparedStatement.setString(2, obj.getDescription());
				preparedStatement.setDate(3, obj.getDate_sortie());
				preparedStatement.setDouble(4, obj.getPrix());
				preparedStatement.setString(5, obj.getVideo_un_url());
				preparedStatement.setString(6, obj.getVideo_deux_url());
				preparedStatement.setString(7, obj.getImage_un_url());
				preparedStatement.setString(8, obj.getImage_deux_url());
				preparedStatement.setString(9, obj.getImage_trois_url());
				preparedStatement.setString(10, obj.getImage_quatre_url());
				preparedStatement.setString(11, obj.getImage_cinq_url());
				preparedStatement.setInt(12,obj.getAge_minimum());
				preparedStatement.setInt(13,obj.getLangue_id());
				preparedStatement.setInt(14,obj.getDeveloppeur_id());
				preparedStatement.setInt(15,obj.getCategorie_id());
				preparedStatement.setInt(16,obj.getPlateforme_id());
				preparedStatement.setInt(17,obj.getStock());
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
	}
	
	public int getCountJeuxByCategorie(int id) {
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
	
	public int getCountJeuxByPlateforme(int id) {
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
	
	public int getCountJeuxByLangue(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT COUNT(*) as nbr FROM jeu WHERE langue_id=?");
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
	
	public int getCountJeuxByUtilisateur(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT SUM(d.nb) as nbr FROM detail d JOIN commande c ON d.commande_id = c.id JOIN utilisateur u ON c.utilisateur_id = u.id WHERE u.id=?");
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
	
	
	public Jeu getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Jeu u = new Jeu();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setTitre(resultat.getString( "titre" ));
					u.setDescription(resultat.getString("description"));
					u.setDate_sortie(resultat.getDate("date_sortie"));
					u.setPrix(resultat.getDouble("prix"));
					u.setVideo_un_url(resultat.getString("video_un_url"));
					u.setVideo_deux_url(resultat.getString("video_deux_url"));
					u.setImage_un_url(resultat.getString("image_un_url"));
					u.setImage_deux_url(resultat.getString("image_deux_url"));
					u.setImage_trois_url(resultat.getString("image_trois_url"));
					u.setImage_quatre_url(resultat.getString("image_quatre_url"));
					u.setImage_cinq_url(resultat.getString("image_cinq_url"));
					u.setAge_minimum(resultat.getInt("age_minimum"));
					u.setLangue_id(resultat.getInt( "langue_id" ));
					u.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					u.setCategorie_id(resultat.getInt( "categorie_id" ));
					u.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					u.setStock(resultat.getInt( "stock" ));
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> getAllByCat(int id) {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu WHERE categorie_id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Jeu o = new Jeu();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setDescription(resultat.getString("description"));
					o.setDate_sortie(resultat.getDate("date_sortie"));
					o.setPrix(resultat.getDouble("prix"));
					o.setVideo_un_url(resultat.getString("video_un_url"));
					o.setVideo_deux_url(resultat.getString("video_deux_url"));
					o.setImage_un_url(resultat.getString("image_un_url"));
					o.setImage_deux_url(resultat.getString("image_deux_url"));
					o.setImage_trois_url(resultat.getString("image_trois_url"));
					o.setImage_quatre_url(resultat.getString("image_quatre_url"));
					o.setImage_cinq_url(resultat.getString("image_cinq_url"));
					o.setAge_minimum(resultat.getInt("age_minimum"));
					o.setLangue_id(resultat.getInt( "langue_id" ));
					o.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					o.setCategorie_id(resultat.getInt( "categorie_id" ));
					o.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					o.setStock(resultat.getInt( "stock" ));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> getAllByCatOrderByDateDesc(int id) {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu WHERE categorie_id=? ORDER BY date_sortie DESC");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Jeu o = new Jeu();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setDescription(resultat.getString("description"));
					o.setDate_sortie(resultat.getDate("date_sortie"));
					o.setPrix(resultat.getDouble("prix"));
					o.setVideo_un_url(resultat.getString("video_un_url"));
					o.setVideo_deux_url(resultat.getString("video_deux_url"));
					o.setImage_un_url(resultat.getString("image_un_url"));
					o.setImage_deux_url(resultat.getString("image_deux_url"));
					o.setImage_trois_url(resultat.getString("image_trois_url"));
					o.setImage_quatre_url(resultat.getString("image_quatre_url"));
					o.setImage_cinq_url(resultat.getString("image_cinq_url"));
					o.setAge_minimum(resultat.getInt("age_minimum"));
					o.setLangue_id(resultat.getInt( "langue_id" ));
					o.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					o.setCategorie_id(resultat.getInt( "categorie_id" ));
					o.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					o.setStock(resultat.getInt( "stock" ));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> getAllByPlateforme(int id) {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu WHERE plateforme_id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Jeu o = new Jeu();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setDescription(resultat.getString("description"));
					o.setDate_sortie(resultat.getDate("date_sortie"));
					o.setPrix(resultat.getDouble("prix"));
					o.setVideo_un_url(resultat.getString("video_un_url"));
					o.setVideo_deux_url(resultat.getString("video_deux_url"));
					o.setImage_un_url(resultat.getString("image_un_url"));
					o.setImage_deux_url(resultat.getString("image_deux_url"));
					o.setImage_trois_url(resultat.getString("image_trois_url"));
					o.setImage_quatre_url(resultat.getString("image_quatre_url"));
					o.setImage_cinq_url(resultat.getString("image_cinq_url"));
					o.setAge_minimum(resultat.getInt("age_minimum"));
					o.setLangue_id(resultat.getInt( "langue_id" ));
					o.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					o.setCategorie_id(resultat.getInt( "categorie_id" ));
					o.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					o.setStock(resultat.getInt( "stock" ));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> getAllByDeveloppeur(int id) {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu WHERE developpeur_id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Jeu o = new Jeu();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setDescription(resultat.getString("description"));
					o.setDate_sortie(resultat.getDate("date_sortie"));
					o.setPrix(resultat.getDouble("prix"));
					o.setVideo_un_url(resultat.getString("video_un_url"));
					o.setVideo_deux_url(resultat.getString("video_deux_url"));
					o.setImage_un_url(resultat.getString("image_un_url"));
					o.setImage_deux_url(resultat.getString("image_deux_url"));
					o.setImage_trois_url(resultat.getString("image_trois_url"));
					o.setImage_quatre_url(resultat.getString("image_quatre_url"));
					o.setImage_cinq_url(resultat.getString("image_cinq_url"));
					o.setAge_minimum(resultat.getInt("age_minimum"));
					o.setLangue_id(resultat.getInt( "langue_id" ));
					o.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					o.setCategorie_id(resultat.getInt( "categorie_id" ));
					o.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					o.setStock(resultat.getInt( "stock" ));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> getAllByLangue(int id) {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu WHERE langue_id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Jeu o = new Jeu();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setDescription(resultat.getString("description"));
					o.setDate_sortie(resultat.getDate("date_sortie"));
					o.setPrix(resultat.getDouble("prix"));
					o.setVideo_un_url(resultat.getString("video_un_url"));
					o.setVideo_deux_url(resultat.getString("video_deux_url"));
					o.setImage_un_url(resultat.getString("image_un_url"));
					o.setImage_deux_url(resultat.getString("image_deux_url"));
					o.setImage_trois_url(resultat.getString("image_trois_url"));
					o.setImage_quatre_url(resultat.getString("image_quatre_url"));
					o.setImage_cinq_url(resultat.getString("image_cinq_url"));
					o.setAge_minimum(resultat.getInt("age_minimum"));
					o.setLangue_id(resultat.getInt( "langue_id" ));
					o.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					o.setCategorie_id(resultat.getInt( "categorie_id" ));
					o.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					o.setStock(resultat.getInt( "stock" ));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> getAll() {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Jeu o = new Jeu();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setDescription(resultat.getString("description"));
					o.setDate_sortie(resultat.getDate("date_sortie"));
					o.setPrix(resultat.getDouble("prix"));
					o.setVideo_un_url(resultat.getString("video_un_url"));
					o.setVideo_deux_url(resultat.getString("video_deux_url"));
					o.setImage_un_url(resultat.getString("image_un_url"));
					o.setImage_deux_url(resultat.getString("image_deux_url"));
					o.setImage_trois_url(resultat.getString("image_trois_url"));
					o.setImage_quatre_url(resultat.getString("image_quatre_url"));
					o.setImage_cinq_url(resultat.getString("image_cinq_url"));
					o.setAge_minimum(resultat.getInt("age_minimum"));
					o.setLangue_id(resultat.getInt( "langue_id" ));
					o.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					o.setCategorie_id(resultat.getInt( "categorie_id" ));
					o.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					o.setStock(resultat.getInt( "stock" ));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> getAllOrderByDateSortieDesc() {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu ORDER BY date_sortie DESC");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Jeu o = new Jeu();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setDescription(resultat.getString("description"));
					o.setDate_sortie(resultat.getDate("date_sortie"));
					o.setPrix(resultat.getDouble("prix"));
					o.setVideo_un_url(resultat.getString("video_un_url"));
					o.setVideo_deux_url(resultat.getString("video_deux_url"));
					o.setImage_un_url(resultat.getString("image_un_url"));
					o.setImage_deux_url(resultat.getString("image_deux_url"));
					o.setImage_trois_url(resultat.getString("image_trois_url"));
					o.setImage_quatre_url(resultat.getString("image_quatre_url"));
					o.setImage_cinq_url(resultat.getString("image_cinq_url"));
					o.setAge_minimum(resultat.getInt("age_minimum"));
					o.setLangue_id(resultat.getInt( "langue_id" ));
					o.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					o.setCategorie_id(resultat.getInt( "categorie_id" ));
					o.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					o.setStock(resultat.getInt( "stock" ));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> getAllOrderByBestSellingGames() {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT j.id, j.titre, j.image_un_url, j.developpeur_id, SUM(d.nb) AS best_sellers FROM detail d JOIN jeu j ON d.jeu_id = j.id GROUP BY j.id, j.titre, j.image_un_url, j.developpeur_id ORDER BY best_sellers DESC");
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Jeu o = new Jeu();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setImage_un_url(resultat.getString("image_un_url"));
					o.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					list.add(o);
				}
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Integer> getCountJeuxByAllCategories() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT COUNT(*) as nbr FROM jeu GROUP BY categorie_id");
				ResultSet resultat=preparedStatement.executeQuery();
				
				while(resultat.next()) {
					int nbr = resultat.getInt( "nbr" );
					list.add(nbr);
				}
				
				System.out.println("COUNT GRAPHIC OK");
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Integer> getCountJeuxVendusByAllCategories() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT SUM(d.nb) as nbr FROM detail d JOIN jeu j ON d.jeu_id = j.id JOIN categorie c ON j.categorie_id = c.id GROUP BY c.id");
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					int nbr = resultat.getInt( "nbr" );
					list.add(nbr);
				}
				
				System.out.println("COUNT GRAPHIC OK");
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Jeu> rechercher(String mot) {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM jeu WHERE titre like ? OR description like ? OR langue_id IN(SELECT id FROM langue WHERE nom like ?) OR developpeur_id IN(SELECT id FROM developpeur WHERE nom like ?) OR categorie_id IN(SELECT id FROM categorie WHERE nom like ?) OR plateforme_id IN(SELECT id FROM plateforme WHERE nom like ?)");
				preparedStatement.setString(1,"%"+mot+"%");
				preparedStatement.setString(2,"%"+mot+"%");
				preparedStatement.setString(3,"%"+mot+"%");
				preparedStatement.setString(4,"%"+mot+"%");
				preparedStatement.setString(5,"%"+mot+"%");
				preparedStatement.setString(6,"%"+mot+"%");
				ResultSet resultat=preparedStatement.executeQuery();
				
				while(resultat.next()) {
					Jeu u = new Jeu();
					u.setId(resultat.getInt( "id" ));
					u.setTitre(resultat.getString( "titre" ));
					u.setDescription(resultat.getString("description"));
					u.setDate_sortie(resultat.getDate("date_sortie"));
					u.setPrix(resultat.getDouble("prix"));
					u.setVideo_un_url(resultat.getString("video_un_url"));
					u.setVideo_deux_url(resultat.getString("video_deux_url"));
					u.setImage_un_url(resultat.getString("image_un_url"));
					u.setImage_deux_url(resultat.getString("image_deux_url"));
					u.setImage_trois_url(resultat.getString("image_trois_url"));
					u.setImage_quatre_url(resultat.getString("image_quatre_url"));
					u.setImage_cinq_url(resultat.getString("image_cinq_url"));
					u.setAge_minimum(resultat.getInt("age_minimum"));
					u.setLangue_id(resultat.getInt( "langue_id" ));
					u.setDeveloppeur_id(resultat.getInt( "developpeur_id" ));
					u.setCategorie_id(resultat.getInt( "categorie_id" ));
					u.setPlateforme_id(resultat.getInt( "plateforme_id" ));
					u.setStock(resultat.getInt( "stock" ));
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
			
				PreparedStatement preparedStatement3  = Database.connexion.prepareStatement("DELETE FROM jeu WHERE id=?");
				preparedStatement3.setInt(1,id);
				preparedStatement3.executeUpdate();
				
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}
}
