<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Jeu" %>
<%@ page import="models.DeveloppeurDAO" %>
<%@ page import="models.CommentaireDAO" %>
<%@ page import="models.DetailDAO" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Jeu> jeux = (ArrayList)request.getAttribute("jeux");
	String mot = (String)request.getAttribute("mot");
	DeveloppeurDAO ddao = (DeveloppeurDAO)request.getAttribute("ddao");
	CommentaireDAO comdao = (CommentaireDAO)request.getAttribute("comdao");
	DetailDAO detdao = (DetailDAO)request.getAttribute("detdao");
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

          <!-- ***** Most Popular Start ***** -->
          <div class="most-popular header-text" style="margin-top:0;">
            <div class="row">
              <div class="col-lg-12">
                <div class="heading-section">
                  <h4><em>Recherche :</em> <%=mot %></h4>
                </div>
                <div class="row">
                
                  <% if(jeux==null || jeux.isEmpty()){ %>
                  <p>Nada ! Tape autre chose &#128516</p>
                  <% } else{ 
                  for(Jeu j: jeux){ %>
                  <div class="col-xl-3 col-lg-4 col-md-6 col-sm-12">
                    <div class="item" style="height:280px;">
                    
                      <div>
	                      <form method="POST">
	                        <input type="hidden" name="jeu_id" value="<%= j.getId() %>">
    	                    <button class="mini-button-add" type="submit" name="padd">
    	                    	<i class="fa fa-cart-plus" aria-hidden="true"></i>
    	                    </button>                                         	
	                   	  </form>
                      </div>
                    
                    <a href="LeJeu?id=<%=j.getId() %>">
                      <img src="<%=j.getImage_un_url() %>" style="height:150px;" alt="">
                      <h4 class="col-lg-9 col-md-9 col-sm-9"><%=j.getTitre() %>
                    </a>
                      <br>
                      <span><a href="LeDeveloppeur?id=<%=j.getDeveloppeur_id() %>"><%=ddao.getById(j.getDeveloppeur_id()).getNom() %></a></span>
                      </h4>
                      <ul class="col-lg-3 col-md-3 col-sm-3">
                        <li><i class="fa fa-star"></i> <%=comdao.getMoyenneNotesByJeuId(j.getId()) %></li>
                        <li><i class="fa fa-download"></i> <%=detdao.getCountVentesByJeu(j.getId()) %></li>
                      </ul>
                    </div>
                  </div>
                  <% } } %>
                  
                  <div class="col-lg-12">
                    <div class="main-button">
                      <a href="Nouveautes">Nouveautés</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Most Popular End ***** -->

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