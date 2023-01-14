package basic.Battle;

import basic.Item;
import basic.Tools;

import java.io.IOException;
import java.sql.SQLException;

public class Treasure_box extends Item {
    public Treasure_box(int levelNum) {
        super("宝箱", levelNum);
    }
    @Override
    public String getInformation() {
        return discovery ? "⭐" : "■";
    }
    public Item open() throws SQLException, IOException { return Tools.getRandomItem(levelNum); }
}