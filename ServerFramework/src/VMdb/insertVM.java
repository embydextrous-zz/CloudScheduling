/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VMdb;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import VMdb.DatabaseInfo.*;
/**
 *
 * @author Prashant Mishra
 */
public class insertVM {
    
    Connection conn = null;
    Statement stmt = null;
    public insertVM()
    {
      try
      {
         //STEP 2: Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         //STEP 3: Open a connection
         System.out.println("Connecting to a selected database...");
         conn = DriverManager.getConnection(DatabaseInfo.DB_URL, DatabaseInfo.USER, DatabaseInfo.PASS);
         System.out.println("Connected database successfully...");
      
         //STEP 4: Execute a query
         System.out.println("Inserting records into the table...");
         stmt = (Statement) conn.createStatement();
       }
      catch(Exception e)
      {
          System.err.println("err"+e);
      }
    }
    public void insertQuery(String Query)
    {
        
    }
}
