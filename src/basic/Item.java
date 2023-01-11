package basic;

public abstract class Item implements Item_rule{
    protected  String name;
    protected int levelNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
