package basic.Pokemon;

import basic.Item;
import basic.Pokemon.Pokemon;

public class Monster extends Pokemon {
    public Monster(String name, int levelNum) {
        super(name);
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
}
