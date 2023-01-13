package basic.Monster;

import basic.Tools;

public class Minotaur extends Monster{
    public Minotaur(int levelNum) {
        super("牛头怪",levelNum);
        this.attack= Tools.getRandomNum(40,50,levelNum);
        this.defense=Tools.getRandomNum(35,45,levelNum);
        this.HP=Tools.getRandomNum(600,750,levelNum);
        this.currentHP=this.HP;
    }

    @Override
    public String getInformation() {
        return discovery ? "B" : "■";
    }
}
