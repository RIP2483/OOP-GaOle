import java.util.ArrayList;
import java.util.List;

public class PokemonParser {
    public static List<Pokemon> parsePokemonData(String filePath) {
        List<String[]> data = CSVReader.readCSV(filePath);
        List<Pokemon> pokemonList = new ArrayList<>();

        for (String[] row : data) {
            int id = Integer.parseInt(row[0]);
            String name = row[1];
            String type = row[2];
            int hp = Integer.parseInt(row[3]);
            int attack = Integer.parseInt(row[4]);
            int defense = Integer.parseInt(row[5]);
            int speed = Integer.parseInt(row[6]);
            int grade = Integer.parseInt(row[7]);

            pokemonList.add(new Pokemon(id, name, type, hp, attack, defense, speed, grade,  new ArrayList<>()));
        }
        return pokemonList;
    }
}
