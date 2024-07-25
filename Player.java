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
            System.out.println("You have not captured any Pokemon yet.");
        }
        else {
            System.out.println("Captured Pokemon: ");
            for (Pokemon pokemon : pokemonList) {
                System.out.println(pokemon.getName());
            }
        }
    }

    public int SelectPokemon() {
        System.out.println("Choose your Pokemon: ");
        for (int i = 0; i < pokemonList.size(); i++) {
            System.out.println(i + 1 + ". " + pokemonList.get(i).getName());
        }
        int choice = scanner.nextInt();
        int index = choice - 1;
        return index;
    }
}
