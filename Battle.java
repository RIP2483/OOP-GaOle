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
        TextUtils.printWithDelay("Battle start!");
        TextUtils.printWithDelay(playerPokemon.getName() + " vs " + opponentPokemon.getName());
    
        while (!playerPokemon.isFainted() && !opponentPokemon.isFainted()) {
            playerTurn();
            if (opponentPokemon.isFainted()) {
                TextUtils.printWithDelay(opponentPokemon.getName() + " fainted! " + playerPokemon.getName() + " wins!");
                return;
            }
    
            try {
                Thread.sleep(1000); // Used to make a delay bw moves, DONT FORGET
            } catch (InterruptedException e) {
                System.out.println("Battle interrupted!");
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
    
            opponentTurn();
            if (playerPokemon.isFainted()) {
                TextUtils.printWithDelay(playerPokemon.getName() + " fainted! " + opponentPokemon.getName() + " wins!");
                return;
            }
    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Battle interrupted!");
                Thread.currentThread().interrupt();
            }
        }
    }

    private void playerTurn() {
        TextUtils.printWithDelay("Choose a move:");
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
        TextUtils.printWithDelay(attacker.getName() + " used " + move.getName() + "!");
        System.out.println("");
        TextUtils.printWithDelay("It's " + getEffectivenessString(effectiveness) + " effective!");
        System.out.println("");
        defender.takeDamage(damage);
        TextUtils.printWithDelay(defender.getName() + " took " + damage + " damage!");
        System.out.println("");
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
