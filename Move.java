public class Move {
    private String name;
    private int power;
    private String type;

    public Move(String name, int power, String type) {
        this.name = name;
        this.power = power;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override

    public String toString() {
        return "Move{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", type='" + type + '\'' +
                '}';
    }
}
