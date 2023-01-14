package basic;

public abstract class Item implements Item_rule{
    protected final String name;
    protected int levelNum;

    @Override
    public String getInformation() {
        return " ";
    }

    public String getName() {
        return name;
    }

    public void setDiscovery(boolean discovery) {
        this.discovery = discovery;
    }
    protected boolean discovery;
    public Item(String name){
    this.name=name;
    }
    public Item(String name, int levelNum) {
        this.name = name;
        this.levelNum = levelNum;
    }

    public String getItemInformation(){
        return null;
    }

}
