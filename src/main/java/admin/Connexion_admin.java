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
 * Servlet implementation class Connexion_admin
 */
@WebServlet(name="Connexion_admin", urlPatterns="/admin/Connexion_admin")
public class Connexion_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		boolean connected = false;
		boolean messageconnexionno = false;
		if(request.getParameter("bconnexion")!=null){
			String email = request.getParameter("cemail");
			String password = request.getParameter("cpassword");
			
			Administrateur u = new AdministrateurDAO().connexion(email, password);
			if(u==null) {
				System.out.println("CONNEXION NO");
				messageconnexionno = true;
			}else {
				HttpSession adminSession = request.getSession(true);
				adminSession.setAttribute("adminid", u.getId());
				adminSession.setAttribute("adminnom", u.getNom());
				adminSession.setAttribute("isCo", "yes");
				
				System.out.println("CONNEXION ADMIN OK");
				connected = true;
				response.sendRedirect("index");
			}
		}
		request.setAttribute("messageconnexionno", messageconnexionno);
		
		if(connected==false) {
			request.getRequestDispatcher("connexion_admin.jsp").forward(request, response);
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
