package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Categorie;
import models.CategorieDAO;
import models.Database;
import models.Infos;
import models.InfosDAO;
import models.JeuDAO;
/**
 * Servlet implementation class index
 */
@WebServlet(name="index", urlPatterns="/admin/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
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
		
		JeuDAO jdao = new JeuDAO();
		ArrayList<Integer> nb_prods = jdao.getCountJeuxByAllCategories();
		ArrayList<Integer> nb_jv_vendus = jdao.getCountJeuxVendusByAllCategories();
		
		System.out.println(nb_prods);
		System.out.println(nb_jv_vendus);

		request.setAttribute("nb_prods", nb_prods);
		request.setAttribute("nb_jv_vendus", nb_jv_vendus);
		
		CategorieDAO cdao = new CategorieDAO();		
		ArrayList<Categorie> cats = cdao.getAll();
		request.setAttribute("cats", cats);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
