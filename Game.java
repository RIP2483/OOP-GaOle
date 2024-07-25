import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Player player;
    private Pokemon opponentPokemon;
    private Scanner scanner;
    private Pokemon playerPokemon;

    public Battle(Pokemon opponentPokemon, Player player) {
        this.opponentPokemon = opponentPokemon;
        this.player = player;
        int pokemonIndex = player.SelectPokemon();
        this.playerPokemon = player.getPokemonList().get(pokemonIndex);
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
        double effectiveness = TypeEffectiveness.getEffectiveness(move.getType(), defender.getType());
        int damage = calculateDamage(move.getPower(), attacker.getAttack(), defender.getDefense(), effectiveness);
        System.out.println(attacker.getName() + " used " + move.getName() + "!");
        System.out.println("It's " + getEffectivenessString(effectiveness) + " effective!");
        defender.takeDamage(damage);
        System.out.println(defender.getName() + " took " + damage + " damage!");
    }

    private int calculateDamage(int power, int attack, int defense, double effectiveness) {
        return (int) (((2 * 50 / 5 + 2) * power * attack / defense / 50 + 2) * effectiveness);
    }

    private String getEffectivenessString(double effectiveness) {
        if (effectiveness > 1) {
            return "super";
        } else if (effectiveness < 1) {
            return "not very";
        } else {
            return "normally";
        }
    }
}
