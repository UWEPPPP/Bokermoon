package basic.battle;

import basic.AbstractItem;
import basic.Tools;

import java.util.Objects;

/**
 * @author 刘家辉
 */
public  class Equipment extends AbstractItem {
    protected final int attack;
    /**
     * 国防
     */
    protected final int defense;
    //防御力

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return HP;
    }

    protected final int HP;

    /**
     * 设备
     *
     * @param name     名字
     * @param levelNum 关卡号
     * @param message  消息
     */
    public Equipment(String name, int levelNum,int...message) {
        super(name, levelNum);
        this.attack= Tools.getRandomNum(message[0],message[1],levelNum);
        this.defense=Tools.getRandomNum(message[2],message[3],levelNum);
        this.HP=Tools.getRandomNum(message[4],message[5],levelNum);
    }

    @Override
    public String getInformation() {
        return "🔪";
    }

    @Override
    public String getItemInformation() {
        return toString();
    }

    @Override
    public String toString() {
        return name+
                "：攻击力=" + attack +
                "防御力=" + defense +
                ", HP=" + HP
                ;
    }
    public boolean compareBetter(Equipment other){
        if(Objects.equals(this.getClass(), other.getClass())){
            int total1=this.attack+this.defense>>1+this.HP>>1;
            int total2=other.getAttack()+other.getDefense()>>1+other.getHealth()>>1;
            return total1<total2;
        }
        return false;
    }
}
