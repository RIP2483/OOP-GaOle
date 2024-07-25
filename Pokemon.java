import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private int health;
    //private int maxHealth;
    private int attack;
    private int defense;
    private int speed;
    private int grade;
    private List<Move> moves;

    public Pokemon(int id, String name, String type, int health, int attack, int defense, int speed, int grade,  List<Move> moves) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.health = health;
        //this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.grade = grade;
        this.moves = moves;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
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

    public int getGrade() {
        return grade;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setGrade(int grade) {
        this.grade = grade;
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

    //public void heal() {
    //    health = maxHealth;
    //}

    public boolean isFainted() {
        return health <= 0;
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }
}
