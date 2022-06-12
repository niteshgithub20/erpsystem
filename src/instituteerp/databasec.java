/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituteerp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class databasec {
    
    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
              Class.forName("com.mysql.cj.jdbc.Driver");
            String path="jdbc:mysql://localhost:3306/instituteerp";
            con = DriverManager.getConnection(path,"root","");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }

    static int setAllDetails(String p_name, String p_uname, String p_email, String p_gender, String p_mobile, String p_rg, String p_pass, String p_cpass) {
        
        int i=0;
        try
        {
             Connection con = databasec.getConnection();
            String query= "insert into logindatabase (name,username,email,gender,mobile,register,password,cnfPassword) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p_name);
            ps.setString(2, p_uname);
            ps.setString(3, p_email);
            ps.setString(4, p_gender);
            ps.setString(5, p_mobile);
            ps.setString(6, p_rg);
            ps.setString(7, p_pass);
            ps.setString(8, p_cpass);

            
            i = ps.executeUpdate();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
        
    }

    
}
