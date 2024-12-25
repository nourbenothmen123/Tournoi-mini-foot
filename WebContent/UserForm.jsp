<%@page language="java" import="java.util.ArrayList, metier.User"%>
<%@include file="accueil.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fiche User</title>
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
    <h1 class="mt-4">Veuillez saisir les propriétés de l'utilisateur...</h1>
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

    // Gestion de la saisie de l'utilisateur en cours
    String login = null;
    String password = null;
    String nom = null;
    String prenom = null;
    int id = 0;
    User u = (User) request.getAttribute("user");
    if (u != null) {
        id = u.getId();
        login = u.getLogin();
        password = u.getPassword();
        nom = u.getNom();
        prenom = u.getPrenom();
    }

    // Correction des valeurs nulles
    if (login == null) login = "";
    if (password == null) password = "";
    if (nom == null) nom = "";
    if (prenom == null) prenom = "";
    %>

    <form action="UserEditionController" method="POST">
        <div class="form-group">
            <input type="hidden" name="id" value="<%=id%>"/>
        </div>
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" name="login" value="<%=login%>"/>
        </div>
        <div class="form-group">
            <label for="password">Mot de passe:</label>
            <input type="password" class="form-control" name="password" value="<%=password%>"/>
        </div>
        <div class="form-group">
            <label for="nom">Nom:</label>
            <input type="text" class="form-control" name="nom" value="<%=nom%>"/>
        </div>
        <div class="form-group">
            <label for="prenom">Prénom:</label>
            <input type="text" class="form-control" name="prenom" value="<%=prenom%>"/>
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
