<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: wala wala
  Date: 1/2/2022
  Time: 4:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>HOUSE RENTAL SYSTEM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="landlord-updateProfile.css">
    <link href="https://emoji-css.afeld.me/emoji.css" rel="stylesheet">
</head>

<body>
<div class="navbar">
    <%@include file="landlord-navbar.html"%>
    </div>
</div>

<%


    Class.forName("org.postgresql.Driver"); // ni stay
    String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
    String user = "nhydysucefvvzn"; //ni user dri heroku database
    String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078"; //ni password dri heroku database
    Connection conn = null;

    Statement stat = null;
    ResultSet res = null;
    PreparedStatement stmt = null;

    conn = DriverManager.getConnection(dbURL, user, pass);

%>

<form action="/UpdateLandlordServlet" method="POST">
    <%
        stat = conn.createStatement();
        Integer lId = Integer.parseInt(request.getParameter("landlordid"));
        String data = "select * from landlord where landlordid='"+lId+"'";
        res = stat.executeQuery(data);
        while(res.next()){
    %>
    <div class="container">
        <h2>UPDATE MY ACCOUNT</h2>
        <div class="row">
            <div class="col-25">
                <label style="">USERNAME</label>
            </div>
            <div class="col-75">
                <input type="text" name="Username" placeholder="Enter your username" value="<%=res.getString("landlordusername") %>">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label>PASSWORD</label>
            </div>
            <div class="col-75">
                <input type="password" name="password" placeholder="Enter your password" value="<%=res.getString("landlordpassword") %>">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label style="">FULL NAME</label>
            </div>
            <div class="col-75">
                <input type="text" name="FullName" placeholder="Enter your full name" value="<%=res.getString("landlordname") %>">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label>EMAIL</label>
            </div>
            <div class="col-75">
                <input type="text" name="email" placeholder="Enter your email" value="<%=res.getString("landlordemail") %>">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label style="">AGE</label>
            </div>
            <div class="col-75">
                <input type="text" name="age" placeholder="Enter your age" value="<%=res.getString("landlordage") %>">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label style="">PHONE NUMBER</label>
            </div>
            <div class="col-75">
                <input type="text" name="PhoneNumber" placeholder="Enter your phone number" value="<%=res.getString("landlordphoneno") %>">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label style="">GENDER</label>
            </div>
            <div class="col-75">
                <input type="radio" id="male" name="Gender" placeholder="Male" value="<%=res.getString("landlordgender") %>">
                <label for="male">MALE</label><br>
                <input type="radio" id="female" name="Gender" placeholder="Female" value="<%=res.getString("landlordgender") %>">
                <label for="female">FEMALE</label>
            </div>
        </div>
        <%
            }
        %>
        <button type="submit" class="button button1" name="submit" >Submit</button><br><br>
    </div>
</form>
</body>
</html>
<%
    Integer landID = Integer.parseInt(request.getParameter("landlordid"));
    String a = request.getParameter("landlordusername");
    String b = request.getParameter("landlordpassword");
    String c = request.getParameter("landlordname");
    String d = request.getParameter("landlordemail");
    String e = request.getParameter("landlordage");
    String f = request.getParameter("landlordphoneno");
    String g = request.getParameter("landlordgender");
    if(a!=null && b!=null && c!=null && d!=null && e!=null && f!=null && g!=null){
        String query = "update landlord set landlordusername=?,landlordpassword=?,landlordname=?, landlordemail=?, landlordage=? , landlordphoneno=?,landlordgender=? where landlordid='"+landID+"'";
        stmt = conn.prepareStatement(query);
        stmt.setString(1,a);
        stmt.setString(2,b);
        stmt.setString(3,c);
        stmt.setString(4,d);
        stmt.setString(5,e);
        stmt.setString(6,f);
        stmt.setString(7,g);

        stmt.executeUpdate();
        response.sendRedirect("index.jsp");
    }
%>