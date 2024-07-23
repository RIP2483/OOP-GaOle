import java.util.List;

public class Pokemon {
    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int speed;
    private List<Move> moves;

    public Pokemon(String name, int health, int attack, int defense, int speed, List<Move> moves) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
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

    public List<Move> getMoves() {
        return moves;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal() {
        health = maxHealth;
    }

    public boolean isFainted() {
        return health <= 0;
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }
}
