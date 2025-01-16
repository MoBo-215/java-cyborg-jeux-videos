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
import models.Jeu;
import models.JeuDAO;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Liste_commandes
 */
@WebServlet(name="Liste_commandes_user", urlPatterns="/admin/Liste_commandes_user")
public class Liste_commandes_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_commandes_user() {
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
		
		ArrayList<Commande> cmds = new ArrayList<Commande>();
		
		if(request.getParameter("id")!=null) {
			int u_id = Integer.parseInt(request.getParameter("id"));
			Utilisateur u = new UtilisateurDAO().getById(u_id);
			request.setAttribute("u", u);
			cmds = new CommandeDAO().getAllByUtilisateur(u_id);			
		}else {
			cmds = new CommandeDAO().getAll();			
		}
		request.setAttribute("cmds", cmds);
		
		if(request.getParameter("del")!=null) {
			int cmd_id = Integer.parseInt(request.getParameter("del"));
			Commande c = new CommandeDAO().getById(cmd_id);
			System.out.println(c.getEtat());
			
			if(c.getEtat()!="Expédiée") {
				ArrayList<Detail> list_details = new DetailDAO().getAllByCommande(cmd_id);			
				for(int i=0;i<list_details.size();i++) {
					Detail d = list_details.get(i);
	
					Jeu p = new JeuDAO().getById(d.getJeu_id());
					int nb = p.getStock()+d.getNb();
					p.setStock(nb);
					new JeuDAO().save(p);
					System.out.println("UPDATE STOCK JEU OK");
				}
			}
			
			new CommandeDAO().deleteById(cmd_id);
			
			System.out.println("DELETE COMMANDE OK");
			response.sendRedirect("Liste_commandes_user");
		}else {
			request.getRequestDispatcher("liste_commandes_user.jsp").forward(request, response);			
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
