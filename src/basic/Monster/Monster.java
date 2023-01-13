package basic.Monster;
import basic.Item;
import basic.Pokemon.*;
import basic.Tools;

public class Monster extends Item {
    protected int attack;
    protected int defense;
    protected int HP;
    protected int currentHP;

    public int getAttack() {
        return attack;
    }

    public Monster(String name, int levelNum) {
        super(name,levelNum);
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
        return discovery?name:"■";
    }
    public Item drop(){
        return Tools.getRandomItem(levelNum);
    }


}
