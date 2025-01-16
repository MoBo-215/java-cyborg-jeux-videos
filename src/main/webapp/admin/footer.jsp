<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Infos"%> 
<%
	Infos i = (Infos)request.getAttribute("i");
%>
<!DOCTYPE html>
<html>
    <footer class="footer">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 text-center">
					Copyright © 2024 Cyborg Gaming Company. All rights reserved.
		            <br>
		            Contact : <a href="mailto:cyborg.corp@gero.com"><%=i.getEmail() %></a>
                </div>
            </div>
        </div>
    </footer>
</html>