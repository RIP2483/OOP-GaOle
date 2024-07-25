import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner;
    private Random random;
    private List<Pokemon> wildPokemonList;
    private List<Move> moveList;

    public Game(Player player, List<Pokemon> wildPokemonList, List<Move> moveList) {
        this.player = player;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.wildPokemonList = wildPokemonList;
        this.moveList = moveList;
    }

    public void start() {
        System.out.println("Welcome to Pokémon Ga-Olé!");

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            handleMenuChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("1. Catch Pokémon");
        System.out.println("2. Battle");
        System.out.println("3. View captured Pokémon");
        System.out.println("4. Exit");
    }

    public static void displayMenu() {
        showMenu();
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                catchPokemon();
                break;
            case 2:
                battle();
                break;
            case 3:
                player.ViewCapturedPokemon();
                break;
            case 4:
                System.out.println("Thanks for playing!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void catchPokemon() {
        Pokemon wildPokemon = getRandomPokemon();
        TextUtils.printWithDelay("A wild " + wildPokemon.getName() + " appeared!", 50);

        TextUtils.printWithDelay("Throw a Pokéball? (yes/no)", 50);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            if (wildPokemon.getGrade() == 0) {
                if (random.nextInt(100) < 90) {  // 90% chance to catch
                    player.addPokemon(wildPokemon);
                    TextUtils.printWithDelay("You caught a " + wildPokemon.getName() + "!", 50);
                } else {
                    TextUtils.printWithDelay("Oh no! The " + wildPokemon.getName() + " broke free!", 50);
                }
            } else if (wildPokemon.getGrade() == 1) {
                if (random.nextInt(100) < 70) {  // 70% chance to catch
                    player.addPokemon(wildPokemon);
                    TextUtils.printWithDelay("You caught a " + wildPokemon.getName() + "!", 50);
                } else {
                    TextUtils.printWithDelay("Oh no! The " + wildPokemon.getName() + " broke free!", 50);
                }
            } else if (wildPokemon.getGrade() == 2) {
                if (random.nextInt(100) < 50) {  // 50% chance to catch
                    player.addPokemon(wildPokemon);
                    TextUtils.printWithDelay("You caught a " + wildPokemon.getName() + "!", 50);
                } else {
                    TextUtils.printWithDelay("Oh no! The " + wildPokemon.getName() + " broke free!", 50);
                }
            }
        } else {
            TextUtils.printWithDelay("You ran away safely.", 50);
        }
    }

    private void battle() {
        if (player.getPokemonList().isEmpty()) {
            TextUtils.printWithDelay("You don't have any Pokémon to battle with!", 50);
            return;
        }

        Pokemon opponent = getRandomPokemon();
        TextUtils.printWithDelay("A wild " + opponent.getName() + " appeared!", 50);

        Battle battle = new Battle(opponent, player);
        battle.start();
    }

    private Pokemon getRandomPokemon() {
        int index = random.nextInt(wildPokemonList.size());
        Pokemon wildPokemon = wildPokemonList.get(index);
        if (wildPokemon.getGrade() == 0) {
        
        }
        Pokemon pokemon = new Pokemon(wildPokemon.getId(), wildPokemon.getName(), wildPokemon.getType(), wildPokemon.getHealth(), wildPokemon.getAttack(), wildPokemon.getDefense(), wildPokemon.getSpeed(), wildPokemon.getGrade(), new ArrayList<>());

        // Assign type based moves
        for (int i = 0; i < 3; i++) { // assign 3 moves
            int choice = random.nextInt(moveList.size());
            Move potentialMove = moveList.get(choice);
            if (potentialMove.getType().equals(wildPokemon.getType()) || potentialMove.getType().equals("Normal") && !pokemon.getMoves().contains(potentialMove) ) {
                pokemon.addMove(moveList.get(choice));
            }
            else {
                i--;
            }
        }
        return pokemon;
    }
}
