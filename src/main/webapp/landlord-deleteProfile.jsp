<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    String id = request.getParameter("id");

    String DB_DRIVER = "org.postgresql.Driver";
    String DB_HOST = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
    String DB_USER = "nhydysucefvvzn";
    String DB_PASSWORD = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078";

    Class.forName(DB_DRIVER).newInstance();
    Connection conn = DriverManager.getConnection(DB_HOST,DB_USER,DB_PASSWORD);
    Statement stat = conn.createStatement();
    stat.executeUpdate("delete from landlord where landlordid='"+id+"'");

    response.sendRedirect("index.jsp");
%>

