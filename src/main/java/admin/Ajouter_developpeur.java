package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Developpeur;
import models.DeveloppeurDAO;
import models.Database;

/**
 * Servlet implementation class Ajouter_developpeur
 */
@WebServlet(name="Ajouter_developpeur", urlPatterns="/admin/Ajouter_developpeur")
public class Ajouter_developpeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_developpeur() {
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
		if(request.getParameter("nom")!=null) {
			Developpeur d = new Developpeur(request.getParameter("nom"));
			new DeveloppeurDAO().save(d);

			msgaddok = true;
			System.out.println("AJOUT DEVELOPPEUR OK");
		}
		
		request.setAttribute("msgaddok", msgaddok);
		request.getRequestDispatcher("ajouter_developpeur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
