/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SorceCode;
import java.sql.*;
/**
 *
 * @author mantr
 */
public class JDBC {
    public static void main(String args[]) throws SQLException
    {
       Connection conn1=null;
     Connection conn2=null;
     try{
         conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/dtabase1","root","Mantri@1999");
         if(conn1!=null)
         {
             System.out.println("Connection Successful d1");
         }
     }catch(SQLException e)
     {
         System.out.println("Not connected to database1");
     }
     try{
         conn2=DriverManager.getConnection("jdbc:mysql://localhost:3306/dtabase2","root","Mantri@1999");
         if(conn2!=null)
         {
             System.out.println("Connection Successful d2");
         }
     }catch(SQLException e)
     {
         System.out.println("Not connected to database2");
     }
           String query = "SELECT * FROM players";

         PreparedStatement pst=conn2.prepareStatement(query);
         ResultSet rs = pst.executeQuery();

           while(rs.next())
           {
             
        String firstName = rs.getString("Name");
        int age=rs.getInt("Age");
        String country=rs.getString("Country");
        String position=rs.getString("Position");
        int Pass=rs.getInt("Pass");
        int shoot=rs.getInt("Shoot");
        int tackle=rs.getInt("Tackle");
        
        // print the results
        System.out.format("%s, %d, %s, %s, %d, %d, %d\n", firstName, age, country, position, Pass, shoot, tackle);
      }    
           pst.close();

     
    }
}
