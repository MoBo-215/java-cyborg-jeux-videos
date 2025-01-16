package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Panier;
import models.PanierDetails;
import models.Plateforme;
import models.PlateformeDAO;
import models.UtilisateurDAO;
import models.Developpeur;
import models.DeveloppeurDAO;
import models.Categorie;
import models.CategorieDAO;
import models.DetailDAO;
import models.Commentaire;
import models.CommentaireDAO;
import models.Database;
import models.Jeu;
import models.JeuDAO;
import models.Langue;
import models.LangueDAO;

/**
 * Servlet implementation class LeJeu
 */
@WebServlet("/LeJeu")
public class LeJeu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeJeu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		int jeuid = Integer.parseInt(request.getParameter("id"));
		Jeu j = new JeuDAO().getById(jeuid);
		ArrayList<Jeu> jeux = new JeuDAO().getAllByCatOrderByDateDesc(j.getCategorie_id());
		Developpeur d = new DeveloppeurDAO().getById(j.getDeveloppeur_id());
		Categorie c = new CategorieDAO().getById(j.getCategorie_id());
		Plateforme p = new PlateformeDAO().getById(j.getPlateforme_id());
		Langue l = new LangueDAO().getById(j.getLangue_id());
		request.setAttribute("j", j);
		request.setAttribute("jeux", jeux);
		request.setAttribute("d", d);
		request.setAttribute("c", c);
		request.setAttribute("p", p);
		request.setAttribute("l", l);

		ArrayList<Commentaire> coms = new CommentaireDAO().getAllByJeu(jeuid);
		int nb_coms = new CommentaireDAO().getCountCommentairesByJeu(jeuid);
		double moy_jeu = new CommentaireDAO().getMoyenneNotesByJeuId(jeuid);
		int nb_cmds_jeu = new DetailDAO().getCountVentesByJeu(jeuid);
		request.setAttribute("coms", coms);
		request.setAttribute("nb_coms", nb_coms);
		request.setAttribute("moy_jeu", moy_jeu);
		request.setAttribute("nb_cmds_jeu", nb_cmds_jeu);
		
		DeveloppeurDAO ddao = new DeveloppeurDAO();
		CommentaireDAO comdao = new CommentaireDAO();
		DetailDAO detdao = new DetailDAO();
		UtilisateurDAO udao = new UtilisateurDAO();
		CategorieDAO cdao = new CategorieDAO();
		request.setAttribute("ddao", ddao);
		request.setAttribute("comdao", comdao);
		request.setAttribute("detdao", detdao);
		request.setAttribute("udao", udao);
		request.setAttribute("cdao", cdao);
		
		// AJOUTER AU PANIER
		if(request.getParameter("padd")!=null) {
			HttpSession session = request.getSession(true);
			
			PanierDetails panieradd = new PanierDetails(j, 1);
			Panier panier = (Panier)session.getAttribute("panier");
			panier.ajouter(panieradd);
			System.out.println("ADD PANIER OK");
			
			session.setAttribute("panier", panier);
			response.sendRedirect("LeJeu?id="+jeuid);
			
		// AJOUTER UN COMMENTAIRE
		} else if(request.getParameter("paddcom")!=null && request.getParameter("note")!=null && request.getParameter("commentaire")!=null) {
			HttpSession session = request.getSession(true);
			
			int note = Integer.parseInt(request.getParameter("note"));
			String commentaire = request.getParameter("commentaire");
			int userid = (Integer)session.getAttribute("userid");
			boolean approuve = true;
			
			Commentaire com = new Commentaire(note,commentaire,userid,jeuid,approuve);
			new CommentaireDAO().save(com);
			System.out.println("ADD COMMENTAIRE OK");
			
			response.sendRedirect("LeJeu?id="+jeuid);
		} else{
			request.getRequestDispatcher("/lejeu.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
