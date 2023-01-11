package basic.Equipment;

import basic.Tools;

public class Weapon extends Equipment{
    public Weapon(int levelNum){
        super("武器",levelNum);
        this.attack= Tools.getRandomNum(100,150,levelNum);
        this.defense=0;
        this.HP=Tools.getRandomNum(250,300,levelNum);
    }
}
