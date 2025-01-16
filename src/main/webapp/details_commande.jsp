<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Commande" %>
<%@ page import="models.Jeu" %>
<%@ page import="models.JeuDAO" %>
<%@ page import="models.DeveloppeurDAO" %>
<%@ page import="models.Detail" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%
	DecimalFormat df = new DecimalFormat("0.00");
	Commande c = (Commande)request.getAttribute("c");
	ArrayList<Detail> details_cmd = (ArrayList)request.getAttribute("details_cmd");
	DeveloppeurDAO ddao = (DeveloppeurDAO)request.getAttribute("ddao");
	JeuDAO jdao = (JeuDAO)request.getAttribute("jdao");
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
                <h4><em>Détails de la</em> commande n°<%=c.getId() %></h4>
              </div>
              
              	<% for(Detail d: details_cmd) { %>
	              <div class="item">
	                <ul class="detail-cmd">
	                  <li><a href="LeJeu?id=<%=d.getJeu_id() %>"><img src="<%=jdao.getById(d.getJeu_id()).getImage_un_url() %>" alt="" class="templatemo-item" style="margin-bottom:5px;"></a></li>
	                  <li>
	                  	<a href="LeJeu?id=<%=d.getJeu_id() %>"><h4><%=jdao.getById(d.getJeu_id()).getTitre() %></h4></a>
	                  	<a href="LeDeveloppeur?id=<%=ddao.getById(jdao.getById(d.getJeu_id()).getDeveloppeur_id()).getId() %>"><span><%=ddao.getById(jdao.getById(d.getJeu_id()).getDeveloppeur_id()).getNom() %></span></a>
	                  </li>
	                  <li><h4>Quantité</h4><span><%=d.getNb() %></span></li>
	                  <li><h4>Prix unitaire</h4><span><%=jdao.getById(d.getJeu_id()).getPrix() %>€</span></li>
	                  <li><h4>Sous-total</h4><span><%=df.format(jdao.getById(d.getJeu_id()).getPrix() * d.getNb()) %>€</span></li>
	                  <li><div class="main-border-button border-no-active"><a href="LeJeu?id=<%=d.getJeu_id() %>">Détails du jeu</a></div></li>
	                </ul>
	              </div>
              	
              	<% } %>
              	
              	  <div class="item">
	                <ul class="text-end">
	                  <li class="heading-section"><h4>Total</h4><span><%=c.getTotal() %>€</span></li>
	                </ul>
	              </div>
	              
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