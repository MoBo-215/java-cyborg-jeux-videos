package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Database;
import models.Administrateur;
import models.AdministrateurDAO;

/**
 * Servlet implementation class Ajouter_administrateur
 */
@WebServlet(name="Ajouter_administrateur", urlPatterns="/admin/Ajouter_administrateur")
public class Ajouter_administrateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_administrateur() {
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
		
		boolean msgaddok = false;
		boolean isban = false;
		boolean isadmin = true;
		if(request.getParameter("nom")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null) {
			Administrateur new_admin = new Administrateur(request.getParameter("nom"),
			request.getParameter("email"),
			request.getParameter("password"),
			isban,
			isadmin);
			new AdministrateurDAO().save(new_admin);
			
			msgaddok = true;
			System.out.println("AJOUT ADMIN OK");
		}

		request.setAttribute("msgaddok", msgaddok);
		request.getRequestDispatcher("ajouter_administrateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
