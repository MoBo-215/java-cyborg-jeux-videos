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
import models.DeveloppeurDAO;
import models.Jeu;
import models.JeuDAO;
import models.LangueDAO;
import models.PlateformeDAO;

/**
 * Servlet implementation class Liste_jeux_admin
 */
@WebServlet(name="Liste_jeux", urlPatterns="/admin/Liste_jeux")
public class Liste_jeux extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_jeux() {
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
		
		ArrayList<Jeu> jeux = new JeuDAO().getAll();
		
		CategorieDAO cdao = new CategorieDAO();		
		PlateformeDAO pdao = new PlateformeDAO();
		DeveloppeurDAO ddao = new DeveloppeurDAO();
		LangueDAO ldao = new LangueDAO();
		
		request.setAttribute("jeux", jeux);
		request.setAttribute("cdao", cdao);
		request.setAttribute("pdao", pdao);
		request.setAttribute("ddao", ddao);
		request.setAttribute("ldao", ldao);
				
		if(request.getParameter("del")!=null) {
			int prodid = Integer.parseInt(request.getParameter("del"));
			new JeuDAO().deleteById(prodid);
			
			System.out.println("DELETE JEU OK");
			response.sendRedirect("Liste_jeux");
		}else {
			request.getRequestDispatcher("liste_jeux.jsp").forward(request, response);			
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
