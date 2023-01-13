package basic.Monster;

import basic.Tools;

public class Porcupine extends Monster{
    public Porcupine(int levelNum) {
        super("豪猪",levelNum);
        this.attack= Tools.getRandomNum(45,55,levelNum);
        this.defense=Tools.getRandomNum(35,45,levelNum);
        this.HP=Tools.getRandomNum(600,800,levelNum);
        this.currentHP=this.HP;
    }

    @Override
    public String getInformation() {
        return discovery ? "A" : "■";
    }
}
