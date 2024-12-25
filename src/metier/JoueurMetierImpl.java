package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoueurMetierImpl implements JoueurMetierInterface{

	@Override
	public void addJoueur(Joueur j) {
		Connection conn= DBConnexion.getConnection();
		try {
		// préparer la requête SQL
		PreparedStatement ps = conn.prepareStatement(" insert into joueur values (0,?,?,?,?,?,?,?,?)");
		//passer les paramètres
		ps.setString(1, j.getNomj());
		ps.setString(2, j.getPrenomj());
		ps.setString(3, j.getDatenaissance());
		ps.setString(4, j.getPays());
		ps.setInt(5,j.getSalaire());
		ps.setInt(6, j.getNbrmatchjoué());
		ps.setString(7, j.getEtat());
		ps.setInt(8, j.getIdEquipe());
		//executer la requête
		ps.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}

	@Override
	public List<Joueur> listJoueur() {
		List<Joueur> joueurs= new ArrayList<Joueur>();
		//récupérer une connexion à la BD
		Connection conn= DBConnexion.getConnection();
		try {
		//préparer la requête SQL
		PreparedStatement ps = conn.prepareStatement(" select * from joueur");
		//Récupérer le résultat de la requête
		ResultSet rs= ps.executeQuery();
		if (rs!=null)
		{
		//parcourir le résultat
		while(rs.next())
		{
		//Construire un objet "User" puis lui affecter les attributs
		//et enfin l'ajouter dans la liste
		Joueur j = new Joueur();
		j.setId(rs.getInt("id"));
		j.setNomj(rs.getString("nomj"));
		j.setPrenomj(rs.getString("prenomj"));
		j.setDatenaissance(rs.getString("datenaissance"));
		j.setPays(rs.getString("pays"));
		j.setSalaire(rs.getInt("salaire"));
		j.setNbrmatchjoué(rs.getInt("nbrmatchjoué"));
		j.setEtat(rs.getString("etat"));
		j.setIdEquipe(rs.getInt("idEq"));
		
		//ajouter l'objet "User" dans la liste
		joueurs.add(j);
		}
		}
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		//retoturner la liste
		return joueurs;
		}
		

	@Override
	public void updateJoueur(Joueur j) {
		//récupérer une connexion à la BD
		Connection conn= DBConnexion.getConnection();
		try {
		// préparer la requête SQL
		PreparedStatement ps = conn.prepareStatement(" update joueur set nomj= ?, prenomj=?,datenaissance=?,pays=?,salaire=?,nbrmatchjoué=?,etat=?,idEq=? where id=?");
		ps.setString(1, j.getNomj());
		ps.setString(2, j.getPrenomj());
		ps.setString(3, j.getDatenaissance());
		ps.setString(4, j.getPays());
		ps.setInt(5,j.getSalaire());
		ps.setInt(6, j.getNbrmatchjoué());
		ps.setString(7, j.getEtat());
		ps.setInt(8, j.getIdEquipe());
		ps.setInt(9, j.getId());
		ps.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
	}

	@Override
	public void deleteJoueur(int id) {
		Connection conn= DBConnexion.getConnection();
		try {
		// préparer la requête SQL
			PreparedStatement ps = conn.prepareStatement(" delete from joueur where id=? ");
					ps.setInt(1, id);
					ps.executeUpdate();
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
		
	}

	@Override
	public Joueur getJoueurById(int id) {
		//récupérer une connexion à la BD
		Connection conn= DBConnexion.getConnection();
		Joueur j= null;
		try {
		// préparer la requête SQL
		PreparedStatement ps = conn.prepareStatement(" select * from joueur where id = ?");
		ps.setInt(1,id);
		ResultSet rs= ps.executeQuery();
		if (rs!=null)
		{
		while(rs.next())
		{
		j = new Joueur();
		j.setId(rs.getInt("id"));
		j.setNomj(rs.getString("nomj"));
		j.setPrenomj(rs.getString("prenomj"));
		j.setDatenaissance(rs.getString("datenaissance"));
		j.setPays(rs.getString("pays"));
		j.setNbrmatchjoué(rs.getInt("nbrmatchjoué"));
		j.setEtat(rs.getString("etat"));
		j.setSalaire(rs.getInt("salaire"));
		j.setIdEquipe(rs.getInt("idEq"));
		}
		}
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return j;
	}

	@Override
	public List<Joueur> ListJoueurEquipe() {
		List<Joueur> joueurs1= new ArrayList<Joueur>();
		//récupérer une connexion à la BD
		Connection conn= DBConnexion.getConnection();
		try {
		//préparer la requête SQL
		PreparedStatement ps = conn.prepareStatement(" select id,nomj,prenomj,datenaissance,pays,salaire,nbrmatchjoué,etat,j.idEq,nomequipe from joueur j,equipe e where j.ideq=e.ideq");
		//Récupérer le résultat de la requête
		ResultSet rs= ps.executeQuery();
		if (rs!=null)
		{
		//parcourir le résultat
		while(rs.next())
		{
		//Construire un objet "User" puis lui affecter les attributs
		//et enfin l'ajouter dans la liste
		Joueur j = new Joueur();
		j.setId(rs.getInt("id"));
		j.setNomj(rs.getString("nomj"));
		j.setPrenomj(rs.getString("prenomj"));
		j.setDatenaissance(rs.getString("datenaissance"));
		j.setPays(rs.getString("pays"));
		j.setSalaire(rs.getInt("salaire"));
		j.setNbrmatchjoué(rs.getInt("nbrmatchjoué"));
		j.setEtat(rs.getString("etat"));
		j.setIdEquipe(rs.getInt("idEq"));
		j.setNomequipe(rs.getString("nomequipe"));
		
		//ajouter l'objet "User" dans la liste
		joueurs1.add(j);
		}
		}
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		//retoturner la liste
		return joueurs1;
	}
}
