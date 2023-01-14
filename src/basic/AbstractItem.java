package basic;

/**
 * @author 刘家辉
 */
public abstract class AbstractItem implements ItemRule {
    protected String name;
    protected int levelNum;




    public String getName() {
        return name;
    }

    public void setDiscovery(boolean discovery) {
        this.discovery = discovery;
    }
    protected boolean discovery;
    public AbstractItem(String name){
    this.name=name;
    }
    public AbstractItem(String name, int levelNum) {
        this.name = name;
        this.levelNum = levelNum;
    }

    @Override
    public String getInformation() {
        return "";
    }

    public String getItemInformation(){
        return null;
    }

}
