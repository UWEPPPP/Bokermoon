package basic.map;

import basic.AbstractItem;

/**
 * @author 刘家辉
 */
public class Portal extends AbstractItem {
    private final boolean next;
    @Override
    public String getInformation() {
        if(discovery) {
            return next ?"➡":"⬅";
        }
        return "■";
    }

    @Override
    public void setDiscovery(boolean discovery) {
        super.setDiscovery(discovery);
    }
    public Portal(boolean next ){
        super("传送门");
        //调用父类只有一个参数的构造方法
        this.next=next;
    }
    public boolean isNext() {
        return next;
    }
}
