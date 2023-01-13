package basic;

public class HP extends Item{
    public int getCount() {
        return count;
    }
    public void addCount(int count){
        this.count+=count;
    }

    private int count;

    public HP(int count,int levelNum) {
        super("天山雪莲",levelNum);
        this.count = count;
    }
    public int use(){
        count--;
        return levelNum*500;
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
