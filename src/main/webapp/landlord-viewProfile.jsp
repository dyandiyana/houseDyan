<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: wala wala
  Date: 1/2/2022
  Time: 4:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>HOUSE RENTAL SYSTEM</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="landlord-viewProfile.css">
  <link href="https://emoji-css.afeld.me/emoji.css" rel="stylesheet">
</head>

<body>
      <%
            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
            String user = "nhydysucefvvzn"; //ni user dri heroku database
            String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078"; //ni password dri heroku database

            Connection conn = null;
            Statement stat = null;
            ResultSet rs = null;
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection(dbURL, user, pass);
            stat = conn.createStatement();
            String data = "select * from landlord order by landlordid";
            rs = stat.executeQuery(data);

      while (rs.next()) {
          System.out.print("Landlord Id2: " + rs.getString("landlordid"));
          System.out.print("Username: " + rs.getString("landlordusername"));
          System.out.print("landlord password :" + rs.getString("landlordpassword"));
          System.out.print("landlord name: " + rs.getString("landlordname"));
          System.out.print("landlord email: " + rs.getString("landlordemail"));
          System.out.print("landlord age: " + rs.getString("landlordage"));
          System.out.print("landlord phone: " + rs.getString("landlordphoneno"));
          System.out.print("landlord gender: " + rs.getString("landlordgender"));
      }
      %>

        <div class="container">
          <h3>MY PROFILE</h3>
          <div class="row">
            <div class="col-25">
              <label>USERNAME</label>
            </div>
            <div class="col-75">
              <label></label>
            </div>
          </div>
          <div class="row">
            <div class="col-25">
              <label>PASSWORD</label>
            </div>
            <div class="col-75">
              <label></label>
            </div>
          </div>

          <div class="row">
            <div class="col-25">
              <label>FULL NAME</label>
            </div>
            <div class="col-75">
              <label></label>
            </div>
          </div>

          <div class="row">
            <div class="col-25">
              <label>EMAIL</label>
            </div>
            <div class="col-75">
              <label></label>
            </div>
          </div>

          <div class="row">
            <div class="col-25">
              <label>GENDER</label>
            </div>
            <div class="col-75">
              <label></label>
            </div>
          </div>

          <div class="row">
            <div class="col-25">
              <label>AGE</label>
            </div>
            <div class="col-75">
              <label></label>
            </div>
          </div>

          <div class="row">
            <div class="col-25">
              <label>PHONE NUMBER</label>
            </div>
            <div class="col-75">
              <label></label>
            </div>
          </div>


          <button type="submit" onclick="myFunction(); return false" class="button button1" name="submit" ><a href="landlord-updateProfile.jsp">UPDATE</a></button>
          <button type="submit" class="button button1" name="submit" onclick="document.getElementById('id01').style.display='block'"><a href="#">DELETE</a></button>


        </div>

</body>
</html>