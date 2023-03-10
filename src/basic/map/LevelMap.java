package basic.map;

import basic.*;

import basic.battle.TreasureBox;
import basic.mysql.UseMysql;

/**
 * @author 刘家辉
 */
public class LevelMap {
    private int currentRow, currentCol;
    private final int num;
    private final ItemRule[][] item=new ItemRule[9][9];
    private void generate() throws Exception {
        if(num == 1){
            //第一关卡 //第二个位置为初级怪物象牙猪
            item[0][1] = UseMysql.equipSql(9, num);
            item[0][0] = UseMysql.equipSql(9, num);
        } else {//其他关卡 //第一个位置为返回上一层的传送门
            item[0][0] = new Portal(false);
            item[0][1] = new Portal(false); }
        //记录生成的宝箱数量
        int generatedTreasure = 0;
        int generatedMonster1 = 0;
        //记录生成的初级怪物数量
        int generatedMonster2 = 0;
        //记录生成的中级级怪物数量
        int generatedMonster3 = 0;
        //记录生成的高级怪物数量
        int generatedMonster4 = 0;
        //记录生成的究级怪物数量
        // 记录生成的传送门数量
        int generatedPortal = 0;
        int produceMax=39;
        while (generatedTreasure < produceMax || (generatedMonster1 + generatedMonster2 + generatedMonster3 + generatedMonster4) < produceMax || generatedPortal == 0){
            //获取随机坐标
            int index = Tools.getRandomNum(2, 81);
            int row = index / item[0].length;
            int col = index % item[0].length;
            //目标位置已经有物品存在
            if(item[row][col]!= null) {
                continue;
            }
            //获取一个随机数
             int rate = Tools.getRandomNum(79);
             if(rate == 0){
                 // 传送门
                 // 传送门已经生成了，直接跳过
                 if(generatedPortal == 1) {
                     continue;
                 }
                 item[row][col] = new Portal(true); generatedPortal += 1;
             } else if(rate < 40){
                 //宝箱
                 // 宝箱已经全部生成完毕，直接跳过
                 if(generatedTreasure == 39) {
                     continue;
                 }
                 item[row][col] = new TreasureBox(num);
                 generatedTreasure++; } else {//怪物 初级：中级：高级：究级 = 18:12:6:3
                  int num1 = Tools.getRandomNum(39);
                  if(num1 < 3){
                      //究级怪物
                      // 究级怪物已经全部生成完毕，直接跳过
                      if(generatedMonster4 == 3) {
                          continue;
                      }
                      item[row][col] = UseMysql.equipSql(12, num); generatedMonster4 += 1;
                  } else if(num1 < 9){
                      //高级怪物
                      // 高级怪物已经全部生成完毕，直接跳过
                      if(generatedMonster3 == 6) {
                          continue;
                      }
                      item[row][col] = UseMysql.equipSql(11, num); generatedMonster3 += 1;
                  } else if(num1 < 21){
                      //中级怪物
                      // 中级怪物已经全部生成完毕，直接跳过
                      if(generatedMonster2 == 12) {
                          continue;
                      }
                      item[row][col] = UseMysql.equipSql(10, num); generatedMonster2 += 1;
                  } else {
                      //初级怪物
                      // 初级怪物已经全部生成完毕，直接跳过
                      if(generatedMonster1 == 18) {
                          continue;
                      }
                      item[row][col] = UseMysql.equipSql(9, num); generatedMonster1 += 1;
                  } }

        } }

    public LevelMap(int num) throws Exception {
        this.num = num;
        generate();
    }
    public void show(){
        System.out.println("宠物小精灵第" + num + "关：");
    for(int i=0; i<item.length; i++){
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        for(int j=0; j<item[i].length; j++){
        String info = " ";
    if(item[i][j] != null){
        info = item[i][j].getInformation();
     }if(i == 0){
        //第一行
     if(j == 0){
         //第一列
          line1.append("┌───"); line2.append("│ ").append(info).append(" ");
     } else if(j == item[i].length-1){
         //最后一列
        line1.append("┬───┐"); line2.append("│ ").append(info).append(" │");
     } else { line1.append("┬───"); line2.append("│ ").append(info).append(" ");
     } } else { if(j == 0){
         //第一列
         line1.append("├───"); line2.append("│ ").append(info).append(" ");
     } else if(j == item[i].length-1){
         //最后一列
        line1.append("┼───┤"); line2.append("│ ").append(info).append(" │");
     } else { line1.append("┼───"); line2.append("│ ").append(info).append(" ");
     } } }System.out.println(line1); System.out.println(line2);
}
        StringBuilder lastLine = new StringBuilder();
//最后一行网格线
     for(int i=0;i<item[0].length; i++){ if(i==0){
    //第一列
        lastLine.append("└───");
} else if(i == item[0].length -1){
    //最后一列
        lastLine.append("┴───┘");
} else { lastLine.append("┴───"); }} System.out.println(lastLine); }

       public void addAdventurer(Adventurer adventurer){
           currentRow = 0;
           if(num == 1){
               currentCol = 0;
           } else {
               currentCol = 1;
           }item[currentRow][currentCol] = adventurer;
       }
    public ItemRule getPositionItem(char direct) throws InterruptedException { int targetRow = currentRow, targetCol = currentCol;
        switch (direct) {
            case 'W' -> {
                Thread.sleep(300);
                if (targetRow == 0) {
                    return null;
                }
                targetRow -= 1;
            }
            case 'A' -> {
                Thread.sleep(300);
                if (targetCol == 0) {
                    return null;
                }
                targetCol -= 1;
            }
            case 'S' -> {
                Thread.sleep(300);
                if (targetRow == item.length - 1) {
                    return null;
                }
                targetRow += 1;
            }
            case 'D' -> {
                Thread.sleep(300);
                if (targetCol == item[currentRow].length - 1) {
                    return null;
                }
                targetCol += 1;
            }
            default -> {
                System.out.println("输入无效");
                getPositionItem(direct);
            }
        }
        return item[targetRow][targetCol]; }
    public void move( char direct){
        int oldRow = currentRow,oldCol = currentCol;
        AbstractItem adventurer = (AbstractItem) item[oldRow][oldCol];
        switch (direct) {
            case 'W' -> {
                if (currentRow == 0) {
                    System.err.println("非法移动");
                    return;
                }
                currentRow -= 1;
            }
            case 'A' -> {
                if (currentCol == 0) {
                    System.err.println("非法移动");
                    return;
                }
                currentCol -= 1;
            }
            case 'S' -> {
                if (currentRow == item.length - 1) {
                    System.err.println("非法移动");
                    return;
                }
                currentRow += 1;
            }
            case 'D' -> {
                if (currentCol == item[currentRow].length - 1) {
                    System.err.println("非法移动");
                    return;
                }
                currentCol += 1;
            }
            default -> {
                System.out.println("输入错误");
                move(direct);
            }
        }
        item[currentRow][currentCol] = adventurer; item[oldRow][oldCol] = new AbstractItem("空地",1) {
            @Override
            public String getItemInformation() {
                return "一片空地";
            }    };
    }
    }

