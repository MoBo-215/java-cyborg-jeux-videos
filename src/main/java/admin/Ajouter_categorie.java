package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Categorie;
import models.CategorieDAO;
import models.Database;

/**
 * Servlet implementation class Ajouter_categorie
 */
@WebServlet(name="Ajouter_categorie", urlPatterns="/admin/Ajouter_categorie")
public class Ajouter_categorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_categorie() {
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
		if(request.getParameter("nom")!=null && request.getParameter("image_url")!=null) {
			Categorie cat = new Categorie(request.getParameter("nom"),request.getParameter("image_url"));
			new CategorieDAO().save(cat);

			msgaddok = true;
			System.out.println("AJOUT CATEGORIE OK");
		}
		
		request.setAttribute("msgaddok", msgaddok);
		request.getRequestDispatcher("ajouter_categorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
