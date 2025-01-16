<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Utilisateur" %>
<%
	Utilisateur u = (Utilisateur)request.getAttribute("user");
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
			<style>
	          	.input-text {
	          		width:70%;
	          		border-radius:20px;
	          		padding-left:10px;
	          	}
	          	
				button {
					height:50px;
					border-radius:30px;
					padding-right:1.5rem;
					padding-left:1.5rem;
					background-color:#ec6090;
					color:white;
					transition-duration: 0.4s;
				}
				
				button:hover {
				    background-color: white;
				    color:#ec6090;
				}
			</style>
			
           <div class="row">
          	<div class="col-xl-8 col-lg-8 col-md-12 col-sm-12 col-xs-12 gaming-library profile-library header-text" style="margin-top:0;margin-right:30px">
           		 <div id="account-id">
	              <div class="heading-section">
	                <h4><em>Modifier</em> mes informations</h4>
	              </div>
	              
	              <form method="POST">                                        
	                 <ul class="row" style="color:white;">
	                 
	                 	 <li class="col-md-12 col-sm-12 col-xs-12" >
	                         <label >Nom <em>*</em></label><br>
	                         <input required name="nom" type="text" class="input-text" value="<%=u.getNom() %>" id="nom">
	                     </li>
	                     <li class="col-md-12 col-sm-12 col-xs-12" style="padding-top:1rem">
	                         <label >Email <em>*</em></label><br>
	                         <input required name="email" type="email" class="input-text" value="<%=u.getEmail() %>" id="email">
	                     </li>	
	                     <li class="col-md-12 col-sm-12 col-xs-12" style="padding-top:1rem">
	                         <label >Mot de passe<em>*</em></label><br>
	                         <input required name="password" type="password" class="input-text" value="<%=u.getMot_de_passe() %>" id="password">
	                     </li> 
	                     
	                 </ul>
	                 <br>
	                 <div>
	                     <button type="submit" name="enregistrer"><span>Enregistrer</span></button>
	                 </div>
	             </form>
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