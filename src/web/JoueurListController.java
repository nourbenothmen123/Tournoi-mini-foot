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

import metier.JoueurMetierInterface;
import metier.Joueur;
import metier.JoueurMetierImpl;

/**
 * Servlet implementation class JoueurListController
 */
@WebServlet("/JoueurListController")
public class JoueurListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// D�clarer un objet "m�tier"
			JoueurMetierInterface metier =null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoueurListController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// instancier le m�tier
		metier =new JoueurMetierImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Joueur> joueurs1 = metier.ListJoueurEquipe();
		//R�cup�rer une session			
		HttpSession session =request.getSession(true);
		session.setAttribute("listOfJoueursEquipes", joueurs1);
		
		request.getRequestDispatcher("joueurList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
