package basic;

import basic.Equipment.*;
import basic.Pokemon.*;

import java.util.LinkedHashSet;
import java.util.Random;

public class Treasure_box extends Item {
    public Treasure_box(String name, int levelNum) {
        super("宝箱", levelNum);
    }

    @Override
    public String getInformation() {
        return discovery ? "⚪" : "■";
    }

}