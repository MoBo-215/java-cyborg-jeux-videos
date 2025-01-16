<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Jeu" %>
<%@ page import="models.Langue" %>
<%@ page import="models.Developpeur" %>
<%@ page import="models.DeveloppeurDAO" %>
<%@ page import="models.Categorie" %>
<%@ page import="models.CategorieDAO" %>
<%@ page import="models.Commentaire" %>
<%@ page import="models.CommentaireDAO" %>
<%@ page import="models.DetailDAO" %>
<%@ page import="models.Plateforme" %>
<%@ page import="models.UtilisateurDAO" %>
<%@ page import="java.util.ArrayList" %>
<%
	Jeu j = (Jeu)request.getAttribute("j");
	Developpeur d = (Developpeur)request.getAttribute("d");
	Categorie c = (Categorie)request.getAttribute("c");
	Plateforme p = (Plateforme)request.getAttribute("p");
	Langue l = (Langue)request.getAttribute("l");
	
	ArrayList<Jeu> jeux = (ArrayList)request.getAttribute("jeux");
	ArrayList<Commentaire> coms = (ArrayList)request.getAttribute("coms");
	
	int nb_coms = (Integer)request.getAttribute("nb_coms");
	double moy_jeu = (Double)request.getAttribute("moy_jeu");
	int nb_cmds_jeu = (Integer)request.getAttribute("nb_cmds_jeu");

	DeveloppeurDAO ddao = (DeveloppeurDAO)request.getAttribute("ddao");
	CommentaireDAO comdao = (CommentaireDAO)request.getAttribute("comdao");
	DetailDAO detdao = (DetailDAO)request.getAttribute("detdao");
	UtilisateurDAO udao = (UtilisateurDAO)request.getAttribute("udao");
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

		<style>
			button {
				border-radius:30px;
				padding:1rem;
				padding-right:1.5rem;
				padding-left:1.5rem;
				background-color:#1f2122;
				border-color:#ec6090;
				color:#ec6090;
				transition-duration: 0.4s;
			}
			
			button:hover {
			    background-color: white;
			    color:#ec6090;
			}
		
			.parent {
				position: relative;
				height:205px;
				border-radius: 23px;
			}
			
			.video:hover {
				border: 2px solid #ec6090;
			}
			
			.child1 {
				position: absolute;
			    width: 100%;
			    height: 100%;
			    top: 0;
			    left: 0;
				display: flex;
				justify-content: center;
				align-items: center;
			}
			
			.child2 {
				z-index: 1;
			}
			
			.other-games .row > div:nth-child(n+6) {
			  display: none;
			}
		</style>
		
          <!-- ***** Featured Start ***** -->
          <div class="row">
            <div class="col-lg-12">
              <div class="feature-banner header-text">
                <div class="row">
                  <div class="col-lg-6">
                    <img src="<%=j.getImage_un_url() %>" alt="" style="border-radius: 23px; height:300px">
                  </div>
                  <div class="col-lg-6">
                    <div class="thumb video">
                      <img src="<%=j.getImage_deux_url() %>" alt="" style="border-radius: 23px; height:300px">
                      <a href="<%=j.getVideo_un_url() %>" target="_blank"><i class="fa fa-play"></i></a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Featured End ***** -->


          <!-- ***** Details Start ***** -->
          <div class="game-details">
            <div class="row">
              <div class="col-lg-12">
                <h2><%=j.getTitre() %></h2>
              </div>
              <div class="col-lg-12">
                <div class="content">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="left-info">
                        <div class="left">
                          <h4><a href="LeDeveloppeur?id=<%=d.getId() %>"><%=d.getNom() %></a></h4>
                          <span>Date de sortie : <%=j.getDate_sortie() %></span>
                        </div>
                        <ul>
                          <li><i class="fa fa-star"></i> <%=moy_jeu %> / 20</li>
                          <li><i class="fa fa-download"></i> <%=nb_cmds_jeu %> achats</li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="right-info">
                        <ul class="d-flex justify-content-around">
                          <li><a href="LaPlateforme?id=<%=p.getId() %>"><i class="fa fa-gamepad"></i><%=p.getNom() %></a></li>
                          <li><a href="LaCategorie?id=<%=c.getId() %>"><i class="fa fa-file"></i><%=c.getNom() %></a></li>
                          <li><a href="LaLangue?id=<%=l.getId() %>"><i class="fa fa-language" style="color:yellow"></i> <%=l.getNom() %></a></li>
                          <li><i class="fa fa-ban"></i> -<%=j.getAge_minimum() %></li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <img src="<%=j.getImage_trois_url() %>" alt="" style="border-radius: 23px; margin-bottom: 30px;height:200px">
                    </div>
                    <div class="col-lg-4">
                      <img src="<%=j.getImage_quatre_url() %>" alt="" style="border-radius: 23px; margin-bottom: 30px;height:200px">
                    </div>
                    
                    <%
                    if(j.getVideo_deux_url().isBlank()){
                    	System.out.println("NO VIDEO 2");
                    %>
                    <div class="col-lg-4">
                      <img src="<%=j.getImage_cinq_url() %>" alt="" style="border-radius: 23px; margin-bottom: 30px;height:200px">
                    </div>
                    <% } else{ %>
                    <div class="col-lg-4 parent video">
	                    <div class="thumb">
	                      <img src="<%=j.getImage_cinq_url() %>" alt="" class="child1" style="border-radius: 23px; margin-bottom: 30px;height:200px">
	                      <a href="<%=j.getVideo_deux_url() %>" target="_blank"><i class="fa fa-play child1 child2"></i></a>
	                    </div>
                    </div>
                    <% } %>
                    
                    <div class="col-lg-12">
                      <p><%=j.getDescription() %></p>
                    </div>
                    
                    <div class="col-lg-12">
                      <div class="main-border-button">
	                      <form method="POST">
    	                    <button type="submit" name="padd" style="width:100%;text-align:center;">Ajouter au panier</button>                                         	
	                   	  </form>
                      </div>
                    </div>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Details End ***** -->

          <!-- ***** Other Start ***** -->
          <div class="other-games">
            <div class="row">
              <div class="col-lg-12">
                <div class="heading-section">
                  <h4><em>Jeux</em> similaires</h4>
                </div>
              </div>
              
              <%for(Jeu jj: jeux){ %>
              <div class="col-lg-6" href="LeJeu?id=<%=jj.getId() %>">
                <div class="item">
                  <a href="LeJeu?id=<%=jj.getId() %>">
                    <img src="<%=jj.getImage_un_url() %>" alt="" class="templatemo-item mt-3">
                    <h4><%=jj.getTitre() %></h4>
                  </a>
                  <a href="LeDeveloppeur?id=<%=jj.getDeveloppeur_id() %>">
                    <span><%=ddao.getById(jj.getDeveloppeur_id()).getNom() %></span>
                  </a>
                  <ul>
                    <li><i class="fa fa-star"></i> <%=comdao.getMoyenneNotesByJeuId(jj.getId()) %></li>
                    <li><i class="fa fa-download"></i> <%=detdao.getCountVentesByJeu(jj.getId()) %></li>
                  </ul>
                </div>
              </div>
              <% } %>
              
            </div>
          </div>
          <!-- ***** Other End ***** -->
          
          <!-- ***** Other Start ***** -->
          <div class="other-games">
            <div class="row">
              <div class="col-lg-12">
                <div class="heading-section">
                  <h4><em>Commentaires</em> (<%=nb_coms %>)</h4>
                </div>
              </div>
              
              <%for(Commentaire com: coms){
            		if(com.isApprouve()==false){  
           	  %>
           	  <div class="col-lg-12">
                <div class="item">
                  <h4><%=udao.getById(com.getUtilisateur_id()).getNom() %></h4>
                  <p>Commentaire non conforme aux normes de la communauté.</p>
                </div>
              </div>
           	  <% }else{ %>
              <div class="col-lg-12">
                <div class="item">
                  <h4><%=udao.getById(com.getUtilisateur_id()).getNom() %> [<%=com.getNote() %>/20]</h4>
                  <p><%=com.getTexte() %></p>
                </div>
              </div>
              <% } } %>
              
              <% if((boolean)session.getAttribute("isConnected")==true) { %>
              <form method="POST">
                  <input name="note" type="number" class="input-text mb-3" style="border-radius:20px;width:15%;padding-left:10px;" placeholder="Note / 20" min="0" max="20" id="note" step="0.01">
              	  <div style="text-align:center;">
	              	  <textarea rows="3" class="mb-4" style="border-radius:20px;width:100%;padding-left:10px;" placeholder="Donne ton avis ici !" name="commentaire" maxlength="250" id="commentaire"></textarea>              
              	  </div>
              
	              <div class="main-border-button mb-4">
	                 <button type="submit" name="paddcom" style="width:100%;text-align:center;">Ajouter un commentaire</button>                                      
	              </div>
	           </form>
	           <% }else{ %>
	           <div class="main-border-button mb-4">
	              <a href="Connexion" style="width:100%;text-align:center;">Connectez-vous pour pouvoir ajouter un commentaire</a>                                      
	           </div>
	           <% } %>
            </div>
          </div>
          <!-- ***** Other End ***** -->

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