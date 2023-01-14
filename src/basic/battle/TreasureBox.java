package basic.battle;

import basic.AbstractItem;
import basic.Tools;

/**
 * @author 刘家辉
 */
public class TreasureBox extends AbstractItem {
    public TreasureBox(int levelNum) {
        super("宝箱", levelNum);
    }
    @Override
    public String getInformation() {
        return discovery ? "⭐" : "■";
    }
    public AbstractItem open() throws Exception { return Tools.getRandomItem(levelNum); }
}