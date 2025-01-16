package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Categorie;
import models.CategorieDAO;
import models.DetailDAO;
import models.CommentaireDAO;
import models.Database;
import models.DeveloppeurDAO;
import models.Infos;
import models.InfosDAO;
import models.Jeu;
import models.JeuDAO;
import models.Panier;
import models.PanierDetails;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		DeveloppeurDAO ddao = new DeveloppeurDAO();
		CommentaireDAO comdao = new CommentaireDAO();
		DetailDAO detdao = new DetailDAO();
		CategorieDAO catdao = new CategorieDAO();
		request.setAttribute("ddao", ddao);
		request.setAttribute("comdao", comdao);
		request.setAttribute("detdao", detdao);
		request.setAttribute("catdao", catdao);
		
		Infos i = new InfosDAO().getById(1);
		request.setAttribute("i",i);
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("userid")==null || session.getAttribute("userid").equals(0)|| session.getAttribute("userid").equals("")) {
			session.setAttribute("userid", 0);
			session.setAttribute("usernom", "");
			session.setAttribute("useremail", "");
			session.setAttribute("isConnected", false);
			
			ArrayList<Jeu> jeux = new JeuDAO().getAllOrderByBestSellingGames();
			request.setAttribute("jeux", jeux);
			System.out.println("NO CO GAMES OK");
		}else {
			Integer user_id = Integer.parseInt(session.getAttribute("userid").toString());
			System.out.println(user_id);
			
			Categorie c = catdao.getMostBuyCatByUserId(user_id);
			System.out.println(c.getNom());
			
			ArrayList<Jeu> jeux = new JeuDAO().getAllByCatOrderByDateDesc(c.getId());
			request.setAttribute("jeux", jeux);		
			System.out.println("CO GAMES OK");
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
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
