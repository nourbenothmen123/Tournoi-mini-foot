package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Equipe;
import metier.EquipeMetierImpl;
import metier.EquipeMetierInterface;

/**
 * Servlet implementation class EquipeListController
 */
@WebServlet("/EquipeListController")
public class EquipeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Déclarer un objet "métier"
	EquipeMetierInterface metier =null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipeListController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
 		// instancier le métier
 		metier =new EquipeMetierImpl();
 	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Equipe> equipes = metier.listEquipe();
		//Récupérer une session			
		HttpSession session =request.getSession(true);
		session.setAttribute("listOfEquipes", equipes);
		request.getRequestDispatcher("equipeList.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
