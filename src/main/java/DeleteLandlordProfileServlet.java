import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DeleteLandlordProfileServlet", value = "/DeleteLandlordProfileServlet")

public class DeleteLandlordProfileServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String landlordid=request.getParameter("landlordid");
        long id=Long.parseLong(landlordid);
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
                String data = "delete * from  landlord where landlordid='1'";
                statement = conn.createStatement();
                rs = statement.executeQuery(data);

               while (rs.next())
                {
                    out.print("Landlord Idd2: " + rs.getString("landlordid"));
                    out.print("Username: " + rs.getString("landlordusername"));
                    out.print("landlord password :" + rs.getString("landlordpassword"));
                    out.print("landlord name: " + rs.getString("landlordname"));
                    out.print("landlord email: " + rs.getString("landlordemail"));
                    out.print("landlord age: " + rs.getString("landlordage"));
                    out.print("landlord phone: " + rs.getString("landlordphoneno"));
                    out.print("landlord gender: " + rs.getString("landlordgender"));

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
