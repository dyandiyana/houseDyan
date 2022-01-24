<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<html>
    <head>
        <title>4Wheel Car Rental</title>


    <body style="background-color:black;">
    </body>


    </head>

<body>
        <header>
            <nav>
                <div>
                </div>
            </nav>
        </header>
    <br>

    <div class="row">
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="container">
            <h3 class="text-center" style="color:white">List of customer</h3>
            <hr>

            <div class="col-md-6">
            </div>


            <p></p>
            <table class="table table-bordered table-striped table-hover">
                <thead>

                <tr>
                    <th class="text-center" style="color:white">IC Number</th>
                    <th class="text-center" style="color:white">Name</th>
                    <th class="text-center" style="color:white">Username</th>
                    <th class="text-center" style="color:white">Password</th>
                    <th class="text-center" style="color:white">Email</th>
                    <th class="text-center" style="color:white">Phone</th>
                    <th class="text-center" style="color:white">Address</th>
                    <th class="text-center" style="color:white">Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    String DB_DRIVER = "org.postgresql.Driver";
                    String DB_HOST = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt";
                    String DB_USER = "nhydysucefvvzn";
                    String DB_PASSWORD = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078";




                    Class.forName(DB_DRIVER);
                    Connection conn = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD);
                    Statement stat = conn.createStatement();
                    String u = request.getParameter("landlordid");
                    String data = "select * from landlord where landlordid ='"+u+"'";
                    ResultSet res = stat.executeQuery(data);
                    while(res.next()){
                %>
                <tr>
                    <td style="color:white"><%=res.getString("landlordid")%></td>
                    <td style="color:white"><%=res.getString("landlordusername")%></td>
                    <td style="color:white"><%=res.getString("landlordpassword")%></td>
                    <td style="color:white"><%=res.getString("landlordname")%></td>
                    <td style="color:white"><%=res.getString("landlordemail")%></td>
                    <td style="color:white"><%=res.getString("landlordage")%></td>
                    <td style="color:white"><%=res.getString("landlordphoneno")%></td>
                    <td style="color:white"><%=res.getString("landlordgender")%></td>


                    <td class="text-center">
                        <a href='Edit.jsp?u=<%=res.getString("landlordid")%>' class="btn btn-success">Update</a>
                        <a href='Delete.jsp?d=<%=res.getString("landlordid")%>' class="btn btn-danger">Delete</a>
                    </td>
                </tr>

                <%
                    }
                %>

                </tbody>

        </table>
    </div>
    </div>

</html>
