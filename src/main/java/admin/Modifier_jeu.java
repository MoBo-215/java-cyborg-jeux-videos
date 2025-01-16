package admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Categorie;
import models.CategorieDAO;
import models.Database;
import models.Developpeur;
import models.DeveloppeurDAO;
import models.Jeu;
import models.JeuDAO;
import models.Langue;
import models.LangueDAO;
import models.Plateforme;
import models.PlateformeDAO;

/**
 * Servlet implementation class Modifier_jeu
 */
@WebServlet(name="Modifier_jeu", urlPatterns="/admin/Modifier_jeu")
public class Modifier_jeu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_jeu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		HttpSession adminSession = request.getSession();
		if((String)adminSession.getAttribute("isCo")!="yes" || (String)adminSession.getAttribute("isCo")==null) {
			response.sendRedirect("Connexion_admin");
			return;
		}
		
		int jeu_id = Integer.parseInt(request.getParameter("id"));
		Jeu j = new JeuDAO().getById(jeu_id);
		request.setAttribute("j", j);
		
		ArrayList<Categorie> cats = new CategorieDAO().getAll();
		request.setAttribute("cats", cats);
		
		ArrayList<Developpeur> devs = new DeveloppeurDAO().getAll();
		request.setAttribute("devs", devs);
		
		ArrayList<Plateforme> ps = new PlateformeDAO().getAll();
		request.setAttribute("ps", ps);
		
		ArrayList<Langue> ls = new LangueDAO().getAll();
		request.setAttribute("ls", ls);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		boolean msgeditok = false;
		if(request.getParameter("titre")!=null && request.getParameter("description")!=null && request.getParameter("date_sortie")!=null && request.getParameter("prix")!=null && request.getParameter("video_un_url")!=null && request.getParameter("video_deux_url")!=null && request.getParameter("image_un_url")!=null && request.getParameter("image_deux_url")!=null && request.getParameter("image_trois_url")!=null && request.getParameter("image_quatre_url")!=null && request.getParameter("image_cinq_url")!=null && request.getParameter("age_minimum")!=null && request.getParameter("langue_id")!=null && request.getParameter("developpeur_id")!=null && request.getParameter("categorie_id")!=null  && request.getParameter("plateforme_id")!=null && request.getParameter("stock")!=null) {
			j.setTitre(request.getParameter("titre"));
			j.setDescription(request.getParameter("description"));
			j.setDate_sortie(Date.valueOf(LocalDate.parse(request.getParameter("date_sortie"),formatter)));
			j.setPrix(Double.parseDouble(request.getParameter("prix")));
			j.setVideo_un_url(request.getParameter("video_un_url"));
			j.setVideo_deux_url(request.getParameter("video_deux_url"));
			j.setImage_un_url(request.getParameter("image_un_url"));
			j.setImage_deux_url(request.getParameter("image_deux_url"));
			j.setImage_trois_url(request.getParameter("image_trois_url"));
			j.setImage_quatre_url(request.getParameter("image_quatre_url"));
			j.setImage_cinq_url(request.getParameter("image_cinq_url"));
			j.setAge_minimum(Integer.parseInt(request.getParameter("age_minimum")));
			j.setLangue_id(Integer.parseInt(request.getParameter("langue_id")));
			j.setDeveloppeur_id(Integer.parseInt(request.getParameter("developpeur_id")));
			j.setCategorie_id(Integer.parseInt(request.getParameter("categorie_id")));
			j.setPlateforme_id(Integer.parseInt(request.getParameter("plateforme_id")));
			j.setStock(Integer.parseInt(request.getParameter("stock")));
			new JeuDAO().save(j);
			
			msgeditok = true;
			System.out.println("MODIF JEU OK");
		}
		
		request.setAttribute("msgeditok", msgeditok);
		request.getRequestDispatcher("modifier_jeu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
