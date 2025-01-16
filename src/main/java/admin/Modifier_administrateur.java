package admin;

import java.io.IOException;
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
 * Servlet implementation class Modifier_administrateur
 */
@WebServlet(name="Modifier_administrateur",urlPatterns="/admin/Modifier_administrateur")
public class Modifier_administrateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_administrateur() {
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
		
		int admin_id = Integer.parseInt(request.getParameter("id"));
		Administrateur admin = new AdministrateurDAO().getById(admin_id);
		request.setAttribute("admin", admin);
		
		boolean msgeditok = false;
		if(request.getParameter("nom")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null) {
			admin.setNom(request.getParameter("nom"));
			admin.setEmail(request.getParameter("email"));
			admin.setMot_de_passe(request.getParameter("password"));
			new AdministrateurDAO().save(admin);
			
			msgeditok = true;
			System.out.println("MODIF ADMIN OK");
		}
		
		request.setAttribute("msgeditok", msgeditok);
		request.getRequestDispatcher("modifier_administrateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
