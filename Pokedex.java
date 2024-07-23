
import java.util.ArrayList;
import java.util.List;

class Pokemon {
    private int id;
    private String name;
    private String type;

    public Pokemon(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    @Override
    public String toString() {
        return "Pokemon ID: " + id + ", Name: " + name + ", Type: " + type;
    }
}



public class Pokedex {
    private List<Pokemon> pokedex;

    public Pokedex() {
        pokedex = new ArrayList<>();
        initializePokedex();
    }

    private void initializePokedex() {
        // Adding the first 30 Kanto Pokémon
        pokedex.add(new Pokemon(1, "Bulbasaur", "Grass/Poison"));
        pokedex.add(new Pokemon(2, "Ivysaur", "Grass/Poison"));
        pokedex.add(new Pokemon(3, "Venusaur", "Grass/Poison"));
        pokedex.add(new Pokemon(4, "Charmander", "Fire"));
        pokedex.add(new Pokemon(5, "Charmeleon", "Fire"));
        pokedex.add(new Pokemon(6, "Charizard", "Fire/Flying"));
        pokedex.add(new Pokemon(7, "Squirtle", "Water"));
        pokedex.add(new Pokemon(8, "Wartortle", "Water"));
        pokedex.add(new Pokemon(9, "Blastoise", "Water"));
        pokedex.add(new Pokemon(10, "Caterpie", "Bug"));
        pokedex.add(new Pokemon(11, "Metapod", "Bug"));
        pokedex.add(new Pokemon(12, "Butterfree", "Bug/Flying"));
        pokedex.add(new Pokemon(13, "Weedle", "Bug/Poison"));
        pokedex.add(new Pokemon(14, "Kakuna", "Bug/Poison"));
        pokedex.add(new Pokemon(15, "Beedrill", "Bug/Poison"));
        pokedex.add(new Pokemon(16, "Pidgey", "Normal/Flying"));
        pokedex.add(new Pokemon(17, "Pidgeotto", "Normal/Flying"));
        pokedex.add(new Pokemon(18, "Pidgeot", "Normal/Flying"));
        pokedex.add(new Pokemon(19, "Rattata", "Normal"));
        pokedex.add(new Pokemon(20, "Raticate", "Normal"));
        pokedex.add(new Pokemon(21, "Spearow", "Normal/Flying"));
        pokedex.add(new Pokemon(22, "Fearow", "Normal/Flying"));
        pokedex.add(new Pokemon(23, "Ekans", "Poison"));
        pokedex.add(new Pokemon(24, "Arbok", "Poison"));
        pokedex.add(new Pokemon(25, "Pikachu", "Electric"));
        pokedex.add(new Pokemon(26, "Raichu", "Electric"));
        pokedex.add(new Pokemon(27, "Sandshrew", "Ground"));
        pokedex.add(new Pokemon(28, "Sandslash", "Ground"));
        pokedex.add(new Pokemon(29, "Nidoran♀", "Poison"));
        pokedex.add(new Pokemon(30, "Nidorina", "Poison"));

        // Adding Garchomp
        pokedex.add(new Pokemon(445, "Garchomp", "Dragon/Ground"));
    }

    public List<Pokemon> getPokedex() {
        return pokedex;
    }


    }

