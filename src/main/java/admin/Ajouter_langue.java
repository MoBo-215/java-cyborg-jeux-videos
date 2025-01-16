package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Langue;
import models.LangueDAO;
import models.Database;

/**
 * Servlet implementation class Ajouter_langue
 */
@WebServlet(name="Ajouter_langue", urlPatterns="/admin/Ajouter_langue")
public class Ajouter_langue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_langue() {
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
			Langue l = new Langue(request.getParameter("nom"));
			new LangueDAO().save(l);

			msgaddok = true;
			System.out.println("AJOUT LANGUE OK");
		}
		
		request.setAttribute("msgaddok", msgaddok);
		request.getRequestDispatcher("ajouter_langue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
