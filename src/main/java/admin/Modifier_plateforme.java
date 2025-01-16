package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Database;
import models.Plateforme;
import models.PlateformeDAO;

/**
 * Servlet implementation class Modifier_plateforme
 */
@WebServlet(name="Modifier_plateforme", urlPatterns="/admin/Modifier_plateforme")
public class Modifier_plateforme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_plateforme() {
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
		
		int p_id = Integer.parseInt(request.getParameter("id"));
		Plateforme p = new PlateformeDAO().getById(p_id);
		request.setAttribute("p", p);
		
		boolean msgeditok = false;
		if(request.getParameter("nom")!=null) {
			p.setNom(request.getParameter("nom"));
			new PlateformeDAO().save(p);
			
			msgeditok = true;
			System.out.println("MODIF PLATEFORME OK");
		}
		
		request.setAttribute("msgeditok", msgeditok);
		request.getRequestDispatcher("modifier_plateforme.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
