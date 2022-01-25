<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@ page import="java.io.PrintWriter" %>

<html>
    <head>
        <title>HOUSE RENTAL SYSTEM</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body>


    <%
        HttpSession session1 = request.getSession();
        String landlordusername = request.getParameter("landlordusername");
        int id = Integer.parseInt(session1.getAttribute("landlordid").toString());
        System.out.println(landlordusername);


        try
        {

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
            String user = "nhydysucefvvzn";
            String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            Statement stmt = conn.createStatement();
            String sql = "delete from landlord where landlordid=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            stmt.execute(sql);
            int row= st.executeUpdate();

            if(row>0){
                out.println("Your Requested Data Is Deleted");
            }else{
                out.println("Your Requested Data Is not Deleted");
            }

            conn.close();
        }catch (Exception e)
        {
            out.println("Error: " + e.toString());

        }



    %>
    </body>

</html>


