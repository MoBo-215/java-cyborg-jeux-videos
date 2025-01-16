<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Jeu" %>
<%@ page import="models.Categorie" %>
<%@ page import="models.CategorieDAO" %>
<%@ page import="models.DeveloppeurDAO" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Categorie> cats = (ArrayList)request.getAttribute("cats");
	ArrayList<Jeu> jeux_bs = (ArrayList)request.getAttribute("jeux_bs");
	CategorieDAO cdao = (CategorieDAO)request.getAttribute("cdao");
	DeveloppeurDAO ddao = (DeveloppeurDAO)request.getAttribute("ddao");
%>
<!DOCTYPE html>
<html lang="en">

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
      <div class="col-xl-12">
        <div class="page-content">

          <!-- ***** Featured Games Start ***** -->
          <div class="row">
            <div class="col-xl-8 col-lg-12">
              <div class="featured-games header-text">
                <div class="heading-section">
                  <h4><em>Catégories</em> de jeux</h4>
                </div>
                <div class="owl-features owl-carousel">
                  
                  <% for(Categorie c: cats){ %>
                  <div class="item">
                    <div class="thumb">
	                  <a href="LaCategorie?id=<%=c.getId() %>">
                      <img src="<%=c.getImage_url() %>" alt="">
                      <div class="hover-effect">
                        <h6>GO !</h6>
                      </div>
                      </a>
                    </div>
                    <h4><a href="LaCategorie?id=<%=c.getId() %>"><%=c.getNom() %></a></h4>
                    <ul>
                      <li><i class="fa fa-download"></i>  <%=cdao.getCountJeuxById(c.getId()) %> jeux</li>
                    </ul>
                  </div>
                  <% } %>
                  
                </div>
              </div>
            </div>
          <!-- ***** Featured Games End ***** -->

          <!-- ***** Jeux les plus vendus Start ***** -->
		  <div class="col-xl-4 col-lg-12">
            <div class="top-downloaded">
           
               <div class="heading-section pb-1" style="border-bottom: 1px solid #27292a;">
                 <h4><em>TOP 3</em> ventes</h4>
               </div>
               
               <ul class="pt-2 mt-3">
               
               <% for(Jeu j: jeux_bs){
            		if(jeux_bs.indexOf(j)<3){   
               %>
                 <li>
                   <a href="LeJeu?id=<%=j.getId() %>">
	                   <img src="<%=j.getImage_un_url() %>" alt="" class="templatemo-item">
	                   <h4><%=j.getTitre() %></h4>
                   </a>
                   <h6><a href="LeDeveloppeur?id=<%=j.getDeveloppeur_id() %>"><%=ddao.getById(j.getDeveloppeur_id()).getNom() %></a></h6>
               	   <br>
                 </li>
               <% } } %>  
                 
               </ul>
               
               <div class="text-button">
                 <a href="BestSellers">Best Sellers</a>
               </div>
               
	         </div>
	       </div>
	       <!-- ***** Jeux les plus vendus End ***** -->
          
          </div>
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
