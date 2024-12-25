<%@ page language="java" import="java.util.ArrayList, metier.Joueur "%>
<%@include file="accueil.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fiche Joueur</title>
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
    <h1 class="mt-4">Veuillez saisir les propriétés du joueur...</h1>
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
    String nomj = null;
    String prenomj = null;
    String datenaiss = null;
    String pays = null;
    int salaire = 0;
    int nbrmtchj = 0;
    String etat = null;
    int id = 0;
    int idEquipe = 0;
    Joueur j = (Joueur) request.getAttribute("joueur");
    if (j != null) {
        id = j.getId();
        nomj = j.getNomj();
        prenomj = j.getPrenomj();
        datenaiss = j.getDatenaissance();
        pays = j.getPays();
        salaire = j.getSalaire();
        nbrmtchj = j.getNbrmatchjoué();
        etat = j.getEtat();
        idEquipe = j.getIdEquipe();
    }

    // Correction des valeurs nulles
    if (nomj == null) nomj = "";
    if (prenomj == null) prenomj = "";
    if (datenaiss == null) datenaiss = "";
    if (pays == null) pays = "";
    if (etat == null) etat = "";
    if (nbrmtchj == 0) nbrmtchj = 0;
    if (idEquipe == 0) idEquipe = 0;
    %>

    <form action="JoueurEditionController" method="POST">
        <div class="form-group">
            <input type="hidden" name="id" value="<%=id%>"/>
        </div>
        <div class="form-group">
            <label for="nomj">Nom joueur:</label>
            <input type="text" class="form-control" name="nomj" value="<%=nomj%>"/>
        </div>
        <div class="form-group">
            <label for="prenomj">Prénom joueur:</label>
            <input type="text" class="form-control" name="prenomj" value="<%=prenomj%>"/>
        </div>
        <div class="form-group">
            <label for="datenaiss">Date naissance:</label>
            <input type="date" class="form-control" name="datenaiss" value="<%=datenaiss%>"/>
        </div>
        <div class="form-group">
            <label for="pays">Pays:</label>
            <input type="text" class="form-control" name="pays" value="<%=pays%>"/>
        </div>
        <div class="form-group">
            <label for="salaire">Salaire:</label>
            <input type="number" class="form-control" name="salaire" value="<%=salaire%>"/>
        </div>
        <div class="form-group">
            <label for="nbrmtchj">Nombre match joués:</label>
            <input type="number" class="form-control" name="nbrmtchj" value="<%=nbrmtchj%>"/>
        </div>
        <div class="form-group">
            <label for="etat">État:</label>
            <input type="text" class="form-control" name="etat" value="<%=etat%>"/>
        </div>
        <div class="form-group">
            <label for="idEquipe"> IdÉquipe:</label>
            <input type="number" class="form-control" name="idEquipe" value="<%=idEquipe%>"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success">OK</button>
            <button type="reset" class="btn btn-danger">Annuler</button>
        </div>
    </form>
</div>

<!-- Ajout du script JavaScript de Bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
