package com.example.housedyan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "InsertLandlordProfileServlet", value = "/InsertLandlordProfileServlet")
public class InsertLandlordProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(); // if nk wujudkan session mcm sir buat

        // tarik value dri form dalam jsp lalu kot javascript bawah tu
        String lId = (String) session.getAttribute("landlordId");
        String lUsername = (String) session.getAttribute("landlordUsername");
        String lPassword = (String) session.getAttribute("landlordPassword");
        String lName = (String) session.getAttribute("landlordName");
        String lEmail = (String) session.getAttribute("landlordEmail");
        String lAge = (String) session.getAttribute("landlordAge");
        String lPhoneNo = (String) session.getAttribute("landordPhoneNo");
        String lGender = (String) session.getAttribute("landlordGender");

        //masukkan value ke dlm java class StudentDetails
        CreateAccount createAccount = new CreateAccount(lId,lUsername,lPassword,lName,lEmail,lAge,lPhoneNo,lGender);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{
            //  dlm parameter ni pastikan nama sama dalam form jsp name=""
            String sdID1   = request.getParameter("stuid");
            String sdhMP   = request.getParameter("stuname");
            String SdEmail = request.getParameter("email");
            String PhoneNum = request.getParameter ("phonenum");

            String lId = request.getParameter("landlordId");
            String lUsername = request.getParameter("landlordUsername");
            String lPassword = request.getParameter("landlordPassword");
            String lName = request.getParameter("landlordName");
            String lEmail = request.getParameter("landlordEmail");
            String lAge = request.getParameter("landlordAge");
            String lPhoneNo = request.getParameter("landordPhoneNo");
            String lGender = request.getParameter("landlordGender");

            //nk testing keluar masuk data pastikan xampp, heroku , database connected

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-34-194-171-47.compute-1.amazonaws.com:5432/d6u31lk8tofpbt"; //ni url dri heroku database
            String user = "nhydysucefvvzn"; //ni user dri heroku database
            String pass = "d91c6a95779ab44ec2939ae0225389a20d7129541e10791714dbf4f165e0d078"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            // klau buat postgress atas2 ni amik yg details dri heroku

            PreparedStatement st;
            String query="insert into landlord(landlordId,landlordUsername,landlordPassword,landlordUsername,landlordEmail,landlordAge,landlordPhoneNo,landlordGender)" +
                         " values(?,?,?,?,?,?,?,?)";

            st = conn.prepareStatement(query);
            st.setString(1,lId); //paramter tu no column dlm table.sdId1 tu dri nama attribute kat String atas tu
            st.setString(2,lUsername);
            st.setString(3,lPassword);
            st.setString(4,lName);
            st.setString(5,lEmail);
            st.setString(6,lAge);
            st.setString(7,lPhoneNo);
            st.setString(8,lGender);
            int row= st.executeUpdate();//return no of row effected

            if(row>0){
                out.println("Record inserted");
            }else{
                out.println("Record failed");
            }

        }catch(Exception e){
            out.println(e);
        }
    }
}
