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

/**
 * Servlet implementation class Liste_cmds_expediees
 */
@WebServlet(name="Liste_cmds_expediees", urlPatterns="/admin/Liste_cmds_expediees")
public class Liste_cmds_expediees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_cmds_expediees() {
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
		
		ArrayList<Commande> cmds = new CommandeDAO().getAllCmdsExpediees();
		request.setAttribute("cmds", cmds);
		
		if(request.getParameter("del")!=null) {
			int cmd_id = Integer.parseInt(request.getParameter("del"));
			new CommandeDAO().deleteById(cmd_id);
			
			System.out.println("DELETE COMMANDE EXPEDIEE OK");
			response.sendRedirect("Liste_cmds_expediees");
		}else {
			request.getRequestDispatcher("liste_cmds_expediees.jsp").forward(request, response);			
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
