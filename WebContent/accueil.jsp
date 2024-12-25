<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  import="metier.User" %>
<% User us= (User)session.getAttribute("user");%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
  background-image: url("images/soccer.jpg");
}
.logo-image {
    width: 60px;
    height: 50px;
     border-radius: 50%;
     clip-path: circle(50% at center);
     mask-image: radial-gradient(circle at center, transparent 50%, black 50%);
}
  .nav-link {
            font-weight: bold;
            font-family: Arial, Helvetica, sans-serif;
        }
        .navbar-brand{
          font-family: Lucida Handwriting, Arial, Helvetica, sans-serif; }

    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">
         <img src="images/minifoot.jpg" alt="Logo" class="logo-image">
        Tournoi2023</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link"   href="UserListController">Utilisateur<span class="sr-only"></span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="EquipeListController">Equipe</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="JoueurListController">Joueur</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Entraineur</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Tournoi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="UserConnexion.jsp">Connexion</a>
                </li>
               
                <li class="nav-item">
                    <a class="nav-link" href="UserDeconnexionController" onclick="return confirm('Voulez vous vraiment quitter ?')" >Déconnexion</a>
                </li>
                 <li>
                <a>Bienvenue <%=us.getNom()%> <%=us.getPrenom()%></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
