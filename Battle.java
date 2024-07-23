import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Pokemon playerPokemon;
    private Pokemon opponentPokemon;
    private Scanner scanner;

    public Battle(Pokemon playerPokemon, Pokemon opponentPokemon) {
        this.playerPokemon = playerPokemon;
        this.opponentPokemon = opponentPokemon;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Battle start!");
        System.out.println(playerPokemon.getName() + " vs " + opponentPokemon.getName());

        while (!playerPokemon.isFainted() && !opponentPokemon.isFainted()) {
            playerTurn();
            if (opponentPokemon.isFainted()) {
                System.out.println(opponentPokemon.getName() + " fainted! " + playerPokemon.getName() + " wins!");
                return;
            }

            opponentTurn();
            if (playerPokemon.isFainted()) {
                System.out.println(playerPokemon.getName() + " fainted! " + opponentPokemon.getName() + " wins!");
                return;
            }
        }
    }

    private void playerTurn() {
        System.out.println("Choose a move:");
        for (int i = 0; i < playerPokemon.getMoves().size(); i++) {
            System.out.println((i + 1) + ". " + playerPokemon.getMoves().get(i).getName());
        }
        int choice = scanner.nextInt();
        Move move = playerPokemon.getMoves().get(choice - 1);
        useMove(playerPokemon, opponentPokemon, move);
    }

    private void opponentTurn() {
        Random random = new Random();
        int choice = random.nextInt(opponentPokemon.getMoves().size());
        Move move = opponentPokemon.getMoves().get(choice);
        useMove(opponentPokemon, playerPokemon, move);
    }

    private void useMove(Pokemon attacker, Pokemon defender, Move move) {
        int damage = (attacker.getAttack() * move.getPower()) / defender.getDefense();
        System.out.println(attacker.getName() + " used " + move.getName() + "!");
        defender.takeDamage(damage);
        System.out.println(defender.getName() + " took " + damage + " damage!");
    }
}
