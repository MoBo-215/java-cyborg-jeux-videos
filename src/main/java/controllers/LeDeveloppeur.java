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
import models.Developpeur;
import models.DeveloppeurDAO;

/**
 * Servlet implementation class LeDeveloppeur
 */
@WebServlet("/LeDeveloppeur")
public class LeDeveloppeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeDeveloppeur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		int d_id = Integer.parseInt(request.getParameter("id"));
		Developpeur d = new DeveloppeurDAO().getById(d_id);
		ArrayList<Jeu> jeux = new JeuDAO().getAllByDeveloppeur(d_id);
		request.setAttribute("d", d);
		request.setAttribute("jeux", jeux);
		
		DeveloppeurDAO ddao = new DeveloppeurDAO();
		CommentaireDAO comdao = new CommentaireDAO();
		DetailDAO detdao = new DetailDAO();
		request.setAttribute("ddao", ddao);
		request.setAttribute("comdao", comdao);
		request.setAttribute("detdao", detdao);
		
		// AJOUTER AU PANIER
		HttpSession session = request.getSession(true);
		if(request.getParameter("padd")!=null) {
			int jeuid = Integer.parseInt(request.getParameter("jeu_id"));
			Jeu j = new JeuDAO().getById(jeuid);

			PanierDetails panieradd = new PanierDetails(j, 1);
			Panier panier = (Panier)session.getAttribute("panier");
			panier.ajouter(panieradd);
			System.out.println("ADD PANIER OK");
			
			session.setAttribute("panier", panier);
		}
		
		request.getRequestDispatcher("/ledeveloppeur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
