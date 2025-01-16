package admin;

import java.io.IOException;
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
 * Servlet implementation class Modifier_developpeur
 */
@WebServlet(name="Modifier_developpeur", urlPatterns="/admin/Modifier_developpeur")
public class Modifier_developpeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_developpeur() {
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
		
		int d_id = Integer.parseInt(request.getParameter("id"));
		Developpeur d = new DeveloppeurDAO().getById(d_id);
		request.setAttribute("d", d);
		
		boolean msgeditok = false;
		if(request.getParameter("nom")!=null) {
			d.setNom(request.getParameter("nom"));
			new DeveloppeurDAO().save(d);
			
			msgeditok = true;
			System.out.println("MODIF DEVELOPPEUR OK");
		}
		
		request.setAttribute("msgeditok", msgeditok);
		request.getRequestDispatcher("modifier_developpeur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
