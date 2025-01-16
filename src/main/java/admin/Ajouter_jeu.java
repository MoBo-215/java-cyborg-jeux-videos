package admin;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
 * Servlet implementation class Ajouter_admin
 */
@WebServlet(name="Ajouter_jeu", urlPatterns="/admin/Ajouter_jeu")
public class Ajouter_jeu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_jeu() {
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

		ArrayList<Categorie> cats = new CategorieDAO().getAll();
		ArrayList<Developpeur> devs = new DeveloppeurDAO().getAll();
		ArrayList<Plateforme> ps = new PlateformeDAO().getAll();
		ArrayList<Langue> ls = new LangueDAO().getAll();
		request.setAttribute("cats", cats);
		request.setAttribute("devs", devs);
		request.setAttribute("ps", ps);
		request.setAttribute("ls", ls);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		boolean msgaddok = false;
		if(request.getParameter("titre")!=null && request.getParameter("description")!=null && request.getParameter("date_sortie")!=null && request.getParameter("prix")!=null && request.getParameter("video_un_url")!=null && request.getParameter("video_deux_url")!=null && request.getParameter("image_un_url")!=null && request.getParameter("image_deux_url")!=null && request.getParameter("image_trois_url")!=null && request.getParameter("image_quatre_url")!=null && request.getParameter("image_cinq_url")!=null && request.getParameter("age_minimum")!=null && request.getParameter("langue_id")!=null && request.getParameter("developpeur_id")!=null && request.getParameter("categorie_id")!=null  && request.getParameter("plateforme_id")!=null && request.getParameter("stock")!=null) {
			Jeu j = new Jeu(request.getParameter("titre"),
					request.getParameter("description"),
					Date.valueOf(LocalDate.parse(request.getParameter("date_sortie"),formatter)),
					Double.parseDouble(request.getParameter("prix")),
					request.getParameter("video_un_url"),
					request.getParameter("video_deux_url"),
					request.getParameter("image_un_url"),
					request.getParameter("image_deux_url"),
					request.getParameter("image_trois_url"),
					request.getParameter("image_quatre_url"),
					request.getParameter("image_cinq_url"),
					Integer.parseInt(request.getParameter("age_minimum")),
					Integer.parseInt(request.getParameter("langue_id")),
					Integer.parseInt(request.getParameter("developpeur_id")),
					Integer.parseInt(request.getParameter("categorie_id")),
					Integer.parseInt(request.getParameter("plateforme_id")),
					Integer.parseInt(request.getParameter("stock")));
			new JeuDAO().save(j);
			
			msgaddok = true;
			System.out.println("AJOUT JEU OK");
		}else {
			System.out.println("NO AJOUT JEU");
		}

		request.setAttribute("msgaddok", msgaddok);
		request.getRequestDispatcher("ajouter_jeu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
