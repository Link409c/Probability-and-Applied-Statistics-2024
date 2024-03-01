package MiniProjects.PokemonProject.PokemonTCG.TesterAndResults;

import MiniProjects.PokemonProject.PokemonTCG.Program.PokemonGame;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonPlayer;

public class PokemonTCGTester {
    public static void main(String[] args){
        PokemonGame pokemonGame = new PokemonGame();
        PokemonPlayer winner = pokemonGame.runGame();
        System.out.println(winner.getPlayerName() + " wins!");
    }
}
