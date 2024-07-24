public abstract class Pokemon {
    private String name;
    private String type;
    private int hp;
    private int attack;

    public Pokemon(String name, String type, int hp, int attack) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void attack(Pokemon target) {
        double effectiveness = getEffectiveness(target.getType());
        int damage = (int) (this.attack * effectiveness);
        System.out.println(this.name + " attacks " + target.getName() + " with " + damage + " damage.");
        target.setHp(target.getHp() - damage);
        System.out.println(target.getName() + " now has " + target.getHp() + " HP left.");
    }

    protected abstract double getEffectiveness(String targetType);
}

public class Pikachu extends Pokemon {
    public Pikachu() {
        super("Pikachu", "Electric", 100, 20);
    }

    @Override
    protected double getEffectiveness(String targetType) {
        if (targetType.equals("Water")) {
            return 2.0; // Double damage to Water types
        } else if (targetType.equals("Grass")) {
            return 0.5; // Half damage to Grass types
        }
        return 1.0; // Normal damage to other types
    }
}

public class Charizard extends Pokemon {
    public Charizard() {
        super("Charizard", "Fire", 150, 30);
    }

    @Override
    protected double getEffectiveness(String targetType) {
        if (targetType.equals("Grass")) {
            return 2.0; // Double damage to Grass types
        } else if (targetType.equals("Water")) {
            return 0.5; // Half damage to Water types
        }
        return 1.0; // Normal damage to other types
    }
}
