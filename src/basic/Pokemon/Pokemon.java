package basic.Pokemon;
import basic.Equipment.*;
import basic.Item;
public class Pokemon extends Item {
    public int getAttack() {
        int total=attack;
        for (Equipment equipment1: equipment) {
            if(equipment1!=null)total+=equipment1.getAttack();
        } return total;
    }

    public int getDefense() {
        int total=defense;
        for (Equipment equipment1: equipment) {
            if(equipment1!=null)total+=equipment1.getDefense();
        } return total;
    }

    public int getHP() {
        int total=HP;
        for (Equipment equipment1: equipment) {
            if(equipment1!=null)total+=equipment1.getHP();
        } return total;
    }
    protected   int attack;
    protected   int defense;
    protected int HP;
    private int star=1;
    private Equipment[] equipment=new Equipment[8];

    public Pokemon(String name) {
        super(name);
    }

    @Override
    public String getInformation() {
        return name+": 攻击力="+getAttack()+"防御力="+getDefense()+"HP="+getHP();
    }
    public void merge(Pokemon other){
        this.attack+=(other.attack>>2);
        this.defense+=(other.defense>>2);
        this.HP+=(other.HP>>1);
        star++;
        System.out.println("融合成功,精灵的最新属性如下");
        System.out.println(getInformation());
    }
    public Equipment replaceEquipment(Equipment newEquipment){
        int index;
        if(newEquipment instanceof Helmet){
            index=0;
        }else if(newEquipment instanceof Armor){
            index=1;
        }else if(newEquipment instanceof Gaiter){
            index=2;
        } else if (newEquipment instanceof Boot) {
            index=3;
        } else if (newEquipment instanceof Weapon) {
            index=4;
        } else if (newEquipment instanceof  Necklace) {
            index=5;
        } else if (newEquipment instanceof  Ring) {
            index=6;
        }else index=7;
        Equipment old=equipment[index];
        if(old==null||old.compareBetter(newEquipment)){//未穿戴装备与新装备好的情况
            equipment[index]=newEquipment;
        }else old=newEquipment;
        return old;
    }

}
