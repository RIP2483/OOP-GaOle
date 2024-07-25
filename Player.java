import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private List<Pokemon> pokemonList;

    public Player(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void ViewCapturedPokemon() {
        if (pokemonList.isEmpty()) {
            TextUtils.printWithDelay("You have not captured any Pokemon yet.");
        }
        else {
            TextUtils.printWithDelay("Captured Pokemon: ");
            for (Pokemon pokemon : pokemonList) {
                System.out.println(pokemon.getName());
            }
        }
    }

    public int SelectPokemon() {
        TextUtils.printWithDelay("Choose your Pokemon (or enter 0 to return to the menu): ");
        for (int i = 0; i < pokemonList.size(); i++) {
            System.out.println((i + 1) + ". " + pokemonList.get(i).getName());
        }

        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice == 0) {
                    TextUtils.printWithDelay("Returning to the menu...");
                    Game.displayMenu();
                }
                if (choice < 1 || choice > pokemonList.size()) {
                    TextUtils.printWithDelay("Invalid choice. Please choose a number between 1 and " + pokemonList.size() + " or 0 to return to the menu.");
                    continue;
                }
                int index = choice - 1;
                if (pokemonList.get(index).getHealth() == 0) {
                    TextUtils.printWithDelay("This Pokemon has fainted. Please choose another Pokemon.");
                    continue;
                }
                return index;
            } catch (Exception e) {
                TextUtils.printWithDelay("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}
