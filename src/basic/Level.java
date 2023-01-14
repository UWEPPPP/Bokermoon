package basic;

import java.io.IOException;
import java.sql.SQLException;

public class Level {
    private final int num;
    private final Level prevLevel;
    private Level nextLevel;
    private final LevelMap map;


    public Level(Level prevLevel, int num,Level nextLevel) throws SQLException, IOException {
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
