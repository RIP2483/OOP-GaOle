public class Battle {
    public static void main(String[] args) {
        Pokemon pikachu = new Pikachu();
        Pokemon charizard = new Charizard();

        System.out.println("Battle Start!");
        System.out.println(pikachu.getName() + " vs " + charizard.getName());

        while (pikachu.getHp() > 0 && charizard.getHp() > 0) {
            pikachu.attack(charizard);
            if (charizard.getHp() <= 0) {
                System.out.println(charizard.getName() + " is defeated!");
                break;
            }

            charizard.attack(pikachu);
            if (pikachu.getHp() <= 0) {
                System.out.println(pikachu.getName() + " is defeated!");
                break;
            }
        }

        System.out.println("Battle End!");
    }
}
