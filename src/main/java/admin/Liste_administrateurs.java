package admin;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Liste_administrateurs
 */
@WebServlet(name="Liste_administrateurs", urlPatterns="/admin/Liste_administrateurs")
public class Liste_administrateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_administrateurs() {
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
		
		ArrayList<Administrateur> admins = new AdministrateurDAO().getAll();
		request.setAttribute("admins", admins);
		
		if(request.getParameter("del")!=null) {
			int userid = Integer.parseInt(request.getParameter("del"));
			new AdministrateurDAO().deleteById(userid);
			
			System.out.println("DELETE UTILISATEUR OK");
			response.sendRedirect("Liste_administrateurs");
		}else {
			request.getRequestDispatcher("liste_administrateurs.jsp").forward(request, response);
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
