package basic.Equipment;

import basic.Tools;

public class Bracelet extends Equipment{
    public Bracelet(int levelNum){
        super("手镯",levelNum);
        this.attack= Tools.getRandomNum(25,25,levelNum);
        this.defense=Tools.getRandomNum(25,25,levelNum);
        this.HP=Tools.getRandomNum(25,25,levelNum);
    }
}
