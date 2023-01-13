package basic;

import basic.Connect_Mysql;
import basic.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Use_Mysql {
    public static Equipment equip_sql(int id,int levelnum) throws SQLException, ClassNotFoundException {
        Connection connection= Connect_Mysql.getConnection();
        PreparedStatement prst=connection.prepareStatement("select * from Equipment where id=?");
        prst.setObject(1,id);
        ResultSet set=prst.executeQuery();
        return new Equipment(set.getString("name"),levelnum,set.getInt("at_min"),set.getInt("at_max"),set.getInt("defence_min"),set.getInt("defence_max"),set.getInt("HP_min"),set.getInt("HP_max"));
    }
}
