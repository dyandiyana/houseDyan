<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/1/2022
  Time: 8:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="landlord-navbar.html"%>
</head>
<%
    String landlordusername=(String)session.getAttribute("landlordusername");
%>
<body>

<%--WELCOME !!!!!! <%=landlordusername%>--%>
WELCOME !!!!! ${landlordusername}<br><br>
<a href="landlord-updateProfile.jsp">update profile</a>
<a href="landlord-viewProfile.jsp">read profile</a>
<a href="landlord-deleteProfile.jsp">delete profile</a>
<a href="DeleteLandlordProfileServlet?landlordid=">delete profile</a>




</body>
</html>
