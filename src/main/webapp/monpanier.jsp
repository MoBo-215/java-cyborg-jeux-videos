<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Jeu" %>
<%@ page import="models.DeveloppeurDAO" %>
<%@ page import="models.Panier" %>
<%@ page import="models.PanierDetails" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%
	DecimalFormat df = new DecimalFormat("0.00");
	ArrayList<Jeu> jeux = (ArrayList)request.getAttribute("jeux");
	DeveloppeurDAO devdao = (DeveloppeurDAO)request.getAttribute("devdao");
	
	Panier paniers = (Panier)session.getAttribute("panier");
	double total = 0;
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

          <!-- ***** Gaming Library Start ***** -->
          <div class="gaming-library profile-library" style="margin-top:0;">
            <div class="col-lg-12">
            
              <div class="heading-section">
                <h4><em>Mon</em> panier</h4>
              </div>
              
				<%
				if(paniers==null || paniers.count()<1){
				%>
					<p>Ton panier est vide... C'est pas bien ça ! &#128544</p>
				<%} else{
						for(PanierDetails pa: paniers.articles){
				%>
              
	              <div class="item">
	                <ul>
	                  <li><a href="LeJeu?id=<%=pa.getJeu().getId() %>"><img src="<%=pa.getJeu().getImage_un_url() %>" alt="" class="templatemo-item" style="margin-bottom:5px;"></a></li>
	                  <li>
	                  	<h4><a href="LeJeu?id=<%=pa.getJeu().getId() %>"><%=pa.getJeu().getTitre() %></a></h4>
	                  	<a href="LeDeveloppeur?id=<%=devdao.getById(pa.getJeu().getDeveloppeur_id()).getId() %>"><span><%=devdao.getById(pa.getJeu().getDeveloppeur_id()).getNom() %></span></a>
	                  </li>
	                  <li><h4>Quantité</h4><span><%=pa.getQte() %></span></li>
	                  <li><h4>Prix unitaire</h4><span><%=pa.getJeu().getPrix() %>€</span></li>
	                  <li><h4>Sous-total</h4><span><%=df.format( pa.getJeu().getPrix() * pa.getQte() ) %>€</span></li>
	                  <li><div class="main-border-button border-no-active"><a href="MonPanier?delete=<%=pa.getJeu().getId() %>">Supprimer</a></div></li>
	                </ul>
	              </div>
              	
              	<%
              		total = total + pa.getJeu().getPrix() * pa.getQte();
				} }
				%>
				
				<% if(paniers==null || paniers.count()<1){%>
				
				<%} else{ %>
              	  <div class="item">
	                <ul class="text-end">
	                  <li class="heading-section"><h4>Total</h4><span><%=df.format(total) %>€</span></li>
	                </ul>
	              </div>
	            <% } %>
              
                <% if(paniers==null || paniers.count()<1){ %>    
		            <div class="main-border-button mt-4">
		               <a href="Nouveautes" class="pull-right" style="width:100%; text-align:center;">Trouvez votre bonheur ici !</a>
		            </div>
                <% } else if((boolean)session.getAttribute("isConnected")==false){ %>
    				<div class="main-border-button mt-4">
		               <a href="Connexion" class="pull-right" style="width:100%; text-align:center;">Connexion / Inscription</a>
		            </div>
		        <% } else{ %>
    				<div class="main-border-button mt-4">
		               <a href="MonPanier?valider=ok" class="pull-right" style="width:100%; text-align:center;">Passer ma commande</a>
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