package MiniProjects.PokemonProject.PokemonCardHands.Program;

import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Energy;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;

import java.io.IOException;
import java.util.Stack;

public class RareCandyHands extends PokemonHands{

    @Override
    public String runProgram(String filePath, int numTrials) throws IOException {
        return "";
    }

    @Override
    public void runTrials(int numTrials) {

    }

    @Override
    public boolean evaluateHand() {
        return false;
    }

    @Override
    public void makeDeck(int pokemonCount, int energyCount, int candyCount) {
        //make a new Deck Object
        Stack<PokemonCard> newDeck = new Stack<>();
        //add pokemon
        for(int i = 0; i < pokemonCount; i++) {
            newDeck.add(new Pokemon());
        }
        //add energy
        for(int i = 0; i < energyCount; i++) {
            newDeck.add(new Pokemon());
        }
        //add rare candy
        for(int i = 0; i < candyCount; i++) {
            newDeck.add(new Pokemon());
        }
        //subtract cardCount from Full Deck Count
        int remainingCount = getFullDeckCount() - newDeck.size();
        //for that amount,
        for(int i = 0; i < remainingCount; i++) {
            //add energy cards to the deck
            newDeck.add(new Energy());
        }
        //set the populated Deck Object as the global
        setDeck(newDeck);
    }

    private PokemonCard[] prizes;
}
