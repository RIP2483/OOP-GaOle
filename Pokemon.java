public class Pokemon {
    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    
    public Pokemon(String name, String type, int hp, int attack, int defense, int speed) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void attack(Pokemon enemy) {
        int damage = this.attack - enemy.getDefense();
        if (damage < 0) {
            damage = 0;
        }
        enemy.setHp(enemy.getHp() - damage);
    }

    public boolean isFainted() {
        return this.hp == 0;
    }
}
