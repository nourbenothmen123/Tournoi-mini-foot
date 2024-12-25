<%@ page language="java" import="java.util.ArrayList, metier.Equipe"%>
<%@ include file="accueil.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Equipes</title>
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
		<h1>Liste Des Equipes</h1>
		<hr>
		<table class="table table-bordered custom-table">
			<thead class="thead-light ">
				<tr>
					<th scope="col">Nom Equipe</th>
					<th scope="col">Date création</th>
					<th scope="col">Entraineur</th>
					<th scope="col" colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList equipes = (ArrayList) session.getAttribute("listOfEquipes");
					if (equipes != null) {
						for (int i = 0; i < equipes.size(); i++) {
							out.println("<tr>");
							out.println("<td>" + ((Equipe) equipes.get(i)).getNomequipe() + "</td>");
							out.println("<td>" + ((Equipe) equipes.get(i)).getDatecreation() + "</td>");
							out.println("<td>" + ((Equipe) equipes.get(i)).getEntraineur() + "</td>");
							out.print("<td><a   class='btn btn-warning' href='EquipeEditionController?idEq=" + ((Equipe) equipes.get(i)).getIdEq() + "&mode=Edition'>Modifier</a></td>");
							out.println("<td><a class='btn btn-danger' href='EquipeEditionController?idEq=" + ((Equipe) equipes.get(i)).getIdEq() + "&mode=Suppression' onclick='return confirm(\"Voulez-vous vraiment supprimer cet utilisateur ?\")'>Supprimer</a></td>");
							out.println("</tr>");
						}
					}
				%>
			</tbody>
		</table>
		<div id="conteneur">
		<a class="btn btn-success" href="equipeForm.jsp">Ajouter Equipe</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
