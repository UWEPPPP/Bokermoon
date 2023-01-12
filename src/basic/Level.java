package basic;

public class Level {
    private int num;
    private Level prevLevel;
    private Level nextLevel;
    private LevelMap map;


    public Level(int num, Level prevLevel, Level nextLevel) {
        this.num = num;
        this.prevLevel = prevLevel;
        this.nextLevel = nextLevel;
        this.map=new LevelMap(num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Level getPrevLevel() {
        return prevLevel;
    }

    public void setPrevLevel(Level prevLevel) {
        this.prevLevel = prevLevel;
    }

    public Level getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Level nextLevel) {
        this.nextLevel = nextLevel;
    }

    public LevelMap getMap() {
        return map;
    }

    public void setMap(LevelMap map) {
        this.map = map;
    }
}
