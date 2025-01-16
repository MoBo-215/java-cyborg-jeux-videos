package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Utilisateur;
import models.UtilisateurDAO;
import models.Database;

/**
 * Servlet implementation class Modifier_profil
 */
@WebServlet("/Modifier_profil")
public class Modifier_profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_profil() {
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
		request.setAttribute("user", user);
		
		if(request.getParameter("nom")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null) {
			user.setNom(request.getParameter("nom"));
			user.setEmail(request.getParameter("email"));
			user.setMot_de_passe(request.getParameter("password"));
			new UtilisateurDAO().save(user);
			
			System.out.println("MODIF USER OK");
			HttpSession session = request.getSession(true);
			session.setAttribute("usernom", user.getNom());
			
			response.sendRedirect("Profil?id="+user_id+"");
		}else {
			request.getRequestDispatcher("/modifier_profil.jsp").forward(request, response);			
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
