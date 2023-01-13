package basic.Monster;

import basic.Tools;

public class Ghoul extends Monster{
    public Ghoul(int levelNum) {
        super("食尸鬼", levelNum);
        this.attack= Tools.getRandomNum(60,70,levelNum);
        this.defense=Tools.getRandomNum(50,60,levelNum);
        this.HP=Tools.getRandomNum(900,1100,levelNum);
        this.currentHP=this.HP;
    }

    @Override
    public String getInformation() {
        return discovery ? "C" : "■";
    }
}
