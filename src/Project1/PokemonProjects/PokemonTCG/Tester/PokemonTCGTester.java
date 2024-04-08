package Project1.PokemonProjects.PokemonTCG.Tester;

import Project1.PokemonProjects.PokemonTCG.Program.PokemonGame;
import Project1.PokemonProjects.PokemonTCG.Structures.MainSuperClasses.PokemonPlayer;

public class PokemonTCGTester {
    public static void main(String[] args){
        PokemonGame pokemonGame = new PokemonGame();
        PokemonPlayer winner = pokemonGame.runGame();
        System.out.println(winner.getPlayerName() + " wins!");
    }
}
