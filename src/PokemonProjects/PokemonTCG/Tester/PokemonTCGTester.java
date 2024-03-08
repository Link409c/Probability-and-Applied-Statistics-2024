package PokemonProjects.PokemonTCG.Tester;

import PokemonProjects.PokemonTCG.Program.PokemonGame;
import PokemonProjects.PokemonTCG.Structures.MainSuperClasses.PokemonPlayer;

public class PokemonTCGTester {
    public static void main(String[] args){
        PokemonGame pokemonGame = new PokemonGame();
        PokemonPlayer winner = pokemonGame.runGame();
        System.out.println(winner.getPlayerName() + " wins!");
    }
}
