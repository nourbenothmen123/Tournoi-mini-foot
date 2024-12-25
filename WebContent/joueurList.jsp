<%@ page language="java" import="java.util.ArrayList, metier.Joueur"%>
<%@ include file="accueil.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des joueurs</title>
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
		<h1>Liste des joueurs</h1>
		<hr>
		<table class="table table-bordered custom-table">
			<thead class="thead-light c1">
				<tr>
					<th scope="col">Nom joueur</th>
					<th scope="col">Prenom joueur</th>
					<th scope="col">Date de naissance</th>
					<th scope="col">Pays</th>
					<th scope="col">Salaire</th>
					<th scope="col">Nombre de matchs joués</th>
					<th scope="col">État</th>
					<th scope="col">Equipe</th>
					<th scope="col" colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList joueurs = (ArrayList) session.getAttribute("listOfJoueursEquipes");
					if (joueurs != null) {
						for (int i = 0; i < joueurs.size(); i++) {
							out.println("<tr>");
							out.println("<td>" + ((Joueur) joueurs.get(i)).getNomj() + "</td>");
							out.println("<td>" + ((Joueur) joueurs.get(i)).getPrenomj() + "</td>");
							out.println("<td>" + ((Joueur) joueurs.get(i)).getDatenaissance() + "</td>");
							out.println("<td>" + ((Joueur) joueurs.get(i)).getPays() + "</td>");
							out.println("<td>" + ((Joueur) joueurs.get(i)).getSalaire() + "</td>");
							out.println("<td>" + ((Joueur) joueurs.get(i)).getNbrmatchjoué() + "</td>");
							out.println("<td>" + ((Joueur) joueurs.get(i)).getEtat() + "</td>");
							out.println("<td>" + ((Joueur) joueurs.get(i)).getNomequipe()+"</td>");
							out.print("<td><a   class='btn btn-warning' href='JoueurEditionController?id=" + ((Joueur) joueurs.get(i)).getId() + "&mode=Edition'>Modifier</a></td>");
							out.println("<td><a class='btn btn-danger' href='JoueurEditionController?id=" + ((Joueur) joueurs.get(i)).getId() + "&mode=Suppression' onclick='return confirm(\"Voulez-vous vraiment supprimer cet utilisateur ?\")'>Supprimer</a></td>");
							out.println("</tr>");
						}
					}
				%>
			</tbody>
		</table>
		<div id="conteneur">
		<a class="btn btn-success" href="joueurForm.jsp">Ajouter Joueur</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
