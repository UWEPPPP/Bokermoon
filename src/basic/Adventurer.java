package basic;

import basic.Equipment.Equipment;
import basic.Monster.Monster;
import basic.Pokemon.Pokemon;
import basic.Pokemon.The_seed_of_the_wonderful_frog;

import java.io.IOException;
import java.util.Arrays;

public class Adventurer extends Item{
    private Equipment[] equipment={};
    private  HP[] hps=new HP[3];
    private Pokemon[] pokemons={new The_seed_of_the_wonderful_frog()};
    private Level currentLevel;
    public Adventurer() {
        super("冒险家");
    }
    public void start() throws InterruptedException {
        currentLevel = new Level(null, 1, null);
        LevelMap map = currentLevel.getMap();
        //冒险家进入地图
        map.addAdventurer(this);
        while (true) {
            currentLevel.getMap().show();
            System.out.println("请选择移动方向：W(上)、A(左)、S(下)、D(右)、E(退 出)");
            char direct = Tools.getInputChar();
            Item item = discovery(direct);
            if (direct == 'E') {
                //退出
                System.out.println("确定要退出吗？ Y/N");
                char quit = Tools.getInputChar();
                if (Character.toUpperCase(quit) == 'Y') {
                    System.out.println("感谢使用宠物小精灵闯关");
                    break;
                }
            } else {
                if (item != null) {
                    item.setDiscovery(true);
                    currentLevel.getMap().show();
                }
                if (item instanceof Treasure_box) {
                    processTreasure((Treasure_box) item, direct);
                } else if (item instanceof Monster) {
                processMonster((Monster) item, direct);
            } else if (item instanceof Portal) {
                System.out.println("发现传送门，是否通过？ Y/N");
            char pass = Tools.getInputChar();
            if (Character.toUpperCase(pass) == 'Y') {
                if (((Portal) item).isNext()) {
                    Level nextLevel = currentLevel.getNextLevel();
                if (nextLevel == null) {
                    nextLevel = new Level(currentLevel, currentLevel.getNum() + 1, null);
                    //将冒险家加载至地图中
                    nextLevel.getMap().addAdventurer(this);
                    //当前关卡的下一关卡即为新创建的关卡
                     currentLevel.setNextLevel(nextLevel); }
                //经过传送门后，下一关卡即为当前关卡
                     currentLevel = nextLevel;
                } else {//通往上一关卡的传送门
                     Level prevLevel = currentLevel.getPrevLevel();
                     if(prevLevel == null){
                         System.out.println("非法操作");
                     } else { currentLevel = prevLevel; } } } } else {
                //其他情况
                move(item,direct); } } } }

