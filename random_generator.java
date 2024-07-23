
		
		import java.util.List;
		import java.util.Random;

		public class random_generator {

		    public static void main(String[] args) {
		        Pokedex pokedex = new Pokedex();
		        List<Pokemon> pokemonList = pokedex.getPokedex();

		        // Generate a random Pokémon
		        Random random = new Random();
		        int randomIndex = random.nextInt(pokemonList.size());
		        Pokemon randomPokemon = pokemonList.get(randomIndex);

		        // Display the random Pokémon
		        System.out.println("Randomly selected Pokémon:");
		        System.out.println(randomPokemon);
		    }
		}




