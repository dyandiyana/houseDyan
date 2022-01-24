package com.example.housedyan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ReadLandlordProfileServlet", value = "/ReadLandlordProfileServlet")
public class ReadLandlordProfileServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();//tambah baru session form


        String lId = request.getParameter("landlordId");
        String lUsername = request.getParameter("landlordUsername");
        String lPassword = request.getParameter("landlordPassword");
        String lName = request.getParameter("landlordName");
        String lEmail = request.getParameter("landlordEmail");
        String lAge = request.getParameter("landlordAge");
        String lPhoneNo = request.getParameter("landlordPhoneNo");
        String lGender = request.getParameter("landlordGender");


        out.println("<html><body>");

        try
        {
            connectDB(out);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        out.println("</body></html>");


    }

    public void connectDB(PrintWriter out) throws ClassNotFoundException
    {
        try
        {
            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
            String user = "nhydysucefvvzn"; //ni user dri heroku database
            String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078"; //ni password dri heroku database

            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            // klau buat postgress atas2 ni amik yg details dri heroku


            if (conn != null)
            {

                Statement statement = null;
                ResultSet rs = null;
                String data = "select * from  landlord";
                statement = conn.createStatement();
                rs = statement.executeQuery(data);

                while (rs.next())
                {
                    System.out.print("Landlord Idd: " + rs.getString("landlordid"));
                    System.out.print("Username: " + rs.getString("landlordusername"));
                    System.out.print("landlord password :" + rs.getString("landlordpassword"));
                    System.out.print("landlord name: " + rs.getString("landlordname"));
                    System.out.print("landlord email: " + rs.getString("landlordemail"));
                    System.out.print("landlord age: " + rs.getString("landlordage"));
                    System.out.print("landlord phone: " + rs.getString("landlordphoneno"));
                    System.out.print("landlord gender: " + rs.getString("landlordgender"));

                }
            }
        }

        catch(Exception e)
        {
            System.out.println(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}


