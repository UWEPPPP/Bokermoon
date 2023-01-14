package basic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Use_Mysql {
    public static Item equip_sql(int id,int levelnum) throws SQLException, IOException {
        Connection connection= Connect_Mysql.getConnection();
        PreparedStatement prst=connection.prepareStatement("select * from `Equipment&Monster&Pokemon` where id=?");
        prst.setObject(1,id);
        ResultSet set=prst.executeQuery();
        Item item = null;
        if(set.next()){
        if(id>8){
            if (id<=12) {
                 item= new Monster(set.getString("name"), levelnum, set.getInt("at_min"), set.getInt("at_max"), set.getInt("defence_min"), set.getInt("defence_max"), set.getInt("HP_min"), set.getInt("HP_max"));
            }else item= new Pokemon(set.getString("name"),set.getInt("at_min"), set.getInt("defence_min"), set.getInt("HP_min"));
            }else  item= new Equipment(set.getString("name"), levelnum, set.getInt("at_min"), set.getInt("at_max"), set.getInt("defence_min"), set.getInt("defence_max"), set.getInt("HP_min"), set.getInt("HP_max"));
    }
        Connect_Mysql.close(connection,set,prst);
        return item;
    }
}
