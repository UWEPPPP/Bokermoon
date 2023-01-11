package basic;

import java.util.Random;

public class Tools {
    private static  final Random r=new Random();
    public static int getRandomNum(int min,int max,int levelNum){
      int diff=(max-min)*levelNum;
      return r.nextInt(diff)+min*levelNum;
    }
    public static int getRandomNum(int min,int max){
        return getRandomNum(min,max,1);
    }
    public static int getRandomNum(int max){
        return  getRandomNum(0,max);
    }
}
