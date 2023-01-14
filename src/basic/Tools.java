package basic;


import basic.battle.Health;

import java.util.Random;
import java.util.Scanner;

import static basic.mysql.UseMysql.equipSql;

/**
 * @author 刘家辉
 */
public class Tools {
    private static  final Random RANDOM =new Random();

    public static int getRandomNum(int min,int max,int levelNum){
      int diff=(max-min)*levelNum;
      if(diff>0){
      return RANDOM.nextInt(diff)+min*levelNum;
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

        return IN.next().charAt(0);
    }
    static final Scanner IN =new Scanner(System.in);
    public static int getInputNumber() {
        return IN.nextInt();
    }
    public static AbstractItem getRandomItem(int levelNum) throws Exception {
        Random r=new Random();
        int num=r.nextInt(10);
        if(num==0) {
            //获得宠物 比例 初级：中级：高级：究极：坤坤or刀酱=25:25:25：20：5
            int odds1=5,odds2=25,odds3=50,odds4=75;
            int rate=Tools.getRandomNum(100);
            if(rate<=odds1){
                if(r.nextInt(10)>odds1){
                    return equipSql(17,1);
                }else {
                    return equipSql(18,1);
                }
            } else if (rate<=odds2) {
                return equipSql(16,1);
            } else if (rate<=odds3) {
                return equipSql(15,1);
            } else if (rate<=odds4) {
                return equipSql(14,1);
            }else {
                return equipSql(13,1);
            }
        }else if(num<=3){
            //装备 比例 武器：铠甲：护腿：鞋子：头盔：项链：手镯：戒指=20：15：15：15：15：10：5：5
            int rate=Tools.getRandomNum(100);
            if(rate<5){
                return equipSql(4,levelNum);
            } else if (rate<10) {
                return equipSql(7,levelNum);
            } else if (rate<20) {
                return equipSql(6,levelNum);
            } else if (rate<35) {
                return equipSql(1,levelNum);
            } else if (rate<50) {
                return equipSql(3,levelNum);
            } else if (rate<65) {
                return equipSql(5,levelNum);
            } else if (rate<80) {
                return equipSql(2,levelNum);
            }else {
                return equipSql(8,levelNum);
            }
        }else {
            //药品
            return new Health(levelNum,10);
        }
    }
}
