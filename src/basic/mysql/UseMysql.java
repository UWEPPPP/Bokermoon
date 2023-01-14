package basic.mysql;

import basic.AbstractItem;
import basic.battle.Equipment;
import basic.battle.Monster;
import basic.battle.Pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 刘家辉
 */
public class UseMysql {
    public static AbstractItem equipSql(int id, int levelnum) throws Exception {
        Connection connection= ConnectMysql.getConnection();
        PreparedStatement prst=connection.prepareStatement("select * from `Equipment&Monster&Pokemon` where id=?");
        prst.setObject(1,id);
        ResultSet set=prst.executeQuery();
        AbstractItem item = null;
        if(set.next()){
        if(id>8){
            if (id<=12) {
                 item= new Monster(set.getString("name"), levelnum, set.getInt("at_min"), set.getInt("at_max"), set.getInt("defence_min"), set.getInt("defence_max"), set.getInt("HP_min"), set.getInt("HP_max"));
            }else {
                item= new Pokemon(set.getString("name"),set.getInt("at_min"), set.getInt("defence_min"), set.getInt("HP_min"));
            }
            }else {
            item= new Equipment(set.getString("name"), levelnum, set.getInt("at_min"), set.getInt("at_max"), set.getInt("defence_min"), set.getInt("defence_max"), set.getInt("HP_min"), set.getInt("HP_max"));
        }
    }
        ConnectMysql.close(connection,set,prst);
        return item;
    }
}
