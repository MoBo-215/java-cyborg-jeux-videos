package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Categorie;
import models.CategorieDAO;
import models.Database;

/**
 * Servlet implementation class Modifier_categorie
 */
@WebServlet(name="Modifier_categorie", urlPatterns="/admin/Modifier_categorie")
public class Modifier_categorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_categorie() {
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
		
		int catid = Integer.parseInt(request.getParameter("id"));
		Categorie c = new CategorieDAO().getById(catid);
		request.setAttribute("cat", c);
		
		boolean msgeditok = false;
		if(request.getParameter("nom")!=null && request.getParameter("image_url")!=null) {
			c.setNom(request.getParameter("nom"));
			c.setImage_url(request.getParameter("image_url"));
			new CategorieDAO().save(c);
			
			msgeditok = true;
			System.out.println("MODIF CATEGORIE OK");
		}
		
		request.setAttribute("msgeditok", msgeditok);
		request.getRequestDispatcher("modifier_categorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
