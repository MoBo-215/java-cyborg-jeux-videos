<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			
           <div class="row d-flex justify-content-between">
          	<div class="col-lg-5 col-md-12 gaming-library profile-library header-text" style="margin-top:0; margin-bottom:20px; margin-right:2rem;">
           		 <div id="account-id">
	              <div class="heading-section">
	                <h4>Connexion</h4>
	              </div>
	              
	              <% if((boolean)request.getAttribute("messageconnexionno")==true){ %>
                  	<div class="alert alert-danger" role="alert">
                  		Adresse e-mail ou mot de passe invalide.
                  	</div>
                  <% } %>
	              <form method="POST">                                        
	                 <ul class="row" style="color:white;">
	                     <li class="col-md-12 col-sm-12">
	                         <label >Email <em>*</em></label><br>
	                         <input required name="cemail" type="email" class="input-text" value="zak@gmail.com">
	                     </li>	
	                     <li class="col-md-12 col-sm-12" style="padding-top:1rem;">
	                         <label >Mot de passe<em>*</em></label><br>
	                         <input required name="cpassword" type="password" class="input-text" value="zakaria">
	                     </li> 
	                 </ul>
	                 <br>
	                 <div>
	                     <button type="submit" name="bconnexion"><span>Connexion</span></button>
	                 </div>
	             </form>
            	</div>
            	</div>
            	
            	<div class="col-lg-6 col-md-12 gaming-library profile-library header-text" style="margin-top:0;">
           		<div class="row">
            	<div id="account-id2">
	              <div class="heading-section">
	                <h4>Inscription</h4>
	              </div>
	              
	              <% if((boolean)request.getAttribute("messageinscriptionok")==true){ %>
                  	<div class="alert alert-success" role="alert">
						Votre inscription a bien été prise en compte.<br>Veuillez vous connecter.
                    </div>
                  <% } %>
	              <form method="POST">                                        
	                 <ul class="row" style="color:white;">
	                 	<li class="col-md-12 col-sm-12">
                             <label >Nom<em>*</em></label><br>
                             <input required name="inom" type="text" class="input-text">
                         </li>
	                     <li class="col-md-12 col-sm-12" style="padding-top:1rem;">
	                         <label >Email <em>*</em></label><br>
	                         <input required name="iemail" type="email" class="input-text">
	                     </li>	
	                     <li class="col-md-12 col-sm-12" style="padding-top:1rem;">
	                         <label >Mot de passe<em>*</em></label><br>
	                         <input required name="ipassword" type="password" class="input-text">
	                     </li> 
	                 </ul>
	                 <br>
	                 <div >
	                     <button type="submit" name="binscription"><span>Inscription</span></button>
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