package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public  class Connect_Mysql {
   public static Connection getConnection() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       String url = "jdbc:mysql://192.168.56.129:3306";
       String username="liu";
       String password="liujiahui1Y!";
       return DriverManager.getConnection(url,username,password);
   }
   public void close(){

   }
}
