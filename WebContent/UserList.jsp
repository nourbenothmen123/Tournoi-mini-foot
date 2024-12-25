<%@page language="java" import="java.util.ArrayList, metier.User"%>
<%@include file="accueil.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des utilisateurs</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
    .custom-table {
        background-color: white;
    }
    tbody
    {color:black;}
    thead{color:red;}
    h1{color:white;text-align:center;font-style:italic;
    }
   #conteneur { 
  
 text-align:center; 
}
</style>
</head>
<body>
	<div class="container">
		<h1>Liste des Utilisateurs</h1>
		<hr>
		<table class="table table-bordered custom-table">
			<thead class="thead-light c1">
				<tr>
				<th>Nom:</th>
				<th>Prenom:</th>
				<th>Login:</th>
				<th>Mot de passe:</th>
				<th colspan="2">Actions:</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList users = (ArrayList) session.getAttribute("listOfUsers");
					if (users != null) {
						for (int i = 0; i < users.size(); i++) 
						 {
							out.println("<tr>");
							out.println("<td>" + ((User) users.get(i)).getNom() + "</td>");
							out.println("<td>" +  ((User) users.get(i)).getPrenom() + "</td>");
							out.println("<td>" + ((User) users.get(i)).getLogin() + "</td>");
							out.println("<td>" + ((User) users.get(i)).getPassword() + "</td>");
							out.print("<td>  <a class='btn btn-warning' href ='UserEditionController?id="+((User) users.get(i)).getId()+"&mode=Edition"+"'>Modifier</a> </td>");
							out.println("<td>  <a class='btn btn-danger' href ='UserEditionController?id="+((User) users.get(i)).getId()+"&mode=Suppression"+"'  onclick='return confirm(\"Voulez vous vraiment supprimer cet utilisateur ?\")'>Supprimer</a> </td>");
							
						}
					}
				%>
			</tbody>
		</table>
		<div id="conteneur">
		<a class="btn btn-success" href="UserForm.jsp">Ajouter Utilisateur</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>