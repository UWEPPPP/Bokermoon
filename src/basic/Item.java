package basic;
import basic.Equipment.*;
import basic.Pokemon.*;
import java.util.Random;

public abstract class Item implements Item_rule{
    protected final String name;
    protected int levelNum;

    public int getLevelNum() {
        return levelNum;
    }

    @Override
    public String getInformation() {
        return " ";
    }

    public String getName() {
        return name;
    }

    public void setDiscovery(boolean discovery) {
        this.discovery = discovery;
    }
    protected boolean discovery;
    public Item(String name){
    this.name=name;
    }
    public Item(String name, int levelNum) {
        this.name = name;
        this.levelNum = levelNum;
    }
    public static Item getRandomItem(int levelNum){
        Random r=new Random();
        int num=r.nextInt(10);
        if(num==0) {
            //获得宠物 比例 初级：中级：高级：究极：坤坤or刀酱=50:30:15：4：1
            int rate=Tools.getRandomNum(100);
            if(rate==0){
                if(r.nextInt(10)>5){
                    return new Cai_Xukun_The_Answer();
                }else return new KnifeJANG();
            } else if (rate<=4) {
                return new Pikachu();
            } else if (rate<=20) {
                return new Little_fire_dragon();
            } else if (rate<=50) {
                return new Ray_fairy();
            }else return new The_seed_of_the_wonderful_frog();
        }else if(num<=3){
            //装备 比例 武器：铠甲：护腿：鞋子：头盔：项链：手镯：戒指=20：15：15：15：15：10：5：5
            int rate=Tools.getRandomNum(100);
            if(rate<5){
                return new Ring(levelNum);
            } else if (rate<10) {
                return new Bracelet(levelNum);
            } else if (rate<20) {
                return new Necklace(levelNum);
            } else if (rate<35) {
                return new Helmet(levelNum);
            } else if (rate<50) {
                return new Boot(levelNum);
            } else if (rate<65) {
                return new Gaiter(levelNum);
            } else if (rate<80) {
                return new Armor(levelNum);
            }else return new Weapon(levelNum);
        }else {
            //药品
            return new HP(levelNum,10);
        }
    }
    public String getItemInformation(){
        return null;
    }

}
