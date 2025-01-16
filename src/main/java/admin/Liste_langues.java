package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Langue;
import models.LangueDAO;
import models.Database;

/**
 * Servlet implementation class Liste_langues
 */
@WebServlet(name="Liste_langues", urlPatterns="/admin/Liste_langues")
public class Liste_langues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_langues() {
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
		
		ArrayList<Langue> ls = new LangueDAO().getAll();
		request.setAttribute("ls", ls);
		
		if(request.getParameter("del")!=null) {
			int lg_id = Integer.parseInt(request.getParameter("del"));
			new LangueDAO().deleteById(lg_id);
			
			System.out.println("DELETE LANGUE OK");
			response.sendRedirect("Liste_langues");
		}else {
			request.getRequestDispatcher("liste_langues.jsp").forward(request, response);				
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
