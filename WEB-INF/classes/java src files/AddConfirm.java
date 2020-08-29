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
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import oracle.jdbc.OracleDriver;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = { "/AddConfirm" })
public class AddConfirm extends HttpServlet
{
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        createTables();
        request.getRequestDispatcher("/AddConfirm.jsp").forward((ServletRequest)request, (ServletResponse)response);
        createTables2();
        request.getRequestDispatcher("/AddConfirm.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
    
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        createTables3();
        request.getRequestDispatcher("/AddConfirm.jsp").forward((ServletRequest)request, (ServletResponse)response);
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
            final String[] queryString = { "CREATE TABLE STUDENT(STUDENT_ID varchar(20), FIRST_NAME varchar(25), LAST_NAME varchar(25), PRIMARY KEY (STUDENT_ID))" };
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
    
    public static void createTables2() {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String[] queryString = { "CREATE TABLE CLASSES(CLASS_ID varchar(20), CLASS_NAME varchar(20), PRIMARY KEY (CLASS_ID))" };
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
    
    public static void createTables3() {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String[] queryString = { "CREATE TABLE StudentClasses(STUDENT_ID varchar(20), CLASS_ID varchar(20),\n    PRIMARY KEY (STUDENT_ID, CLASS_ID),\n    FOREIGN KEY (STUDENT_ID) REFERENCES Student,\n    FOREIGN KEY (CLASS_ID) REFERENCES Classes)" };
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