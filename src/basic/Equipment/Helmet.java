package basic.Equipment;

import basic.Equipment.Equipment;
import basic.Tools;

public class Helmet extends Equipment {
    public Helmet(int levelNum) {
        super("头盔", levelNum);
        attack=0;
        defense= Tools.getRandomNum(20,30,levelNum);
        HP=Tools.getRandomNum(100,150,levelNum);
    }
}
