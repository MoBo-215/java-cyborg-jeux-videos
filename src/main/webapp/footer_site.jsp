<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Infos"%> 
<%
	Infos i = (Infos)request.getAttribute("i");
%>
<!DOCTYPE html>
<html>
<body>
<footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <p>Copyright © 2024 Cyborg Gaming Company. All rights reserved.
          <br>
          Contact : <a href="mailto:cyborg.corp@gero.com"><%=i.getEmail() %></a></p>
        </div>
      </div>
    </div>
  </footer>
</body>
</html>