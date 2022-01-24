package com.example.housedyan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ReadStudentServlet", value = "/ReadStudentServlet")
public class ReadStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{
            //  dlm parameter ni pastikan nama sama dalam form jsp name=""
            String sdID1   = request.getParameter("studid");
            String sdhMP   = request.getParameter("stuname");
            String SdEmail = request.getParameter("email");
            String PhoneNum = request.getParameter ("phonenum");


            //nk testing keluar masuk data pastikan xampp, heroku , database connected

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
            String user = "nhydysucefvvzn"; //ni user dri heroku database
            String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078"; //ni password dri heroku database
            String query = "Select studid,stuname,email,phonenum from studentdetails";

            StudentDetails studentDetails= null;
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            // klau buat postgress atas2 ni amik yg details dri heroku

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,sdID1);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                System.out.print("ID: " + rs.getString("studid"));
                System.out.print("Name: " + rs.getString("stuname"));
                System.out.print("Email: " + rs.getString("email"));
                System.out.print("Phone num: " + rs.getString("phonenum"));
            }

        }catch(Exception e){
            out.println(e);
        }

    }
}
