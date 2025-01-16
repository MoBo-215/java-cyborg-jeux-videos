package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Database;
import models.Panier;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Header_site
 */
@WebServlet("/Header_site")
public class Header_site extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header_site() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("isConnected")==null) {
			session.setAttribute("isConnected", false);
		}
		
		if((Panier)session.getAttribute("panier")==null) {
			Panier panier_temp = new Panier();
			session.setAttribute("panier", panier_temp);
		}
		
		request.getRequestDispatcher("/header_site.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
