package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Plateforme;
import models.PlateformeDAO;
import models.Database;

/**
 * Servlet implementation class Ajouter_plateforme
 */
@WebServlet(name="Ajouter_plateforme", urlPatterns="/admin/Ajouter_plateforme")
public class Ajouter_plateforme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_plateforme() {
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
			Plateforme p = new Plateforme(request.getParameter("nom"));
			new PlateformeDAO().save(p);

			msgaddok = true;
			System.out.println("AJOUT PLATEFORME OK");
		}
		
		request.setAttribute("msgaddok", msgaddok);
		request.getRequestDispatcher("ajouter_plateforme.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
