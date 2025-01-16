package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DetailDAO;
import models.CommentaireDAO;
import models.Database;
import models.DeveloppeurDAO;
import models.Jeu;
import models.JeuDAO;
import models.Panier;
import models.PanierDetails;
import models.Recherche;
import models.RechercheDAO;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class LaRecherche
 */
@WebServlet("/LaRecherche")
public class LaRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaRecherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();

		String mot = "";
		if(request.getParameter("mot")!=null) {
			mot = request.getParameter("mot");
		}
		
		ArrayList<Jeu> jeux = new JeuDAO().rechercher(mot);
		
		request.setAttribute("mot", mot);
		request.setAttribute("jeux", jeux);
		
		DeveloppeurDAO ddao = new DeveloppeurDAO();
		CommentaireDAO comdao = new CommentaireDAO();
		DetailDAO detdao = new DetailDAO();
		request.setAttribute("ddao", ddao);
		request.setAttribute("comdao", comdao);
		request.setAttribute("detdao", detdao);
		
		// ENREGISTRER LA RECHERCHE DE L'UTILISATEUR
		int userid;
		Utilisateur u = new Utilisateur();
		HttpSession session = request.getSession(true);
		if(session.getAttribute("userid")!=null) {
			userid = (Integer)session.getAttribute("userid");
			u = new UtilisateurDAO().getById(userid);
			Recherche ad = new Recherche(mot,jeux.size(),u.getId());
			new RechercheDAO().save(ad);
		}
		
		// AJOUTER AU PANIER
		if(request.getParameter("padd")!=null) {
			int jeuid = Integer.parseInt(request.getParameter("jeu_id"));
			Jeu j = new JeuDAO().getById(jeuid);

			PanierDetails panieradd = new PanierDetails(j, 1);
			Panier panier = (Panier)session.getAttribute("panier");
			panier.ajouter(panieradd);
			System.out.println("ADD PANIER OK");
			
			session.setAttribute("panier", panier);
		}
		
		request.getRequestDispatcher("/larecherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
