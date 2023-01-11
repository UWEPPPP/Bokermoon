package basic.Equipment;

import basic.Tools;

public class Armor extends Equipment{
    public Armor(int levelNum){
        super("铠甲",levelNum);
        this.attack=0;
        this.defense= Tools.getRandomNum(40,50,levelNum);
        this.HP=Tools.getRandomNum(200,250,levelNum);
    }
}
