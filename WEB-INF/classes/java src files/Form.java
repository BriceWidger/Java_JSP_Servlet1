/*
Brice Widger
6-7-20
Bellevue University
Sources: 
studying others' work in class
Murach's Java Servlets and JSP (3rd Edition)
probably a hundred web pages (too much to list)
*/

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import oracle.jdbc.OracleDriver;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = { "/Form" })
public class Form extends HttpServlet
{
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        createTables();
        request.getRequestDispatcher("/Form.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
    
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final JavaBean JavaBean = new JavaBean();
        JavaBean.setFname(request.getParameter("first-name"));
        JavaBean.setLname(request.getParameter("last-name"));
        JavaBean.setCountry(request.getParameter("country"));
        JavaBean.add2DB();
        final ArrayList results = doQuery();
        request.setAttribute("results", (Object)results);
        request.getRequestDispatcher("/BriceWidgerRecords.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
    
    public static void addFormInfo(final String fname, final String lname, final String country) {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String queryString = "INSERT INTO CUSTOMER VALUES ('" + fname + "', '" + lname + "', '" + country + "')";
            stmt.executeUpdate(queryString);
            stmt.close();
            con.close();
        }
        catch (Exception var6) {
            var6.printStackTrace();
        }
    }
    
    public static ArrayList doQuery() {
        final ArrayList ar = new ArrayList();
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String queryString = "SELECT FNAME, LNAME, COUNTRY FROM CUSTOMER ORDER BY FNAME ASC";
            final ResultSet rs = stmt.executeQuery("SELECT FNAME, LNAME, COUNTRY FROM CUSTOMER ORDER BY FNAME ASC");
            final int i = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                final ArrayList ar2 = new ArrayList();
                for (int x = 1; x <= i; ++x) {
                    ar2.add(rs.getString(x));
                }
                ar.add(ar2);
            }
            stmt.close();
            con.close();
        }
        catch (Exception var8) {
            var8.printStackTrace();
        }
        return ar;
    }
    
    public static void createTables() {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String[] queryString = { "CREATE TABLE CUSTOMER ( FNAME VARCHAR(50) NULL, LNAME VARCHAR(50) NULL, COUNTRY VARCHAR(50) NULL, PRIMARY KEY (FNAME))" };
            for (int i = 0; i < queryString.length; ++i) {
                stmt.executeUpdate(queryString[i]);
            }
            stmt.close();
            con.close();
        }
        catch (Exception var4) {
            var4.printStackTrace();
        }
    }
}