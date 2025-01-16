package admin;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Liste_developpeurs
 */
@WebServlet(name="Liste_developpeurs", urlPatterns="/admin/Liste_developpeurs")
public class Liste_developpeurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_developpeurs() {
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
		
		ArrayList<Developpeur> devs = new DeveloppeurDAO().getAll();
		request.setAttribute("devs", devs);
		
		if(request.getParameter("del")!=null) {
			int dev_id = Integer.parseInt(request.getParameter("del"));
			new DeveloppeurDAO().deleteById(dev_id);
			
			System.out.println("DELETE DEVELOPPEUR OK");
			response.sendRedirect("Liste_developeurs");
		}else {
			request.getRequestDispatcher("liste_developpeurs.jsp").forward(request, response);				
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
