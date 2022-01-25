package com.example.housedyan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DeleteLandlordServlet", value = "/DeleteLandlordServlet")
public class DeleteLandlordServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


        //int hids = Integer.parseInt(request.getParameter("hid"));
        int landlordid = Integer.parseInt(request.getParameter("landlordid"));

        try
        {

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
            String user = "nhydysucefvvzn"; //ni user dri heroku database
            String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            PreparedStatement pst = conn.prepareStatement("DELETE FROM landlord WHERE landlordid = ?");
            //pst.setInt(1, hids);
            pst.setInt(1,landlordid);

            pst.executeUpdate();


        }

        catch (Exception e)
        {
            System.out.println(e);
        }

        response.sendRedirect("landlord-viewProfile.jsp");
    }
}
