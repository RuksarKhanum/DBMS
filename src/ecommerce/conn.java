package ecommerce;
import java.sql.*;

public class conn 
 {
   
   
   
   public conn()
   {
       Connection con=null;
      try
       {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql:///ecommerce","root","Ruk@413255");
       }
      catch(Exception ex)
      {
         System.out.println("Error");
      }
   } 
   
   public static void main(String[] args)
   {
       
   }
 }
