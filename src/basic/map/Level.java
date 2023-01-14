package basic.map;

/**
 * 水平
 *
 * @author 刘家辉
 * &#064;date  2023/01/14
 */
public class Level {
    private final int num;
    private final Level prevLevel;
    private Level nextLevel;
    private final LevelMap map;


    public Level(Level prevLevel, int num,Level nextLevel) throws Exception {
        this.num = num;
        this.prevLevel = prevLevel;
        this.nextLevel = nextLevel;
        this.map=new LevelMap(num);
    }

    public int getNum() {
        return num;
    }

    public Level getPrevLevel() {
        return prevLevel;
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

}
