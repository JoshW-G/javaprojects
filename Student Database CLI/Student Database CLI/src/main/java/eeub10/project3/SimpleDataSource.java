package eeub10.project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
   A simple data source for getting database connections.
*/
public class SimpleDataSource
{
   /**
      Initializes the data source.
      @param stream the name of the property file that
      contains the database driver, url, username and password
    */
   public static void init(InputStream stream)
      throws IOException, ClassNotFoundException
   {
      Properties props = new Properties();
      InputStream in = stream;
      props.load(in);

      String driver = props.getProperty("jdbc.driver");
      url = props.getProperty("jdbc.url");
      username = props.getProperty("jdbc.username");
      password = props.getProperty("jdbc.password");

      Class.forName(driver);
   }

   /**
      Gets a connection to the database.
      @return the database connection
   */
   public static Connection getConnection() throws SQLException
   {
      return DriverManager.getConnection(url, 
         username, password);
   }

   private static String url;
   private static String username;
   private static String password;
}