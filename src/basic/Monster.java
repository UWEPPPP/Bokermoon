package basic;

import java.io.IOException;
import java.sql.SQLException;

public class Monster extends Item {
    protected final int attack;
    protected final int defense;
    protected final int HP;
    protected int currentHP;

    public int getAttack() {
        return attack;
    }

    public Monster(String name, int levelNum,int...message) {
        super(name, levelNum);
        this.attack=Tools.getRandomNum(message[0],message[1],levelNum);
        this.defense=Tools.getRandomNum(message[2],message[3],levelNum);
        this.HP=Tools.getRandomNum(message[4],message[5],levelNum);
        this.currentHP=HP;
    }
    @Override
    public String getItemInformation() {
        return name+": 攻击力="+getAttack()+"防御力="+getDefense()+"HP="+getCurrentHP();
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getDefense() {
        return defense;
    }

    public void resume(){
        currentHP = HP;
    }
    public void attackPokemon(Pokemon pokemon){
        int minusHealth = this.attack * this.attack / pokemon.getDefense();
        if(minusHealth == 0) {//伤害为0，需要调整
             minusHealth = 1; //调整伤害为1点
             } else if(minusHealth > pokemon.getCurrentHP()){//如果伤害比宠物 小精灵当前血量还要高
             minusHealth = pokemon.getCurrentHP(); //伤害就应该等于宠物小精 灵当前血量
             }//剩余血量
         int restHealth = pokemon.getCurrentHP() - minusHealth;
        pokemon.setCurrentHP(restHealth);
        System.err.println(name + "对" + pokemon.getName() + "发动攻击，造成 了" + minusHealth + "伤害"); }
    @Override
    public String getInformation() {
        return discovery?switch (name) {
            case "豪猪" -> "猪";
            case "牛头怪" -> "牛";
            case "食尸鬼" -> "尸";
            case "凤凰" -> "风";
            default -> "空";
        }:"■";
    }
    public Item drop() throws SQLException, IOException {
        return Tools.getRandomItem(levelNum);
    }
}
