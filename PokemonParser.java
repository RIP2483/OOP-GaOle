import java.util.ArrayList;
import java.util.List;

public class PokemonParser {
    public static List<Pokemon> parsePokemonData(String filePath) {
        List<String[]> data = CSVReader.readCSV(filePath);
        List<Pokemon> pokemonList = new ArrayList<>();

        for (String[] row : data) {
            String name = row[1];
            int hp = Integer.parseInt(row[3]);
            int attack = Integer.parseInt(row[4]);
            int defense = Integer.parseInt(row[5]);
            int speed = Integer.parseInt(row[6]);

            pokemonList.add(new Pokemon(name, hp, attack, defense, speed, new ArrayList<>()));
        }
        return pokemonList;
    }
}
