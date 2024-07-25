import java.util.List;

public class PokemonGame {
    public static void main(String[] args) {
        List<Pokemon> wildPokemonList = PokemonParser.parsePokemonData("C:\\Users\\ashar\\Desktop\\Uni work\\Sem 2\\OOP\\final assignment\\final project\\src\\pokemon.csv");
        List<Move> moveList = MoveParser.parseMoveData("C:\\Users\\ashar\\Desktop\\Uni work\\Sem 2\\OOP\\final assignment\\final project\\src\\moves.csv");

        // Pokemon pikachu = new Pokemon("Pikachu", 100, 55, 40, 90, List.of(new Move("Thunder Shock", 40), new Move("Quick Attack", 30)));
        Player player = new Player("Ash");
        //player.addPokemon(pikachu);

        Game game = new Game(player, wildPokemonList, moveList);
        game.start();
    }
}