        private void processMonster (Monster monster,char direct) throws InterruptedException {
            System.out.println("发现" + monster.getName() + "，是否清除？ Y/N");
            char clear = Tools.getInputChar();
            if (Character.toUpperCase(clear) == 'Y') {
                for (int i = 0; i < pokemons.length; i++) {
                    System.out.println((i + 1) + "\t" + pokemons[i].getItemInformation());
                }
                System.out.println("请选择出战宠物小精灵：");
                int number = Tools.getInputNumber();
                Pokemon pokemon = pokemons[number - 1];
                while (monster.getCurrentHP() > 0 && pokemon.getCurrentHP() > 0) {
                    //获取宠物小精灵的剩余生命值的比例
                    double rate = pokemon.HPbili();
                    if (rate < 0.5) {//生命值低于50%，询问是否使用药品
                        System.out.println(pokemon.getName() + "生命值低于50%， 是否使用药品？ Y/N");
                        char eatHp = Tools.getInputChar();
                        if (Character.toUpperCase(eatHp) == 'Y') {
                            HP hp = getCurrentLevelHP();
                            if (hp == null) {
                                System.out.println("背包中没有可用药品，请探索其他地 图");
                            } else { //如果药品可以被销毁，说明没有可用数量
                                if (hp.enduranceZero()) {
                                    int index = -1;
                                    for (int i = 0; i < hps.length; i++) {
                                        if(hps[i]!=null) {
                                            index = i;
                                            break;
                                        }
                                    }
                                    System.arraycopy(hps, index + 1, hps, index, hps.length - index - 1);
                                    System.out.println("药品已经使用殆尽");
                                } else {
                                    int health = hp.use();
                                    System.out.println("恢复了"+health+"血量");
                                    pokemon.setCurrentHP(pokemon.getCurrentHP() + health);
                                }
                            }
                        }
                    }
                    System.out.println(pokemon.getItemInformation());
                    pokemon.attackMonster(monster);
                    Thread.sleep(500);
                    System.out.println(monster.getItemInformation());
                    monster.attackPokemon(pokemon);
                    Thread.sleep(500);
                }
                //怪物已被击败
                if (monster.getCurrentHP() == 0) {
                    System.out.println("怪物已被击败");
                    //怪物掉落物品
                    Item dropItem = monster.drop();
                    //展示获取的物品信息
                    System.out.println("怪物已被击败，掉落" + dropItem.getItemInformation());
                    processItem(dropItem);
                    Thread.sleep(1000);
                    //怪物被击败后
                    move(monster,direct);
                } else {//宠物小精灵被击败
                    monster.resume();
                    //怪物回血
                    System.out.println(pokemon.getName() + "已被击败");Thread.sleep(1000);
                }
            }
        }
        private HP getCurrentLevelHP (){
            for (int i=0;i<hps.length;i++){
                if(hps[i]!=null){
                    HP hp=hps[i];
                    hps[i]=null;
                    return hp;
                }
            }
            return null;
        }
        private void processItem (Item item) {
            if (item instanceof HP) {
                //药品
                for (int i=0;i<hps.length;i++){
                    if(hps[i]==null) hps[i] = new HP(1, 10);
                }
            } else if (item instanceof Equipment) {
                //装备
                System.out.println("发现新的装备，是否给宠物小精灵更换？ Y/N");
                char change = Tools.getInputChar();
                if (Character.toUpperCase(change) == 'Y') {
                    Equipment old = null;
                    for (Pokemon pokemon : pokemons) {
                        //小精灵更换装备
                        old = pokemon.replaceEquipment((Equipment) item);
                        //如果换下来的装备为空，说明后面的小精灵不需要再看
                        if (old == null) break;
                    }
                    //如果换下来的旧装备不为空，直接放入背包中
                    if (old != null) {
                        equipment = Arrays.copyOf(equipment, equipment.length + 1);
                        equipment[equipment.length - 1] = old;
                    }
                }
            } else {
                //宠物小精灵
                int index = -1;
                for (int i = 0; i < pokemons.length; i++) {
                    if (item.getClass() == pokemons[i].getClass()) {
                        index = i;
                        break;
                    }
                }
                //不存在同类型宠物小精灵
                if (index == -1) {
                    pokemons = Arrays.copyOf(pokemons, pokemons.length + 1);
                    pokemons[pokemons.length - 1] = (Pokemon) item;
                } else {
                    //存在同类型宠物小精灵
                    System.out.println("发现可融合宠物小精灵，是否融合？ Y/N");
                    char merge = Tools.getInputChar();
                    if (Character.toUpperCase(merge) == 'Y') {
                        pokemons[index].merge((Pokemon) item);
                    } else {//不融合，直接放入背包
                        pokemons = Arrays.copyOf(pokemons, pokemons.length + 1);
                        pokemons[pokemons.length - 1] = (Pokemon) item;
                    }
                }
            }
        }
        private void processTreasure (Treasure_box treasure,char direct) throws InterruptedException {
            System.out.println("发现宝箱，是否打开？ Y/N");
            char open = Tools.getInputChar();
            if (Character.toUpperCase(open) == 'Y') {
                //开启宝箱获得一个物品
                Item item = treasure.open();
                //展示获取的物品信息
                System.out.println("获得" + item.getItemInformation());
                Thread.sleep(500);
                processItem(item); //宝箱处理后，冒险家移动至宝箱的位置
                move(item,direct);
            }
        }
        private Item discovery ( char direct){
            return (Item) currentLevel.getMap().getPositionItem(Character.toUpperCase(direct));
        }
        private void move (Item items,char direct){
            currentLevel.getMap().move(items,Character.toUpperCase(direct));
        }
    @Override
    public String getInformation() {
        return "□";
    }
}
