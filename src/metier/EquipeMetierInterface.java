package metier;

import java.util.List;

public interface EquipeMetierInterface {
	//Ajouter un objet "Equipe"
			public void addEquipe(Equipe e);
			//Retourner la liste de tous les objets "Equipe"
			public List<Equipe> listEquipe();
			//Mettre � jour un objet "Equipe" d�j� existant
			public void updateEquipe(Equipe e);
			//Supprimer un objet "Equipe" identifi� par son "id"
			public void deleteEquipe(int id);
			public Equipe getEquipeById(int id);

}
