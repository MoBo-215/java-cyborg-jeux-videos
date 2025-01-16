package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Database;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		UtilisateurDAO udao = new UtilisateurDAO();
		
		boolean messageinscriptionok = false;
		if(request.getParameter("binscription")!=null) {
			String password = request.getParameter("ipassword");
			String nom = request.getParameter("inom");
			String email = request.getParameter("iemail");
			Boolean isban = false;
			Boolean isadmin = false;
			
			Utilisateur u = new Utilisateur(nom,email,password,isban,isadmin);
			udao.save(u);
			System.out.println("INSCRIPTION OK");
			messageinscriptionok = true;
		}
		request.setAttribute("messageinscriptionok", messageinscriptionok);
		
		boolean connected = false;
		boolean messageconnexionno = false;
		if(request.getParameter("bconnexion")!=null){
			String email = request.getParameter("cemail");
			String password = request.getParameter("cpassword");
			
			Utilisateur u = udao.connexion(email, password);
			if(u==null || u.getIsban()==true) {
				System.out.println("CONNEXION NO");
				messageconnexionno = true;
			}else {
				System.out.println("CONNEXION OK");
				HttpSession session = request.getSession(true);
				session.setAttribute("userid", u.getId());
				session.setAttribute("usernom", u.getNom());
				session.setAttribute("useremail", u.getEmail());
				session.setAttribute("isConnected", true);
				connected = true;
				response.sendRedirect("Index");
			}
		}
		request.setAttribute("messageconnexionno", messageconnexionno);
		
		if(connected==false) {
			request.getRequestDispatcher("/connexion.jsp").forward(request, response);
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
