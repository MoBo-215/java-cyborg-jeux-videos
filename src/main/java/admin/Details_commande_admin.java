package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Commande;
import models.CommandeDAO;
import models.Database;
import models.Detail;
import models.DetailDAO;

/**
 * Servlet implementation class Details_commande
 */
@WebServlet(name="Details_commande", urlPatterns="/admin/Details_commande_admin")
public class Details_commande_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details_commande_admin() {
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
		
		int cmd_id = Integer.parseInt(request.getParameter("id"));
		Commande cmd = new CommandeDAO().getById(cmd_id);
		ArrayList<Detail> details_cmd = new DetailDAO().getAllByCommande(cmd_id);
		
		request.setAttribute("cmd", cmd);
		request.setAttribute("details_cmd", details_cmd);
		
		request.getRequestDispatcher("details_commande_admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
