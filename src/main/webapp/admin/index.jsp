<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Categorie"%>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Integer> nb_prods = (ArrayList)request.getAttribute("nb_prods");
	ArrayList<Integer> nb_jv_vendus = (ArrayList)request.getAttribute("nb_jv_vendus");
	ArrayList<Categorie> cats = (ArrayList)request.getAttribute("cats");
%>
<!DOCTYPE html>
<html lang="en">
    <!-- Head -->
     <jsp:include page="Head_admin" />

    <body>

        <!-- Begin page -->
        <div id="wrapper">

            <!-- Topbar Start -->
            <jsp:include page="Header_admin" />

            <!-- ========== Left Sidebar Start ========== -->
            <jsp:include page="Left_sidebar" />

            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

            <div class="content-page">
                <div class="content">

                    <!-- Start Content-->
                    <div class="container-fluid">
                        
                        <!-- start page title -->
                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box">
                                    <div class="page-title-right">
                                        <ol class="breadcrumb m-0">
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">Greeva</a></li>
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">Tableau de bord</a></li>
                                        </ol>
                                    </div>
                                    <h4 class="page-title">Tableau de bord</h4>
                                </div>
                            </div>
                        </div>     
                        <!-- end page title -->
                        
                        <div class="row">
                            <div class="col-12">
        
                                <div class="card-box">
                                    <h4 class="header-title">Nombre de jeux par catégorie</h4>
								     
								    <div style="width:60%">
									  <canvas id="myChart"></canvas>
									</div>
									
									<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
									
									<script>
									  const ctx = document.getElementById('myChart');
									
									  new Chart(ctx, {
										  type: 'bar',
										  data: {
											    labels: [
											    	<%
											    	for(Categorie c: cats){
											    	%>
											    		"<%=c.getNom() %>",
											    	<% } %>
											    	
											    ],
											    datasets: [{
											      label: 'Jeux',
											      data: [
											    	<%
											    	for(Integer nb: nb_prods){
											    	%>
											    		<%=nb %>,
											    	<% } %>
											  
											      ],
											      backgroundColor: [
											        'rgba(255, 99, 132, 0.2)',
											        'rgba(255, 159, 64, 0.2)',
											        'rgba(255, 205, 86, 0.2)',
											        'rgba(75, 192, 192, 0.2)',
											        'rgba(54, 162, 235, 0.2)',
											        'rgba(153, 102, 255, 0.2)',
											        'rgba(201, 203, 207, 0.2)',
											        'rgba(201, 203, 207, 0.2)'
											      ],
											      borderColor: [
											        'rgb(255, 99, 132)',
											        'rgb(255, 159, 64)',
											        'rgb(255, 205, 86)',
											        'rgb(75, 192, 192)',
											        'rgb(54, 162, 235)',
											        'rgb(153, 102, 255)',
											        'rgb(201, 203, 207)',
											        'rgb(201, 203, 207)'
											      ],
											      borderWidth: 1
											    }]
										  },
										  options: {
										    scales: {
										      y: {
										        beginAtZero: true
										      }
										    }
										  }
									  });
									</script>
								</div>
								
								<div class="card-box">
                                    <h4 class="header-title">Nombre de ventes par catégorie</h4>
								     
								    <div style="width:60%">
									  <canvas id="myChart2"></canvas>
									</div>
									
									<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
									
									<script>
									  const ctx2 = document.getElementById('myChart2');
									
									  new Chart(ctx2, {
										  type: 'bar',
										  data: {
											    labels: [
											    	<%
											    	for(Categorie c: cats){
											    	%>
											    		"<%=c.getNom() %>",
											    	<% } %>
											    	
											    ],
											    datasets: [{
											      label: 'Ventes',
											      data: [
											    	<%
											    	for(Integer nb: nb_jv_vendus){
											    	%>
											    		<%=nb %>,
											    	<% } %>
											  
											      ],
											      backgroundColor: [
											        'rgba(255, 99, 132, 0.2)',
											        'rgba(255, 159, 64, 0.2)',
											        'rgba(255, 205, 86, 0.2)',
											        'rgba(75, 192, 192, 0.2)',
											        'rgba(54, 162, 235, 0.2)',
											        'rgba(153, 102, 255, 0.2)',
											        'rgba(201, 203, 207, 0.2)',
											        'rgba(201, 203, 207, 0.2)'
											      ],
											      borderColor: [
											        'rgb(255, 99, 132)',
											        'rgb(255, 159, 64)',
											        'rgb(255, 205, 86)',
											        'rgb(75, 192, 192)',
											        'rgb(54, 162, 235)',
											        'rgb(153, 102, 255)',
											        'rgb(201, 203, 207)',
											        'rgb(201, 203, 207)'
											      ],
											      borderWidth: 1
											    }]
										  },
										  options: {
										    scales: {
										      y: {
										        beginAtZero: true
										      }
										    }
										  }
									  });
									</script>
								</div>
								
                            </div>
                         </div>
                        
                    </div> <!-- container-fluid -->

                </div> <!-- content -->

			   <!-- Footer Start -->
				<jsp:include page="Footer_admin" />
		       <!-- end Footer -->

            </div>

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->

        <!-- Right Sidebar -->
        <div class="right-bar">
            <div class="rightbar-title">
                <a href="javascript:void(0);" class="right-bar-toggle float-right">
                    <i class="mdi mdi-close"></i>
                </a>
                <h5 class="m-0 text-white">Settings</h5>
            </div>
            <div class="slimscroll-menu">
                <!-- User box -->
                <div class="user-box">
                    <div class="user-img">
                        <img src="assets/images/users/avatar-1.jpg" alt="user-img" title="Mat Helme" class="rounded-circle img-fluid">
                        <a href="javascript:void(0);" class="user-edit"><i class="mdi mdi-pencil"></i></a>
                    </div>
            
                    <h5><a href="javascript: void(0);">Agnes Kennedy</a> </h5>
                    <p class="text-muted mb-0"><small>Admin Head</small></p>
                </div>

                <!-- Settings -->
                <hr class="mt-0" />
                <h5 class="pl-3">Basic Settings</h5>
                <hr class="mb-0" />


                <div class="p-3">
                    <div class="checkbox checkbox-primary mb-2">
                        <input id="checkbox1" type="checkbox" checked>
                        <label for="checkbox1">
                            Notifications
                        </label>
                    </div>
                    <div class="checkbox checkbox-primary mb-2">
                        <input id="checkbox2" type="checkbox" checked>
                        <label for="checkbox2">
                            API Access
                        </label>
                    </div>
                    <div class="checkbox checkbox-primary mb-2">
                        <input id="checkbox3" type="checkbox">
                        <label for="checkbox3">
                            Auto Updates
                        </label>
                    </div>
                    <div class="checkbox checkbox-primary mb-2">
                        <input id="checkbox4" type="checkbox" checked>
                        <label for="checkbox4">
                            Online Status
                        </label>
                    </div>
                    <div class="checkbox checkbox-primary mb-0">
                        <input id="checkbox5" type="checkbox" checked>
                        <label for="checkbox5">
                            Auto Payout
                        </label>
                    </div>
                </div>

                <!-- Timeline -->
                <hr class="mt-0" />
                <h5 class="pl-3 pr-3">Messages <span class="float-right badge badge-pill badge-danger">25</span></h5>
                <hr class="mb-0" />
                <div class="p-3">
                    <div class="inbox-widget">
                        <div class="inbox-item">
                            <div class="inbox-item-img"><img src="assets/images/users/avatar-1.jpg" class="rounded-circle" alt=""></div>
                            <p class="inbox-item-author"><a href="javascript: void(0);" class="text-dark">Chadengle</a></p>
                            <p class="inbox-item-text">Hey! there I'm available...</p>
                            <p class="inbox-item-date">13:40 PM</p>
                        </div>
                        <div class="inbox-item">
                            <div class="inbox-item-img"><img src="assets/images/users/avatar-2.jpg" class="rounded-circle" alt=""></div>
                            <p class="inbox-item-author"><a href="javascript: void(0);" class="text-dark">Tomaslau</a></p>
                            <p class="inbox-item-text">I've finished it! See you so...</p>
                            <p class="inbox-item-date">13:34 PM</p>
                        </div>
                        <div class="inbox-item">
                            <div class="inbox-item-img"><img src="assets/images/users/avatar-3.jpg" class="rounded-circle" alt=""></div>
                            <p class="inbox-item-author"><a href="javascript: void(0);" class="text-dark">Stillnotdavid</a></p>
                            <p class="inbox-item-text">This theme is awesome!</p>
                            <p class="inbox-item-date">13:17 PM</p>
                        </div>

                        <div class="inbox-item">
                            <div class="inbox-item-img"><img src="assets/images/users/avatar-4.jpg" class="rounded-circle" alt=""></div>
                            <p class="inbox-item-author"><a href="javascript: void(0);" class="text-dark">Kurafire</a></p>
                            <p class="inbox-item-text">Nice to meet you</p>
                            <p class="inbox-item-date">12:20 PM</p>

                        </div>
                        <div class="inbox-item">
                            <div class="inbox-item-img"><img src="assets/images/users/avatar-5.jpg" class="rounded-circle" alt=""></div>
                            <p class="inbox-item-author"><a href="javascript: void(0);" class="text-dark">Shahedk</a></p>
                            <p class="inbox-item-text">Hey! there I'm available...</p>
                            <p class="inbox-item-date">10:15 AM</p>

                        </div>
                    </div> <!-- end inbox-widget -->
                </div> <!-- end .p-3-->

            </div> <!-- end slimscroll-menu-->
        </div>
        <!-- /Right-bar -->

        <!-- Right bar overlay-->
        <div class="rightbar-overlay"></div>

        <!-- Vendor js -->
        <script src="assets/js/vendor.min.js"></script>
		
        <!-- Datatables js -->
        <script src="assets/libs/datatables/jquery.dataTables.min.js"></script>
        <script src="assets/libs/datatables/dataTables.bootstrap4.min.js"></script>
        <script src="assets/libs/datatables/dataTables.responsive.min.js"></script>
        <script src="assets/libs/datatables/responsive.bootstrap4.min.js"></script>
        
        <script src="assets/libs/datatables/dataTables.buttons.min.js"></script>
        <script src="assets/libs/datatables/buttons.bootstrap4.min.js"></script>
        <script src="assets/libs/datatables/buttons.html5.min.js"></script>
        <script src="assets/libs/datatables/buttons.flash.min.js"></script>
        <script src="assets/libs/datatables/buttons.print.min.js"></script>

        <script src="assets/libs/datatables/dataTables.keyTable.min.js"></script>
        <script src="assets/libs/datatables/dataTables.select.min.js"></script>

        <!-- Datatables init -->
        <script src="assets/js/pages/datatables.init.js"></script>

        <!-- App js -->
        <script src="assets/js/app.min.js"></script>
        
    </body>
</html>