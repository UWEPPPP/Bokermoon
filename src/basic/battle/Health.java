package basic.battle;

import basic.AbstractItem;


/**
 * @author 刘家辉
 */
public class Health extends AbstractItem {

    private int count;

    public Health(int count,int levelNum) {
        super("天山雪莲",levelNum);
        this.count = count;
    }
    public int use(){
        count--;
        return levelNum*50;
    }
    public boolean enduranceZero(){
        return count == 0;

    }
    @Override
    public String getInformation() {
        return "🌼";
    }

    @Override
    public String getItemInformation() {
        return name;
    }
}
