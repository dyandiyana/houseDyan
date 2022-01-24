package com.example.housedyan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "UpdateLandlordServlet", value = "/UpdateLandlordServlet")
public class UpdateLandlordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{
            //  dlm parameter ni pastikan nama sama dalam form jsp name=""
            Integer lId = Integer.valueOf(request.getParameter("landlordid"));
            String lUsername = request.getParameter("landlordUsername");
            String lPassword = request.getParameter("landlordPassword");
            String lName = request.getParameter("landlordName");
            String lEmail = request.getParameter("landlordEmail");
            String lAge = request.getParameter("landlordAge");
            String lPhoneNo = request.getParameter("landlordPhoneNo");
            String lGender = request.getParameter("landlordGender");

            //nk testing keluar masuk data pastikan xampp, heroku , database connected

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
            String user = "nhydysucefvvzn"; //ni user dri heroku database
            String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            // klau buat postgress atas2 ni amik yg details dri heroku

            PreparedStatement st;
            String query="UPDATE landlord set landlordusername=?,landlordpassword=?,landlordname=?,landlordemail=?,landlordage=?,landlordphoneno=?,landlordgender=? where landlordid=?)";

            st = conn.prepareStatement(query);
            //paramter tu no column dlm table.sdId1 tu dri nama attribute kat String atas tu
            st.setString(1, String.valueOf(lId));
            st.setString(2,lUsername);
            st.setString(3,lPassword);
            st.setString(4,lName);
            st.setString(5,lEmail);
            st.setString(6,lAge);
            st.setString(7,lPhoneNo);
            st.setString(8,lGender);
            int row= st.executeUpdate();//return no of row effected

            if(row>0){
                out.println("Record update insertedd");
                //response.sendRedirect("landlord-login.jsp");
            }else{
                out.println("Record failed");
            }

        }catch(Exception e){
            out.println(e);
        }
    }
}
