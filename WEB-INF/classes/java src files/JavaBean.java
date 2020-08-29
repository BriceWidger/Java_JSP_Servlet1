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

public class JavaBean
{
    private String fname;
    private String lname;
    private String country;
    
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(final String Fname) {
        this.fname = Fname;
    }
    
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(final String Lname) {
        this.lname = Lname;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(final String Country) {
        this.country = Country;
    }
    
    public void add2DB() {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            final Statement stmt = con.createStatement();
            final String queryString = "INSERT INTO CUSTOMER VALUES ('" + this.fname + "', '" + this.lname + "', '" + this.country + "')";
            stmt.executeUpdate(queryString);
            stmt.close();
            con.close();
        }
        catch (Exception var4) {
            var4.printStackTrace();
        }
    }
}