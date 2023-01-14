package basic;


import basic.Battle.HP;
import basic.mysql.Use_Mysql;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import static basic.mysql.Use_Mysql.equip_sql;

public class Tools {
    private static  final Random r=new Random();

    public static int getRandomNum(int min,int max,int levelNum){
      int diff=(max-min)*levelNum;
      if(diff>0){
      return r.nextInt(diff)+min*levelNum;
    }else {
          return 1;
      }
    }
    public static int getRandomNum(int min,int max){
        return getRandomNum(min,max,1);
    }
    public static int getRandomNum(int max){
        return  getRandomNum(0,max);
    }

    public static char getInputChar() {

        return in.next().charAt(0);
    }
    static final Scanner in =new Scanner(System.in);
    public static int getInputNumber() {
        return in.nextInt();
    }
    public static Item getRandomItem(int levelNum) throws SQLException, IOException {
        Random r=new Random();
        int num=r.nextInt(10);
        if(num==0) {
            //获得宠物 比例 初级：中级：高级：究极：坤坤or刀酱=50:30:15：4：1
            int rate=Tools.getRandomNum(100);
            if(rate<=5){
                if(r.nextInt(10)>5){
                    return Use_Mysql.equip_sql(17,1);
                }else return Use_Mysql.equip_sql(18,1);
            } else if (rate<=25) {
                return Use_Mysql.equip_sql(16,1);
            } else if (rate<=50) {
                return Use_Mysql.equip_sql(15,1);
            } else if (rate<=75) {
                return Use_Mysql.equip_sql(14,1);
            }else return Use_Mysql.equip_sql(13,1);
        }else if(num<=3){
            //装备 比例 武器：铠甲：护腿：鞋子：头盔：项链：手镯：戒指=20：15：15：15：15：10：5：5
            int rate=Tools.getRandomNum(100);
            if(rate<5){
                return equip_sql(4,levelNum);
            } else if (rate<10) {
                return equip_sql(7,levelNum);
            } else if (rate<20) {
                return equip_sql(6,levelNum);
            } else if (rate<35) {
                return equip_sql(1,levelNum);
            } else if (rate<50) {
                return equip_sql(3,levelNum);
            } else if (rate<65) {
                return equip_sql(5,levelNum);
            } else if (rate<80) {
                return equip_sql(2,levelNum);
            }else return equip_sql(8,levelNum);
        }else {
            //药品
            return new HP(levelNum,10);
        }
    }
}
