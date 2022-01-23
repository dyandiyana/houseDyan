<%--
  Created by IntelliJ IDEA.
  User: TOSHIBA
  Date: 22/1/2022
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Testing</title>
</head>
<body>
<h2>Fill in the details</h2>

<form action="InsertDetailsServlet" method="post">
  <table>
    <tr>
      <td>ID:</td>
      <td><input type="text" name="stuid"/></td>
    </tr>
    <tr>
      <td>Name:</td>
      <td><input type="text" name="stuname"/></td>
    </tr>
    <tr>
      <td>Email Id:</td>
      <td><input type="text" name="email"/></td>
    </tr>
    <tr>
      <td>Phone Number:</td>
      <td><input type="text" name="phonenum"/></td>
    </tr>
    <tr />
  </table>
  <br /> <input type="submit" value="Insert Data"/>

</form>
<br />
<input type="button" value="Return to Home"
       onclick="window.location.href='Home.jsp'" />


<%
  String mytext = request.getParameter("id");

  if(mytext == null){

  }
  else{
    session.setAttribute("sdid",request.getParameter("id"));
    session.setAttribute("sdName",request.getParameter("name"));
    session.setAttribute("sdEmail",request.getParameter("email"));
    session.setAttribute("sdPnum",request.getParameter("phnum"));

    out.println("session created");
  }
%>
</body>
</html>