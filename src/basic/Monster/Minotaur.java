package basic.Monster;

import basic.Tools;

public class Minotaur extends Monster{
    public Minotaur(int levelNum) {
        super("牛头怪",levelNum);
        this.attack= Tools.getRandomNum(50,60,levelNum);
        this.defense=Tools.getRandomNum(40,50,levelNum);
        this.HP=Tools.getRandomNum(700,900,levelNum);
        this.currentHP=this.HP;
    }
}
