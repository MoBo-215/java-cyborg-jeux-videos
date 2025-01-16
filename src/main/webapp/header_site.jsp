<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a class="col-lg-2 logo-cyborg" href="Index">
                        <img src="assets/images/logo.png" alt="">
                    </a>
                    <a class="col-lg-2 logo-c" href="Index">
                        <img src="assets/images/logo-c.png" alt="">
                    </a>
                    <!-- ***** Logo End ***** -->
                    
                    <!-- ***** Search Start ***** -->
                    <div class="search-input col-lg-2" style="padding-left:40px; width:270px">
                      <form method="GET" id="search" action="http://localhost:8080/ecf_jv/LaRecherche?mot=<%= request.getParameter("mot") %>">
                        <input type="search" placeholder="Tape quelque chose !"  name="mot" onkeypress="handle" />
                        <i class="fa fa-search"></i>
                      </form>
                    </div>
                    <!-- ***** Search End ***** -->
                    
                    <!-- ***** Menu Start ***** -->
                   	<ul class="nav">
                        <li ><a href="Index" class="active" style="color:#ec6090;">Accueil</a></li>
                        <li ><a href="Nouveautes">Nouveautés</a></li>
                        <li ><a href="BestSellers">Best Sellers</a></li>
                        <li ><a href="Categories">Catégories</a></li>
                        <li ><a href="MonPanier">Panier</a></li>                        
                        
                        <% if((boolean)session.getAttribute("isConnected")==false){ %>
                        <li style="padding-top:0.3rem;padding-right:1rem;"><a href="Connexion"><span style="padding-right:0.5rem;">Inscription / Connexion</span></a></li>
                        <% }else { %>
                        <li style="padding-right:1rem"><a href="Deconnexion">Déconnexion</a></li>
                        <li style="padding-right:1rem"><a href="Profil?id=${userid}">${usernom} <img src="assets/images/profile-header.jpg" alt=""></a></li>
                        <% } %>
                   	</ul>
                   	
                    <a class='menu-trigger' style="padding-right: 50px;">
                        <span>Menu</span>
                    </a>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
  </header>
</body>
</html>