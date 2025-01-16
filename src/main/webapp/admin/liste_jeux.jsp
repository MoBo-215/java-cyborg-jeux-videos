<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.CategorieDAO" %>
<%@ page import="models.PlateformeDAO" %>
<%@ page import="models.DeveloppeurDAO" %>
<%@ page import="models.LangueDAO" %>
<%@ page import="models.Jeu" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Jeu> jeux = (ArrayList)request.getAttribute("jeux");

	CategorieDAO cdao = (CategorieDAO)request.getAttribute("cdao");
	PlateformeDAO pdao = (PlateformeDAO)request.getAttribute("pdao");
	DeveloppeurDAO ddao = (DeveloppeurDAO)request.getAttribute("ddao");
	LangueDAO ldao = (LangueDAO)request.getAttribute("ldao");

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
                                            <li class="breadcrumb-item active">Liste des jeux</li>
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
                                    <h4 class="header-title">Liste des jeux</h4>
        
        							<style>
										p {
										     width: 200px;
										     white-space: nowrap;
										     overflow: hidden;
										     text-overflow: ellipsis;
										}
									</style>
        								
                                    <table id="datatable" class="table table-bordered dt-responsive nowrap">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Titre</th>
                                            <th>Description</th>
                                            <th>Date de sortie</th>
                                            <th>Prix</th>
                                            <th>Vidéo 1 URL</th>
                                            <th>Vidéo 2 URL</th>
                                            <th>Image 1 URL</th>
                                            <th>Image 2 URL</th>
                                            <th>Image 3 URL</th>
                                            <th>Image 4 URL</th>
                                            <th>Image 5 URL</th>
                                            <th>Age minimum</th>
                                            <th>Langue</th>
                                            <th>Développeur</th>
                                            <th>Catégorie</th>
                                            <th>Plateforme</th>
                                            <th>Stock</th>
                                            <th>Options</th>
                                        </tr>
                                        </thead>
                                        
                                        <tbody>
                                        <%
			                        		for(Jeu j: jeux){
			                        	%>
                                        <tr>
                                            <td><%=j.getId()%></td>
                                            <td><%=j.getTitre() %></td>
                                            <td><p><%=j.getDescription() %></p></td>
                                            <td><%=j.getDate_sortie() %></td>
                                            <td><%=j.getPrix() %>€</td>
                                            <td><p><%=j.getVideo_un_url() %></p></td>
                                            <td><p><%=j.getVideo_deux_url() %></p></td>
                                            <td><img src="<%=j.getImage_un_url() %>" style="height:50px; margin-left:33px;"></td>
                                            <td><img src="<%=j.getImage_deux_url() %>" style="height:50px; margin-left:30px;"></td>
                                            <td><img src="<%=j.getImage_trois_url() %>" style="height:50px; margin-left:30px;"></td>
                                            <td><img src="<%=j.getImage_quatre_url() %>" style="height:50px; margin-left:29px;"></td>
                                            <td><img src="<%=j.getImage_cinq_url() %>" style="height:50px; margin-left:30px;"></td>
                                            <td><span style="margin-left:20px;"><%=j.getAge_minimum() %></span></td>
                                            <td><span style="margin-left:30px;"><%=ldao.getById(j.getLangue_id()).getNom() %></span></td>
                                            <td><span style="margin-left:25px;"><%=ddao.getById(j.getDeveloppeur_id()).getNom() %></span></td>
                                            <td><span style="margin-left:30px;"><%=cdao.getById(j.getCategorie_id()).getNom() %></span></td>
                                            <td><span style="margin-left:30px;"><%=pdao.getById(j.getPlateforme_id()).getNom() %></span></td>
                                            <td><span style="margin-left:30px;"><%=j.getStock() %></span></td>
                                            <td>
                                            	<a href="Modifier_jeu?id=<%=j.getId()%>" class="btn btn-primary">Modifier</a>
                                            	<a href="Liste_jeux?del=<%=j.getId()%>" class="btn btn-danger">Supprimer</a>
                                            </td>
                                        </tr>
                                        <% } %>
                                        </tbody>
                                    </table>
                                    
                                </div> <!-- end card-box -->
                            </div> <!-- end col -->
                        </div> <!-- end row -->

                    </div> <!-- end container-fluid -->

                </div> <!-- end content -->

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