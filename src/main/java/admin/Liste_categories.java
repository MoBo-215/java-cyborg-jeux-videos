package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Categorie;
import models.CategorieDAO;
import models.Database;
import models.Jeu;
import models.JeuDAO;

/**
 * Servlet implementation class Liste_categories
 */
@WebServlet(name="Liste_categories", urlPatterns="/admin/Liste_categories")
public class Liste_categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_categories() {
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
		
		ArrayList<Categorie> cats = new CategorieDAO().getAll();
		request.setAttribute("cats", cats);
		
		if(request.getParameter("del")!=null) {
			int catid = Integer.parseInt(request.getParameter("del"));
			new CategorieDAO().deleteById(catid);
			
			System.out.println("DELETE CATEGORIE OK");
			response.sendRedirect("Liste_categories");
		}else {
			request.getRequestDispatcher("liste_categories.jsp").forward(request, response);				
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
