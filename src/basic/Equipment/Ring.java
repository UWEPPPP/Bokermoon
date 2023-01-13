package basic.Equipment;

import basic.Tools;

public class Ring extends Equipment{
    public Ring(int levelNum){
        super("戒指",levelNum);
        this.attack= Tools.getRandomNum(10,40,levelNum);
        this.defense=Tools.getRandomNum(10,40,levelNum);
        this.HP=Tools.getRandomNum(10,40,levelNum);
    }
}
