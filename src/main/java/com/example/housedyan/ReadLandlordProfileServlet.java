package com.example.housedyan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "ReadLandlordProfileServlet", value = "/ReadLandlordProfileServlet")
public class ReadLandlordProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

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
        CreateAccount readAccount= new CreateAccount(lId,lUsername,lPassword,lName,lEmail,lAge,lPhoneNo,lGender);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}

