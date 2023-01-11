package basic;

public class Monster extends Item{
    public Monster(String name, int levelNum) {
        super(name, levelNum);
    }

    @Override
    public String getInformation() {
        return discovery?name:"■";
    }
}
