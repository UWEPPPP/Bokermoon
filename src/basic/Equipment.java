package basic;

import java.util.Objects;

public  class Equipment extends Item {
    protected int attack;//攻击力
    protected int defense;//防御力

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHP() {
        return HP;
    }

    protected int HP;//生命值
    public Equipment(String name, int levelNum,int...message) {
        super(name, levelNum);
        this.attack=Tools.getRandomNum(message[0],message[1],levelNum);
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
            int total2=other.getAttack()+other.getDefense()>>1+other.getHP()>>1;
            return total1<total2;
        }
        return false;
    }
}
