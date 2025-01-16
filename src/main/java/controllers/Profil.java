package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CategorieDAO;
import models.Commande;
import models.CommandeDAO;
import models.Database;
import models.Jeu;
import models.JeuDAO;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		int user_id = Integer.parseInt(request.getParameter("id"));
		Utilisateur user = new UtilisateurDAO().getById(user_id);
		ArrayList<Commande> cmds = new CommandeDAO().getAllByUtilisateur(user_id);
		int nb_jeux_cmdes = new JeuDAO().getCountJeuxByUtilisateur(user_id);
		int nb_cmds = new CommandeDAO().getCountCmdsByUtilisateur(user_id);
		CategorieDAO cdao = new CategorieDAO();
		
		request.setAttribute("user", user);		
		request.setAttribute("cmds", cmds);		
		request.setAttribute("nb_jeux_cmdes", nb_jeux_cmdes);
		request.setAttribute("nb_cmds", nb_cmds);
		request.setAttribute("cdao", cdao);
		
		request.getRequestDispatcher("/profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
