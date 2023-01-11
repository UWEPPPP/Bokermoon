package basic.Equipment;

import basic.Tools;

public class Gaiter extends Equipment {
    public Gaiter(int levelNum){
        super("护腿",levelNum);
        this.attack=0;
        this.defense= Tools.getRandomNum(30,40,levelNum);
        this.HP=Tools.getRandomNum(150,200,levelNum);
    }

}
