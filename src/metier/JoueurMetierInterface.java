package metier;

import java.util.List;

public interface JoueurMetierInterface {
	//Ajouter un objet "Joueur"
		public void addJoueur(Joueur j);
		//Retourner la liste de tous les objets "Joueur"
		public List<Joueur> listJoueur();
		//Mettre à jour un objet "Joueur" déjà existant
		public void updateJoueur(Joueur j);
		//Supprimer un objet "Joueur" identifié par son "id"
		public void deleteJoueur(int id);
		public Joueur getJoueurById(int id);
		public List<Joueur> ListJoueurEquipe();
}
