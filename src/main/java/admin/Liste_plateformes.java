package admin;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Liste_plateformes
 */
@WebServlet(name="Liste_plateformes", urlPatterns="/admin/Liste_plateformes")
public class Liste_plateformes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_plateformes() {
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
		
		ArrayList<Plateforme> ps = new PlateformeDAO().getAll();
		request.setAttribute("ps", ps);
		
		if(request.getParameter("del")!=null) {
			int p_id = Integer.parseInt(request.getParameter("del"));
			new PlateformeDAO().deleteById(p_id);
			
			System.out.println("DELETE PLATEFORME OK");
			response.sendRedirect("Liste_plateformes");
		}else {
			request.getRequestDispatcher("liste_plateformes.jsp").forward(request, response);				
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
