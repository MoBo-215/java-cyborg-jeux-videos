package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Commentaire;
import models.CommentaireDAO;
import models.Database;
import models.JeuDAO;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Gestion_commentaires
 */
@WebServlet(name="Gestion_commentaires", urlPatterns="/admin/Gestion_commentaires")
public class Gestion_commentaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion_commentaires() {
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
		
		ArrayList<Commentaire> coms = new CommentaireDAO().getAll();
		request.setAttribute("coms", coms);
		
		UtilisateurDAO udao = new UtilisateurDAO();
		request.setAttribute("udao", udao);
		
		JeuDAO jdao = new JeuDAO();
		request.setAttribute("jdao", jdao);
		
		if(request.getParameter("ban")!=null) {
			int com_id = Integer.parseInt(request.getParameter("ban"));
			Commentaire c = new CommentaireDAO().getById(com_id);
			new CommentaireDAO().banById(c);
			
			System.out.println("BAN COMMENTAIRE OK");
			response.sendRedirect("Gestion_commentaires");
		}else if(request.getParameter("deban")!=null) {
			int com_id = Integer.parseInt(request.getParameter("deban"));
			Commentaire c = new CommentaireDAO().getById(com_id);
			new CommentaireDAO().debanById(c);
			
			System.out.println("DEBAN COMMENTAIRE OK");
			response.sendRedirect("Gestion_commentaires");
		}else if(request.getParameter("del")!=null) {
			int com_id = Integer.parseInt(request.getParameter("del"));
			new CommentaireDAO().deleteById(com_id);
			
			System.out.println("DELETE COMMENTAIRE OK");
			response.sendRedirect("Gestion_commentaires");
		}else {
			request.getRequestDispatcher("gestion_commentaires.jsp").forward(request, response);			
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
