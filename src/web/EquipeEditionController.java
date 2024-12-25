package web;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class EquipeEditionController
 */
@WebServlet("/EquipeEditionController")
public class EquipeEditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EquipeMetierInterface metier = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipeEditionController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
 	public void init(ServletConfig config) throws ServletException {
 		// instancier le m�tier
 		metier = new EquipeMetierImpl();
 	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// R�cup�rer les param�tres
		String ideq = request.getParameter("idEq");
		String mode = request.getParameter("mode");

		// lire le tableau des utilisateurs stock� dans la session
		HttpSession session = request.getSession(true);
		// R�cup�rer le tableau des users de la session
		List<Equipe> equipesStore = (ArrayList<Equipe>) session.getAttribute("listOfEquipes");

		// g�rer le mode "Edition"
		if (mode != null && mode.equals("Edition")) {
			
			Equipe e = metier.getEquipeById(Integer.parseInt(ideq));
			// passer l'objet trouv� comme attribut dans la requ�te
			request.setAttribute("equipe", e);
			// passer au formulaire
			request.getRequestDispatcher("equipeForm.jsp").forward(request, response);
		}
		// g�rer le mode "Suppression"
		if (mode != null && mode.equals("Suppression")) {

			int index = Integer.parseInt(ideq);
			
			// Supprimer dans la base de donn�es
			metier.deleteEquipe(index);

			// Charger la liste des joueurs;
		    equipesStore = metier.listEquipe();
			// Mettre � jour dans le session
			session.setAttribute("listOfEquipes", equipesStore);
			// passer � la liste
			request.getRequestDispatcher("equipeList.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList erreurs = new ArrayList();
		String ideq = request.getParameter("idEq");
		String nomeq = request.getParameter("nomequipe");
		String datecrea= request.getParameter("datecr�ation");
		String entraineur = request.getParameter("entraineur");
		// Contr�ler les valeurs saisies

		if (nomeq == null || nomeq.equals(""))
			erreurs.add("Veuillez remplir le champ nom equipe");

		if (datecrea == null || datecrea.equals(""))
			erreurs.add("Veuillez remplir le champ date cr�ation");

		if (entraineur == null || entraineur.equals(""))
			erreurs.add("Veuillez remplir le champ entraineur");
		if (erreurs.size()!=0)
		{
			request.setAttribute("err", erreurs);
			Equipe eq=new Equipe(0,nomeq,datecrea,entraineur);
			request.setAttribute("equipe", eq);
		}
		else
			//la saisie est correcte
		{
			HttpSession session = request.getSession(true);
			List<Equipe> equipesStore = (ArrayList<Equipe>) session.getAttribute("listOfEquipes");
			// Mode Ajout
			if (ideq != null && ideq.equals("0")) {
				// Cr�er une instance "Joueur" en lui passant une valeur pour l'id et les champs
				// r�cup�r�s
				// Ajouter le nouvel objet dans la base de donn�es
				
				Equipe eq = new Equipe(0,nomeq,datecrea,entraineur);
				metier.addEquipe(eq);
			}
			// Mode Edition
			else {
				// Modifier l'objet en question
				Equipe eq=new Equipe(Integer.parseInt(ideq),nomeq,datecrea,entraineur);
				metier.updateEquipe(eq);
			}
			// Charger la liste des joueurs;
			equipesStore = metier.listEquipe();

			// passer le tableau dans le session 
			session.setAttribute("listOfEquipes", equipesStore);
			// passer � la vue de liste des utilisateurs
			request.getRequestDispatcher("equipeList.jsp").forward(request, response);

			
		}
	}

}
