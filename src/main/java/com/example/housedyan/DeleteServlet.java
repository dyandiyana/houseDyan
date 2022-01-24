package com.example.housedyan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "com.example.housedyan.DeleteServlet", value = "/com.example.housedyan.DeleteServlet")

public class DeleteServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            int landlordid = Integer.parseInt(request.getParameter("landlordid"));
            System.out.println(landlordid);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
            String user = "nhydysucefvvzn";
            String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            Statement stmt = conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("delete * from landlord where landlordid=2");
            //pst.setInt(1,landlordid);
            ResultSet rs= pst.executeQuery();

            out.print("Your Requested Data Is Deleted");
            conn.close();
        }

        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());

        }
    }



}
