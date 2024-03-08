<<<<<<<< HEAD:src/MiniProjects/PokemonProject/PokemonCardHands/Testers/RareCandyHandsTester.java
package MiniProjects.PokemonProject.PokemonCardHands.Testers;
========
package PokemonProjects.PokemonCardHands.TesterAndResults;
>>>>>>>> origin/master:src/PokemonProjects/PokemonCardHands/TesterAndResults/RareCandyHandsTester.java

import PokemonProjects.PokemonCardHands.Program.RareCandyHands;

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
