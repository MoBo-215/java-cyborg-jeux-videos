package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Infos;
import models.InfosDAO;
import models.Database;

/**
 * Servlet implementation class Infos_accueil
 */
@WebServlet(name="Infos_accueil",urlPatterns="/admin/Infos_accueil")
public class Infos_accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Infos_accueil() {
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
		
		Infos i = new InfosDAO().getById(1);
		request.setAttribute("i", i);
		
		boolean msgeditok = false;
		if(request.getParameter("petite_phrase")!=null && request.getParameter("grande_phrase_pink")!=null && request.getParameter("grande_phrase_white")!=null && request.getParameter("texte_bouton")!=null && request.getParameter("email")!=null) {
			i.setPetite_phrase(request.getParameter("petite_phrase"));
			i.setGrande_phrase_pink(request.getParameter("grande_phrase_pink"));
			i.setGrande_phrase_white(request.getParameter("grande_phrase_white"));
			i.setTexte_bouton(request.getParameter("texte_bouton"));
			i.setEmail(request.getParameter("email"));
			new InfosDAO().save(i);
			
			msgeditok = true;
			System.out.println("MODIF INFOS ACCUEIL OK");
		}
		
		request.setAttribute("msgeditok", msgeditok);
		request.getRequestDispatcher("infos_accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
