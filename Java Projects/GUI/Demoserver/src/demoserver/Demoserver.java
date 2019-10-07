/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoserver;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.sql.*;
import java.util.Random;
/**
 *
 * @author mantr
 */
public class Demoserver {
                 String msg;
                 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
     Connection conn2=null;
     
     try{
         conn2=DriverManager.getConnection("jdbc:mysql://localhost:3306/participant1","root","Mantri@1999");
         if(conn2!=null)
         {
             System.out.println("Connection Successful");
         }
     }catch(SQLException e)
     {
     }     
        try{  Socket s=new Socket("192.168.43.24",1522);        
                 DataOutputStream dout=new DataOutputStream(s.getOutputStream());
              DataInputStream din=new DataInputStream(s.getInputStream());


           String query = "SELECT * FROM team";
try{
         PreparedStatement pst=conn2.prepareStatement(query);
         ResultSet rs = pst.executeQuery();

           while(rs.next())
           {
             
        String firstName = rs.getString("Name");
           dout.writeUTF(firstName+"\n");
             dout.flush();
             
             
            
           // Scanner sc=new Scanner(System.in);
            /*String msg;
            while(true)
            {
               
           
            msg=din.readUTF();
                System.out.println(msg);
            if(msg.equals("-1"))
                break;
            
         
            }*/

             
      }    
          dout.close(); 
           pst.close();
}catch(Exception e)
{
}
                     

            
           
           
            
           
        }catch(Exception e)
        {
            System.out.println(e);
        }
        PreparedStatement pst=null;
        ResultSet rs=null; 
        try{
        Socket s1=new Socket("192.168.43.24",1560);        
             
        DataInputStream din=new DataInputStream(s1.getInputStream());
              String msg;
              msg=din.readUTF();
              if(msg.contains("scored"))
              {
                  String l[]=msg.split(" ");
                  String scored=l[3]+" "+l[4];
                  String query="Update team set Points=Points+3 where Name=?";
                  pst = conn2.prepareStatement(query);
                  pst.setString(1,scored);
           
           pst.executeUpdate(); 
              } System.out.println(msg);
              /*String query = "SELECT * FROM team";

     pst=conn2.prepareStatement(query);
     rs = pst.executeQuery();
               while(rs.next())
           {
             
        String firstName = rs.getString("Name");
      
       
        String position=rs.getString("Position");
        int P=rs.getInt("Points");
        double pr=rs.getInt("price");
        
        // print the results
        System.out.format("%s,%s, %d, %f\n", firstName, position, P, pr);
      }    */
               
           
    }catch(Exception e)
    {
        
    }
        try{
        Socket s2=new Socket("192.168.43.24",1559);        
             
        DataInputStream din=new DataInputStream(s2.getInputStream());
              String msg;
              msg=din.readUTF();
              if(msg.contains("Assist"))
              {
                 String  l2[]=msg.split(" ");
                 
                  String query="Update team set Points=(Points+4) where Name=?";
                  pst = conn2.prepareStatement(query);
            pst.setString(1,l2[2]);
           pst.executeUpdate();
                  
           
              }
                System.out.println(msg);
           
    }catch(Exception e)
    {
        
    }   
    try{
        Socket s3=new Socket("192.168.43.24",1558);        
             
        DataInputStream din=new DataInputStream(s3.getInputStream());
              String msg;
              msg=din.readUTF();
              if(msg.contains("Yellow"))
              {
                 String  l4[]=msg.split(" ");
                  String scored2=l4[3]+" "+l4[4];
                  String query="Update team set Points=(Points-2) where Name=?";
                  pst = conn2.prepareStatement(query);
            pst.setString(1,scored2);
           pst.executeUpdate();
                  
           
              }
                System.out.println(msg);
           
    }catch(Exception e)
    {
        
    }   
    try{
        Socket s4=new Socket("192.168.43.24",1557);        
             
        DataInputStream din=new DataInputStream(s4.getInputStream());
              String msg;
              msg=din.readUTF();
              if(msg.contains("Red"))
              {
                 String  l5[]=msg.split(" ");
                  String scored3=l5[3]+" "+l5[4];
                  String query="Update team set Points=(Points-4) where Name=?";
                  pst = conn2.prepareStatement(query);
            pst.setString(1,scored3);
           pst.executeUpdate();
                  
           
              }
                System.out.println(msg);
           
    }catch(Exception e)
    {
        
    }   
    }}
