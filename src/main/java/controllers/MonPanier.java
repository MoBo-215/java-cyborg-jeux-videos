package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Commande;
import models.CommandeDAO;
import models.Database;
import models.Detail;
import models.DetailDAO;
import models.DeveloppeurDAO;
import models.Panier;
import models.PanierDetails;
import models.Jeu;
import models.JeuDAO;

/**
 * Servlet implementation class Monpanier
 */
@WebServlet("/MonPanier")
public class MonPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		boolean commandeok = false;
		
		DeveloppeurDAO devdao = new DeveloppeurDAO();
		request.setAttribute("devdao", devdao);
		
		// SUPPRIMER UN PRODUIT
		if(request.getParameter("delete")!=null) {
			HttpSession session = request.getSession(true);
			
			int idproduit = Integer.valueOf(request.getParameter("delete"));
			
			Panier panier = (Panier)session.getAttribute("panier");
			panier.delete(idproduit);
			
			session.setAttribute("panier", panier);
			System.out.println("DELETE OK");
		}
		
		// VALIDER LA COMMANDE
		if(request.getParameter("valider")!=null) {
			HttpSession session = request.getSession(true);
			CommandeDAO cdao = new CommandeDAO();
			DetailDAO ddao = new DetailDAO();
			JeuDAO jdao = new JeuDAO();
			
			Panier panier = (Panier)session.getAttribute("panier");
			
			int inscription_id = (int)session.getAttribute("userid");
			double total = panier.total();
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			String etat = "En attente";
			
			// ENREGISTREMENT COMMANDE ET RECUPERATION ID
			Commande cmd = new Commande(inscription_id,total,date,etat);
			int cmd_id = cdao.save(cmd);
			
			// ENREGISTREMENT DETAILS COMMANDE
			for(PanierDetails pa:panier.articles) {
				Detail d = new Detail();
				d.setNb(pa.getQte());
				d.setCommande_id(cmd_id);
				d.setPrixu(pa.getJeu().getPrix());
				d.setJeu_id(pa.getJeu().getId());
				ddao.save(d);
				
				Jeu j = jdao.getById(pa.getJeu().getId());
				j.setStock(j.getStock()-d.getNb());
				jdao.save(j);
			}
			panier.vider();
			
			session.setAttribute("panier", panier);
			commandeok = true;
			response.sendRedirect("Commandeok");
		}
		
		if(!commandeok) {	
			request.getRequestDispatcher("/monpanier.jsp").forward(request, response);
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
