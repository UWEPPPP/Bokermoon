package basic.mysql;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 刘家辉
 */
public  class ConnectMysql {
   public static Connection getConnection() throws SQLException, IOException {
       Properties properties=new Properties();
       FileReader fre=new FileReader("C:\\Users\\刘家辉\\IdeaProjects\\StudentProgramme\\properties");
       properties.load(fre);
       String url= properties.getProperty("URL");
       String username=properties.getProperty("username");
       String password=properties.getProperty("password");
       return DriverManager.getConnection(url,username,password);
   }
   public static void close(Connection connection, ResultSet set, PreparedStatement preparedStatement) throws SQLException {
          if (connection!=null) {
              connection.close();
          }
          if(set!=null) {
              set.close();
          }
          if(preparedStatement!=null) {
              preparedStatement.close();
          }
   }
}
