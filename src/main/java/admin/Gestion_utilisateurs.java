package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Database;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Gestion_utilisateurs
 */
@WebServlet(name="Gestion_utilisateurs", urlPatterns="/admin/Gestion_utilisateurs")
public class Gestion_utilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion_utilisateurs() {
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
		
		ArrayList<Utilisateur> users = new UtilisateurDAO().getAll();
		request.setAttribute("users", users);
		
		if(request.getParameter("ban")!=null) {
			int userid = Integer.parseInt(request.getParameter("ban"));
			Utilisateur u = new UtilisateurDAO().getById(userid);
			new UtilisateurDAO().banById(u);
			
			System.out.println("BAN UTILISATEUR OK");
			response.sendRedirect("Gestion_utilisateurs");
		}else if(request.getParameter("deban")!=null) {
			int userid = Integer.parseInt(request.getParameter("deban"));
			Utilisateur u = new UtilisateurDAO().getById(userid);
			new UtilisateurDAO().debanById(u);
			
			System.out.println("DEBAN UTILISATEUR OK");
			response.sendRedirect("Gestion_utilisateurs");
		}else if(request.getParameter("del")!=null) {
			int userid = Integer.parseInt(request.getParameter("del"));
			new UtilisateurDAO().deleteById(userid);
			
			System.out.println("DELETE UTILISATEUR OK");
			response.sendRedirect("Gestion_utilisateurs");
		}else {
			request.getRequestDispatcher("gestion_utilisateurs.jsp").forward(request, response);			
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
