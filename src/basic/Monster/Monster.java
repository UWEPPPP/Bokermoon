package basic.Monster;

import basic.Equipment.*;
import basic.HP;
import basic.Item;
import basic.Pokemon.*;
import basic.Tools;

import java.util.Random;

public class Monster extends Item {
    protected int attack;
    protected int defense;
    protected int HP;
    protected int currentHP;

    public Monster(String name,int levelNum) {
        super(name,levelNum);
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void attackPokemon(Pokemon pokemon){
        int reduce=this.attack*this.attack/pokemon.getDefense();
        if(reduce==0){
            reduce=1;
        }
        pokemon.setHP(pokemon.getHP()-reduce);
        System.out.println(name+"对"+pokemon.getName()+"发动攻击，造成了"+reduce+"伤害");
    }
    @Override
    public String getInformation() {
        return discovery?name:"■";
    }
    public Item drop(){
        return Tools.getRandomItem(levelNum);
    }


}
