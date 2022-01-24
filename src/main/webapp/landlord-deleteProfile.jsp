<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%
    String id = request.getParameter("landlordid");

    Class.forName("org.postgresql.Driver"); // ni stay
    String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
    String user = "nhydysucefvvzn";
    String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078";
    Connection conn = DriverManager.getConnection(dbURL,user,pass);

    Statement stat = conn.createStatement();
    stat.executeUpdate("delete * from  landlord where landlordid='"+id+"'");

    response.sendRedirect("index.jsp");
%>

