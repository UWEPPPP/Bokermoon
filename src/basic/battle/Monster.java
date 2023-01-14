package basic.battle;

import basic.AbstractItem;
import basic.Tools;

/**
 * @author 刘家辉
 */
public class Monster extends AbstractItem {
    protected final int attack;
    protected final int defense;
    protected final int Health;
    protected int currentHealth;

    public int getAttack() {
        return attack;
    }

    public Monster(String name, int levelNum,int...message) {
        super(name, levelNum);
        this.attack= Tools.getRandomNum(message[0],message[1],levelNum);
        this.defense=Tools.getRandomNum(message[2],message[3],levelNum);
        this.Health=Tools.getRandomNum(message[4],message[5],levelNum);
        this.currentHealth=Health;
    }
    @Override
    public String getItemInformation() {
        return name+": 攻击力="+getAttack()+"防御力="+getDefense()+"HP="+getCurrentHealth();
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getDefense() {
        return defense;
    }

    public void resume(){
        currentHealth = Health;
    }
    public void attackPokemon(Pokemon pokemon){
        int minusHealth = this.attack * this.attack / pokemon.getDefense();
        if(minusHealth == 0) {
            //伤害为0，需要调整
             minusHealth = 1;
             //调整伤害为1点
             } else if(minusHealth > pokemon.getCurrentHealth()){
            //如果伤害比宠物 小精灵当前血量还要高
             minusHealth = pokemon.getCurrentHealth();
             //伤害就应该等于宠物小精 灵当前血量
             }//剩余血量
         int restHealth = pokemon.getCurrentHealth() - minusHealth;
        pokemon.setCurrentHealth(restHealth);
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
    public AbstractItem drop() throws Exception {
        return Tools.getRandomItem(levelNum);
    }
}
