package admin;

import java.io.IOException;
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
 * Servlet implementation class Modifier_utilisateur
 */
@WebServlet(name="Modifier_utilisateur",urlPatterns="/admin/Modifier_utilisateur")
public class Modifier_utilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_utilisateur() {
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
		
		int user_id = Integer.parseInt(request.getParameter("id"));
		Utilisateur user = new UtilisateurDAO().getById(user_id);
		request.setAttribute("user", user);
		
		boolean msgeditok = false;
		if(request.getParameter("nom")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null) {
			user.setNom(request.getParameter("nom"));
			user.setEmail(request.getParameter("email"));
			user.setMot_de_passe(request.getParameter("password"));
			new UtilisateurDAO().save(user);
			
			msgeditok = true;
			System.out.println("MODIF USER OK");
		}
		
		request.setAttribute("msgeditok", msgeditok);
		request.getRequestDispatcher("modifier_utilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
