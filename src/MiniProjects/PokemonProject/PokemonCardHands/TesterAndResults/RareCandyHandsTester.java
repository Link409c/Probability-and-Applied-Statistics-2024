package MiniProjects.PokemonProject.PokemonCardHands.TesterAndResults;

import MiniProjects.PokemonProject.PokemonCardHands.Program.RareCandyHands;

import java.io.IOException;

public class RareCandyHandsTester {
    public static void main(String[] args){
        RareCandyHands rch = new RareCandyHands();
        //declare filepath for results
        String filePath = "E:\\Coding Projects\\Probability and Applied Statistics Spring 2024\\src\\" +
                "MiniProjects\\PokemonProject\\PokemonCardHands\\TesterAndResults";
        //number of runs for each amount of rare candy
        int numTrials = 10000;
        try{
            System.out.println(rch.runProgram(filePath, numTrials));
        }catch(IOException i){
            i.printStackTrace();
        }
    }
}
