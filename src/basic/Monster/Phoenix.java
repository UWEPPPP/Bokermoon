package basic.Monster;

import basic.Tools;

public class Phoenix extends Monster{
    public Phoenix(int levelNum) {
        super("凤凰", levelNum);
        this.attack= Tools.getRandomNum(100,120,levelNum);
        this.defense=Tools.getRandomNum(100,120,levelNum);
        this.HP=Tools.getRandomNum(1800,2200,levelNum);
        this.currentHP=this.HP;
    }

    @Override
    public String getInformation() {
        return discovery ? "D" : "■";
    }
}
