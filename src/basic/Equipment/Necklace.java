package basic.Equipment;

import basic.Tools;

public class Necklace extends Equipment{
    public Necklace(int levelNum){
        super("项链",levelNum);
        this.attack= Tools.getRandomNum(25,40,levelNum);
        this.defense=Tools.getRandomNum(25,40,levelNum);
        this.HP=Tools.getRandomNum(120,180,levelNum);
    }
}
