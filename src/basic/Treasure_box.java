package basic;

public class Treasure_box extends Item {
    public Treasure_box(int levelNum) {
        super("宝箱", levelNum);
    }
    @Override
    public String getInformation() {
        return discovery ? "⭐" : "■";
    }
    public Item open(){ return Tools.getRandomItem(levelNum); }
}