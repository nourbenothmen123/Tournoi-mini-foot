package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Joueur;
import metier.JoueurMetierImpl;
import metier.JoueurMetierInterface;
import metier.User;
import metier.UserMetierImpl;
import metier.UserMetierInterface;

/**
 * Servlet implementation class JoueurEditionController
 */
@WebServlet("/JoueurEditionController")
public class JoueurEditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JoueurMetierInterface metier = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoueurEditionController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		// instancier le métier
		metier = new JoueurMetierImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// tableau pour stocker les erreurs éventuelles
				ArrayList erreurs = new ArrayList();

				// Récupérer les paramètres du formulaire
				String id = request.getParameter("id");
				String nom = request.getParameter("nomj");
				String prenom = request.getParameter("prenomj");
				String datenaiss = request.getParameter("datenaiss");
				String pays = request.getParameter("pays");
				String salaire =request.getParameter("salaire");
				String nbrmtchj = request.getParameter("nbrmtchj");
				String etat =request.getParameter("etat");
				String idEq=request.getParameter("idEquipe");
				// Contrôler les valeurs saisies
				if (nom == null || nom.equals(""))
					erreurs.add("Veuillez remplir le champ nom");

				if (prenom == null || prenom.equals(""))
					erreurs.add("Veuillez remplir le champ prenom");

				if (datenaiss == null || datenaiss.equals(""))
					erreurs.add("Veuillez remplir le champ date");

				if (pays == null || pays.equals(""))
					erreurs.add("Veuillez remplir le champ pays");

				if (salaire == null)
					erreurs.add("Veuillez remplir le champ salaire");

				if (nbrmtchj ==null)
					erreurs.add("Veuillez remplir le champ nombre match joué");
				
				if (etat == null || etat.equals(""))
					erreurs.add("Veuillez remplir le champ etat");
				
				if (idEq == null || idEq.equals(""))
					erreurs.add("Veuillez remplir le champ idEquipe");
				
				

				if (erreurs.size() != 0) {
					// en cas d'existence de champs nulls
					request.setAttribute("err", erreurs);
					// renvoyer les paramètres du formulaire s'ils existent sous forme
					// d'un objet 'Joueur' passé comme attribut nommé "joueur"
					Joueur jr = new Joueur(0, nom, prenom, datenaiss, pays,Integer.parseInt(salaire),etat,Integer.parseInt(nbrmtchj),Integer.parseInt(idEq));
					request.setAttribute("joueur", jr);

					// retourner au formulaire
					request.getRequestDispatcher("joueurForm.jsp").forward(request, response);
				} else // La saisie est correcte
				{

					// lire à partir de la session ( portée session)
					HttpSession session = request.getSession(true);
					// Récupérer le tableau des joueurs de la session
					List<Joueur> joueursStore = (ArrayList<Joueur>) session.getAttribute("listOfJoueursEquipes");

					// Mode Ajout
					if (id != null && id.equals("0")) {
						
						// Créer une instance "Joueur" en lui passant une valeur pour l'id et les champs
						// récupérés
						// Ajouter le nouvel objet dans la base de données
						
						Joueur jr = new Joueur(0, nom, prenom, datenaiss, pays,Integer.parseInt(salaire),etat,Integer.parseInt(nbrmtchj),Integer.parseInt(idEq));
						metier.addJoueur(jr);
						
					}
					// Mode Edition
					else {
						// Modifier l'objet en question
						Joueur jr = new Joueur(Integer.parseInt(id), nom, prenom, datenaiss, pays,Integer.parseInt(salaire),etat,Integer.parseInt(nbrmtchj),Integer.parseInt(idEq));
						metier.updateJoueur(jr);

					}

					// Charger la liste des joueurs;
					joueursStore = metier.ListJoueurEquipe();

					// passer le tableau dans le session 
					session.setAttribute("listOfJoueursEquipes", joueursStore);
					// passer à la vue de liste des utilisateurs
					request.getRequestDispatcher("joueurList.jsp").forward(request, response);

				}
				}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// Récupérer les paramètres
				String id = request.getParameter("id");
				String mode = request.getParameter("mode");

				// lire le tableau des utilisateurs stocké dans la session
				HttpSession session = request.getSession(true);
				// Récupérer le tableau des users de la session
				List<Joueur> joueursStore = (ArrayList<Joueur>) session.getAttribute("listOfJoueursEquipes");

				// gérer le mode "Edition"
				if (mode != null && mode.equals("Edition")) {
					
					Joueur j = metier.getJoueurById(Integer.parseInt(id));
					// passer l'objet trouvé comme attribut dans la requête
					request.setAttribute("joueur", j);
					// passer au formulaire
					request.getRequestDispatcher("joueurForm.jsp").forward(request, response);
				}
				// gérer le mode "Suppression"
				if (mode != null && mode.equals("Suppression")) {
					int index = Integer.parseInt(id);
					
					// Supprimer dans la base de données
					metier.deleteJoueur(index);

					// Charger la liste des joueurs;
				    joueursStore = metier.ListJoueurEquipe();
					// Mettre à jour dans le session
					session.setAttribute("listOfJoueursEquipes", joueursStore);
					// passer à la liste
					request.getRequestDispatcher("joueurList.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
