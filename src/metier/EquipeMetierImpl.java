package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeMetierImpl implements EquipeMetierInterface{

	@Override
	public void addEquipe(Equipe e) {
		Connection conn= DBConnexion.getConnection();
		try {
		// préparer la requête SQL
		PreparedStatement ps = conn.prepareStatement(" insert into equipe values (0,?,?,?)");
		//passer les paramètres
		ps.setString(1, e.getNomequipe());
		ps.setString(2, e.getDatecreation());
		ps.setString(3, e.getEntraineur());;
		//executer la requête
		ps.executeUpdate();
		} catch (SQLException ex) {
		ex.printStackTrace();
		}
		
		
	}

	@Override
	public List<Equipe> listEquipe() {
		List<Equipe> equipes= new ArrayList<Equipe>();
		//récupérer une connexion à la BD
		Connection conn= DBConnexion.getConnection();
		try {
		//préparer la requête SQL
		PreparedStatement ps = conn.prepareStatement(" select * from equipe");
		//Récupérer le résultat de la requête
		ResultSet rs= ps.executeQuery();
		if (rs!=null)
		{
		//parcourir le résultat
		while(rs.next())
		{
		//Construire un objet "User" puis lui affecter les attributs
		//et enfin l'ajouter dans la liste
		Equipe eq = new Equipe();
		eq.setIdEq(rs.getInt("idEq"));
		eq.setNomequipe(rs.getString("nomequipe"));
		eq.setDatecreation(rs.getString("datecréation"));
		eq.setEntraineur(rs.getString("entraineur"));
		
		//ajouter l'objet "Equipe" dans la liste
		equipes.add(eq);
		}
		}
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		//retoturner la liste
		return equipes;
		
	}

	@Override
	public void updateEquipe(Equipe e) {
		//récupérer une connexion à la BD
				Connection conn= DBConnexion.getConnection();
				try {
				// préparer la requête SQL
				PreparedStatement ps = conn.prepareStatement(" update equipe set nomequipe= ?, datecréation=?,entraineur=? where idEq=?");
				ps.setString(1, e.getNomequipe());
				ps.setString(2, e.getDatecreation());
				ps.setString(3, e.getEntraineur());
				ps.setInt(4, e.getIdEq());
				ps.executeUpdate();
				} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
	}

	@Override
	public void deleteEquipe(int id) {
		Connection conn= DBConnexion.getConnection();
		try {
		// préparer la requête SQL
			PreparedStatement ps = conn.prepareStatement(" delete from equipe where idEq=? ");
					ps.setInt(1, id);
					ps.executeUpdate();
					} catch (SQLException e) {
					e.printStackTrace();
					}
		
	}

	@Override
	public Equipe getEquipeById(int idEq) {
		//récupérer une connexion à la BD
				Connection conn= DBConnexion.getConnection();
				Equipe e= null;
				try {
				// préparer la requête SQL
				PreparedStatement ps = conn.prepareStatement(" select * from equipe where idEq = ?");
				ps.setInt(1,idEq);
				ResultSet rs= ps.executeQuery();
				if (rs!=null)
				{
				while(rs.next())
				{
				e = new Equipe();
				e.setIdEq(rs.getInt("idEq"));
				e.setNomequipe(rs.getString("nomequipe"));
				e.setDatecreation(rs.getString("datecréation"));
				e.setEntraineur(rs.getString("entraineur"));
				}
				}
				ps.close();
				} catch (SQLException ex) {
				ex.printStackTrace();
				}
				return e;
	
	}
}
	