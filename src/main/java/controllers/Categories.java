package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Categorie;
import models.CategorieDAO;
import models.Database;
import models.DeveloppeurDAO;
import models.Jeu;
import models.JeuDAO;

/**
 * Servlet implementation class Categories
 */
@WebServlet("/Categories")
public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categories() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.connect();
		
		ArrayList<Categorie> cats = new CategorieDAO().getAll();
		ArrayList<Jeu> jeux_bs = new JeuDAO().getAllOrderByBestSellingGames();
		request.setAttribute("cats", cats);
		request.setAttribute("jeux_bs", jeux_bs);
		
		DeveloppeurDAO ddao = new DeveloppeurDAO();
		CategorieDAO cdao = new CategorieDAO();
		request.setAttribute("ddao", ddao);
		request.setAttribute("cdao", cdao);
		
		request.getRequestDispatcher("/categories.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
