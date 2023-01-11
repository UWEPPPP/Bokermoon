package basic.Equipment;

import basic.Tools;

public class Boot extends Equipment{
     public Boot(int levelNum){
         super("靴子",levelNum);
         this.attack=0;
         this.defense= Tools.getRandomNum(10,20,levelNum);
         this.HP=Tools.getRandomNum(80,100,levelNum);
     }
}