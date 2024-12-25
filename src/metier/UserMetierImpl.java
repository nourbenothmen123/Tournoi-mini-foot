package metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserMetierImpl implements UserMetierInterface{
@Override
public void addUser(User u) {
//r�cup�rer une connexion � la BD
Connection conn= DBConnexion.getConnection();
try {
// pr�parer la requ�te SQL
PreparedStatement ps = conn.prepareStatement(" insert into user values (0,?,?,?,?)");
//passer les param�tres
ps.setString(1, u.getNom());
ps.setString(2, u.getPrenom());
ps.setString(3, u.getLogin());
ps.setString(4, u.getPassword());
//executer la requ�te
ps.executeUpdate();
} catch (SQLException e) {
//TODO Auto-generated catch block
e.printStackTrace();
}
}

@Override
public List<User> listUsers() {
	// TODO Auto-generated method stub
	//D�finir une liste vide pour stocker les objets "User"
	List<User> users= new ArrayList<User>();
	//r�cup�rer une connexion � la BD
	Connection conn= DBConnexion.getConnection();
	try {
	// pr�parer la requ�te SQL
	PreparedStatement ps = conn.prepareStatement("select * from User");
	// R�cup�rer le r�sultat de la requ�te
	ResultSet rs= ps.executeQuery();
	if (rs!=null)
	{
	//parcourir le r�sultat
	while(rs.next())
	{
	//Construire un objet "User" puis lui affecter l attributs
	// et enfin l'ajouter dans la liste
	User u = new User();
	u.setId(rs.getInt("id"));
	u.setNom(rs.getString("nom"));
	u.setPrenom(rs.getString("prenom"));
	u.setLogin(rs.getString("login"));
	u.setPassword(rs.getString("password"));
	// ajouter l'objet "User" dans la liste
	users.add(u);
	}
	}
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	//retoturner la liste
	return users;
	}

@Override
public User getUserByLoginAndPassword(String l, String p) {
	// TODO Auto-generated method stub
	//r�cup�rer une connexion � la BD
	Connection conn= DBConnexion.getConnection();
	User u= null;
	try {
		// pr�parer la requ�te SQL
		PreparedStatement ps = conn.prepareStatement(" select * from user where login =? and password = ?");
		ps.setString(1, l);
		ps.setString(2, p);
		ResultSet rs= ps.executeQuery();
		if (rs!=null)
		{
		while(rs.next())
		{
		u = new User();
		u.setId(rs.getInt("id"));
		u.setNom(rs.getString("nom"));
		u.setPrenom(rs.getString("prenom"));
		u.setLogin(rs.getString("login"));
		u.setPassword(rs.getString("password"));
		}
		}
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return u;
}
@Override
public void updateUser(User u) {
	//r�cup�rer une connexion � la BD
	Connection conn= DBConnexion.getConnection();
	try {
	// pr�parer la requ�te SQL
	PreparedStatement ps = conn.prepareStatement(" update user set nom= ?, prenom=?, login=?, password =? where id=? ");
	ps.setString(1, u.getNom());
	ps.setString(2, u.getPrenom());
	ps.setString(3, u.getLogin());
	ps.setString(4, u.getPassword());
	ps.setInt(5, u.getId());
	ps.executeUpdate();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	
}

@Override
public void deleteUser(int id) {
	//r�cup�rer une connexion � la BD
	Connection conn= DBConnexion.getConnection();
	try {
		PreparedStatement ps = conn.prepareStatement(" delete from user where id=? ");
				ps.setInt(1, id);
				ps.executeUpdate();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				}

@Override
public User getUserById(int id) {
	//r�cup�rer une connexion � la BD
			Connection conn= DBConnexion.getConnection();
			User u= null;
			try {
			// pr�parer la requ�te SQL
			PreparedStatement ps = conn.prepareStatement(" select * from User where id = ?");
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			if (rs!=null)
			{
			while(rs.next())
			{
			u = new User();
			u.setId(rs.getInt("id"));
			u.setNom(rs.getString("nom"));
			u.setPrenom(rs.getString("prenom"));
			u.setLogin(rs.getString("login"));
			u.setPassword(rs.getString("password"));
			}
			}
			ps.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return u;

			
		}
}