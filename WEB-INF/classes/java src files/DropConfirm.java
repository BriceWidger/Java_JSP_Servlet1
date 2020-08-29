/*
Brice Widger
6-7-20
Bellevue University
Sources: 
studying others' work in class
Murach's Java Servlets and JSP (3rd Edition)
probably a hundred web pages (too much to list)
*/

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

@WebServlet(urlPatterns = { "/DropConfirm" })
public class DropConfirm extends HttpServlet
{
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        TableDrop();
        request.getRequestDispatcher("/DropConfirm.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
    
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        TableDrop2();
        request.getRequestDispatcher("/DropConfirm.jsp").forward((ServletRequest)request, (ServletResponse)response);
        TableDrop3();
        request.getRequestDispatcher("/DropConfirm.jsp").forward((ServletRequest)request, (ServletResponse)response);
        TableDrop4();
        request.getRequestDispatcher("/DropConfirm.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
    
    public static void TableDrop() {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String[] queryString = { "DROP TABLE StudentClasses" };
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
    
    public static void TableDrop2() {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String[] queryString = { "DROP TABLE STUDENT" };
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
    
    public static void TableDrop3() {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String[] queryString = { "DROP TABLE CLASSES" };
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
    
        public static void TableDrop4() {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String[] queryString = { "DROP TABLE CUSTOMER" };
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