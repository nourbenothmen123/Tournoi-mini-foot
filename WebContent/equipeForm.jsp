<%@ page language="java" import="java.util.ArrayList, metier.Equipe "%>
<%@include file="accueil.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fiche Equipe</title>
<!-- Ajout des liens vers les fichiers CSS de Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
    .erreur {
        color: red;
    }
</style>
</head>
<body>
<div class="container">
    <h1 class="mt-4">Veuillez saisir les propriétés de l'equipe...</h1>
    <hr>

    <%
    // Gestion des erreurs
    ArrayList erreurs = (ArrayList) request.getAttribute("err");
    if (erreurs != null) {
        %>
        <div class="erreur">
            <ul>
                <% for (int i = 0; i < erreurs.size(); i++) { %>
                    <li><%= (String) erreurs.get(i) %></li>
                <% } %>
            </ul>
        </div>
        <%
    }

    // Gestion de la saisie d'un joueur en cours
    String nomequipe = null;
    String entraineur = null;
    String datecréation = null;
    int idEq = 0;
    Equipe e = (Equipe) request.getAttribute("equipe");
    if (e != null) {
    	idEq=e.getIdEq();
    	nomequipe=e.getNomequipe();
    	datecréation=e.getDatecreation();
    	entraineur=e.getEntraineur();	
    }

    // Correction des valeurs nulles
    if (nomequipe == null) nomequipe = "";
    if (datecréation == null) datecréation = "";
    if (entraineur == null) entraineur = "";
    %>

    <form action="EquipeEditionController" method="POST">
        <div class="form-group">
            <input type="hidden" name="idEq" value="<%=idEq%>"/>
        </div>
        <div class="form-group">
            <label for="nomequipe">Nom Equipe</label>
            <input type="text" class="form-control" name="nomequipe" value="<%=nomequipe%>"/>
        </div>
        <div class="form-group">
            <label for="datecréation">Date Création</label>
            <input type="text" class="form-control" name="datecréation" value="<%=datecréation%>"/>
        </div>
        <div class="form-group">
            <label for="entraineur">Entraineur</label>
            <input type="text" class="form-control" name="entraineur" value="<%=entraineur%>"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success">OK</button>
            <button type="reset" href="equipeList.jsp" class="btn btn-danger">Annuler</button>
        </div>
    </form>
</div>

<!-- Ajout du script JavaScript de Bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
