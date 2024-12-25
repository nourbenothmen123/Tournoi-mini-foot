package metier;

import java.util.List;

public interface EquipeMetierInterface {
	//Ajouter un objet "Equipe"
			public void addEquipe(Equipe e);
			//Retourner la liste de tous les objets "Equipe"
			public List<Equipe> listEquipe();
			//Mettre à jour un objet "Equipe" déjà existant
			public void updateEquipe(Equipe e);
			//Supprimer un objet "Equipe" identifié par son "id"
			public void deleteEquipe(int id);
			public Equipe getEquipeById(int id);

}
