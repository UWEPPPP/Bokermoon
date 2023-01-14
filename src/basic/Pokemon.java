package basic;

public class Pokemon extends Item {

    protected   int attack;
    protected   int defense;
    protected int HP;
    protected int currentHP;
    public float HPbili(){
        float HP1=currentHP;
        float HP2=HP;
        return HP1/HP2;
    }
    private int star=1;
    public int getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    private final Equipment[] equipment=new Equipment[8];
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

    public Pokemon(String name,int...message) {
        super(name);
        this.attack=message[0];
        this.defense=message[1];
        this.HP=message[2];
        this.currentHP=HP;
    }

    @Override
    public String getInformation() {
        return "🧝‍";
    }

    @Override
    public String getItemInformation() {
        return "⭐级为"+star+" "+name+": 攻击力="+getAttack()+"防御力="+getDefense()+"HP="+getCurrentHP();
    }

    public void merge(Pokemon other){
        this.attack+=(other.attack>>2);
        this.defense+=(other.defense>>2);
        this.HP+=(other.HP>>1);
        star++;
        System.out.println("融合成功,精灵的最新属性如下");
        System.out.println(getItemInformation());
    }
    public Equipment replaceEquipment(Equipment newEquipment){
        int index;
        switch (newEquipment.getName()) {
            case "头盔" -> index = 0;
            case "靴子" -> index = 1;
            case "武器" -> index = 2;
            case "手镯" -> index = 3;
            case "项链" -> index = 4;
            case "戒指" -> index = 5;
            case "护腿" -> index = 6;
            case "铠甲" -> index = 7;
            default -> throw new IllegalStateException("Unexpected value: " + newEquipment.getName());
        }
        Equipment old=equipment[index];
        if(old==null||old.compareBetter(newEquipment)){//未穿戴装备与新装备好的情况
            equipment[index]=newEquipment;
        }else old=newEquipment;
        return old;
    }
    public void attackMonster(Monster monster){
        int minusHealth = this.attack * this.attack / monster.getDefense();
        if(minusHealth == 0) {//伤害为0，需要调整
             minusHealth = 1; //调整伤害为1点
             } else if(minusHealth > monster.getCurrentHP()){
            //如果伤害比怪物 当前血量还要高
            minusHealth = monster.getCurrentHP(); //伤害就应该等于怪物当前 血量
             }//剩余血量
            int restHealth = monster.getCurrentHP() - minusHealth;
        monster.setCurrentHP(restHealth);
        System.out.println(name + "对" + monster.getName() + "发动攻击，造成 了" + minusHealth + "伤害");
    }
        }

