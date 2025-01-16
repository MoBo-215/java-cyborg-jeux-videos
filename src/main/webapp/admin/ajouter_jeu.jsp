<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Categorie" %>
<%@ page import="models.Plateforme" %>
<%@ page import="models.Developpeur" %>
<%@ page import="models.Langue" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Categorie> cats = (ArrayList)request.getAttribute("cats");
	ArrayList<Developpeur> devs = (ArrayList)request.getAttribute("devs");
	ArrayList<Plateforme> ps = (ArrayList)request.getAttribute("ps");
	ArrayList<Langue> ls = (ArrayList)request.getAttribute("ls");
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
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">Jeux</a></li>
                                            <li class="breadcrumb-item active">Ajouter un jeu</li>
                                        </ol>
                                    </div>
                                    <h4 class="page-title">Jeux</h4>
                                </div>
                            </div>
                        </div>     
                        <!-- end page title -->
                        
                        <div class="row">
                            <div class="col-12">
        
                                <div class="card-box">
                                    <h4 class="header-title">Ajouter un jeu</h4>
                                    
                                  	<% if((boolean)request.getAttribute("msgaddok")==true){ %>
                                	<div class="alert alert-success" role="alert">
										Jeu ajouté.
                                	</div>
                                	<% } %>
                                	
                                    <form method="POST" action="#" class="parsley-examples">
                                        <div class="form-group">
                                            <input type="text" name="titre" parsley-trigger="change" required
                                                    placeholder="Titre" class="form-control" id="titre">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="description" parsley-trigger="change" required
                                                    placeholder="Description" class="form-control" id="description">
                                        </div>
                                        <div class="form-group">
                                            <input type="date" name="date_sortie" parsley-trigger="change" required
                                                    placeholder="Date de sortie" class="form-control" id="date_sortie">
                                        </div>
                                        <div class="form-group">
                                            <input type="number" name="prix" parsley-trigger="change" required
                                                    placeholder="Prix" class="form-control" id="prix" step="0.01">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="video_un_url" parsley-trigger="change" required
                                                    placeholder="Video 1 URL" class="form-control" id="video_un_url">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="video_deux_url" parsley-trigger="change" required
                                                    placeholder="Video 2 URL" class="form-control" id="video_deux_url">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="image_un_url" parsley-trigger="change" required
                                                    placeholder="Image 1 URL" class="form-control" id="image_un_url">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="image_deux_url" parsley-trigger="change" required
                                                    placeholder="Image 2 URL" class="form-control" id="image_deux_url">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="image_trois_url" parsley-trigger="change" required
                                                    placeholder="Image 3 URL" class="form-control" id="image_trois_url">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="image_quatre_url" parsley-trigger="change" required
                                                    placeholder="Image 4 URL" class="form-control" id="image_quatre_url">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="image_cinq_url" parsley-trigger="change" required
                                                    placeholder="Image 5 URL" class="form-control" id="image_cinq_url">
                                        </div>
                                        <div class="form-group">
                                            <input type="number" name="age_minimum" parsley-trigger="change" required
                                                    placeholder="Age minimum" class="form-control" id="age_minimum">
                                        </div>
                                        <div>
	                                        <select class="custom-select mb-3" name="langue_id" id="langue_id">
	                                            <%
													for(Langue l: ls){
												%>
												 <option value="<%=l.getId() %>"><%=l.getNom() %></option>
												<% } %>
	                                        </select>
                                        </div>
                                        <div>
	                                        <select class="custom-select mb-3" name="developpeur_id" id="developpeur_id">
	                                            <%
													for(Developpeur d: devs){
												%>
												 <option value="<%=d.getId() %>"><%=d.getNom() %></option>
												<% } %>
	                                        </select>
                                        </div>
                                        <div>
	                                        <select class="custom-select mb-3" name="categorie_id" id="categorie_id">
	                                            <%
													for(Categorie c: cats){
												%>
												 <option value="<%=c.getId() %>"><%=c.getNom() %></option>
												<% } %>
	                                        </select>
                                        </div>
                                        <div>
	                                        <select class="custom-select mb-3" name="plateforme_id" id="plateforme_id">
	                                            <%
													for(Plateforme p: ps){
												%>
												 <option value="<%=p.getId() %>"><%=p.getNom() %></option>
												<% } %>
	                                        </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="number" name="stock" parsley-trigger="change" required
                                                    placeholder="Stock" class="form-control" id="stock">
                                        </div>
        
                                        <div class="form-group text-right mb-0">
                                            <button class="btn btn-primary waves-effect waves-light mr-1" type="submit">
                                                Ajouter
                                            </button>
                                            <button type="reset" class="btn btn-light waves-effect">
                                                Cancel
                                            </button>
                                        </div>
        
                                    </form>
                                </div> <!-- end card-box -->
                            </div>
                            <!-- end col -->
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

        <!-- datatable js -->
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