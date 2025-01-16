<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Jeu" %>
<%@ page import="models.Utilisateur" %>
<%@ page import="models.Commande" %>
<%@ page import="models.CategorieDAO" %>
<%@ page import="java.util.ArrayList" %>
<%
	Utilisateur u = (Utilisateur)request.getAttribute("user");
	ArrayList<Jeu> jeux = (ArrayList)request.getAttribute("jeux");
	ArrayList<Commande> cmds = (ArrayList)request.getAttribute("cmds");
	int nb_jeux_cmdes = (Integer)request.getAttribute("nb_jeux_cmdes");
	int nb_cmds = (Integer)request.getAttribute("nb_cmds");
	CategorieDAO cdao = (CategorieDAO)request.getAttribute("cdao");
%>
<!DOCTYPE html>
<html>

  <jsp:include page="Head_site" />

<body>

  <!-- ***** Preloader Start ***** -->
  <div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
      <span class="dot"></span>
      <div class="dots">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </div>
  </div>
  <!-- ***** Preloader End ***** -->

  <!-- ***** Header Area Start ***** -->
  <jsp:include page="Header_site" />
  <!-- ***** Header Area End ***** -->

  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-content">

          <!-- ***** Banner Start ***** -->
          <div class="row">
            <div class="col-lg-12">
              <div class="main-profile ">
                <div class="row">
                  <div class="col-lg-4">
                    <img src="assets/images/profile.jpg" alt="" style="border-radius: 23px;">
                  </div>
                  <div class="col-lg-4 align-self-center">
                    <div class="main-info header-text">
                      <span>ONLINE</span>
                      <h4><%=u.getNom() %></h4>
                      <p><%=u.getEmail() %></p>
                      <div class="main-border-button">
                        <a href="Modifier_profil?id=${userid}">Modifier mes informations</a>
                        <a href="Deconnexion">Se déconnecter</a>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-4 align-self-center">
                    <ul>
                      <li>Jeux achetés <span><%=nb_jeux_cmdes %></span></li>
                      <li>Commandes passées <span><%=nb_cmds %></span></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Banner End ***** -->

          <!-- ***** Gaming Library Start ***** -->
          <div class="gaming-library profile-library">
            <div class="col-lg-12">
              <div class="heading-section mb-5">
                <h4><em>Commandes</em> passées</h4>
              </div>
              
              <% for(Commande c: cmds){ %>
              <div class="item">
                <ul>
                  <li><img src="assets/images/game-02.jpg" alt="" class="templatemo-item"></li>
                  <li><h4>N° commande</h4><span><%=c.getId() %></span></li>
                  <li><h4>Date</h4><span><%=c.getDatec() %></span></li>
                  <li><h4>Montant</h4><span><%=c.getTotal() %>€</span></li>
                  <li><h4>Etat de la commande</h4><span><%=c.getEtat() %></span></li>
                  <li><div class="main-border-button border-no-active"><a href="Details_commande?id=<%=c.getId()%>">Détails</a></div></li>
                </ul>
              </div>
              <% } %>
              
            </div>
          </div>
          <!-- ***** Gaming Library End ***** -->
        </div>
      </div>
    </div>
  </div>
  
  <jsp:include page="Footer_site" />


  <!-- Scripts -->
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

  <script src="assets/js/isotope.min.js"></script>
  <script src="assets/js/owl-carousel.js"></script>
  <script src="assets/js/tabs.js"></script>
  <script src="assets/js/popup.js"></script>
  <script src="assets/js/custom.js"></script>


  </body>

</html>