package PokemonProjects.PokemonCardHands.Testers;

import PokemonProjects.PokemonCardHands.Program.PokemonHands;

import java.io.IOException;

public class PokemonCardHandsTester {

    public static void main(String[] args){
        PokemonHands pkmn = new PokemonHands();
        //declare file path for intended result directory
        String filePath = "C:\\Users\\cdsim\\IdeaProjects\\Probability-and-Applied-Statistics" +
                "-2024\\src\\MiniProjects\\PokemonProject" +
                "\\PokemonCardHands\\TesterAndResults";
        //declare trials to run
        int numTrials = 10000;
        try{
            System.out.println(pkmn.runProgram(filePath, numTrials));
        }catch(IOException i){
            i.printStackTrace();
        }
    }
}
