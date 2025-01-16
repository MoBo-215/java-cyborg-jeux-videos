package controllers;

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
import models.DeveloppeurDAO;
import models.JeuDAO;
import models.Panier;

/**
 * Servlet implementation class Details_commande
 */
@WebServlet("/Details_commande")
public class Details_commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details_commande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		int cmd_id = Integer.parseInt(request.getParameter("id"));
		Commande c = new CommandeDAO().getById(cmd_id);
		ArrayList<Detail> details_cmd = new DetailDAO().getAllByCommande(cmd_id);
		request.setAttribute("c", c);
		request.setAttribute("details_cmd", details_cmd);
		
		DeveloppeurDAO ddao = new DeveloppeurDAO();
		JeuDAO jdao = new JeuDAO();
		request.setAttribute("ddao", ddao);
		request.setAttribute("jdao", jdao);
		
		request.getRequestDispatcher("details_commande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
