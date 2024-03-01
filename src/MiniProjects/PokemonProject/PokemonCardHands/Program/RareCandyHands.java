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
        //run a number of trials for 1, 2, 3, 4 rare candy
    }

    public boolean evaluatePrizes(boolean handEvaluationResult){
        //if the hand does not have a rare candy
            //if the prizes have a rare candy
                //return true
        return false;
    }

    @Override
    public boolean evaluateHand() {
        //if the hand contains a pokemon,
            //if the hand contains a rare candy,
                //return true
        return false;
    }

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

    /**
     * After making the Deck data structure, populates the Prizes
     * array with six cards drawn from the top of the deck.
     */
    public void dealPrizes(){
        //shuffle the deck
        shuffleDeck();
        //get the deck
        Stack<PokemonCard> theDeck = getDeck();
        //pop 6 cards for prizes
        int count = getPrizeCount();
        PokemonCard[] prizes = getPrizes();
        for(int i = 0; i < count; i++){
            prizes[i] = theDeck.pop();
        }
        //set the prizes
        setPrizes(prizes);
        //set the deck
        setDeck(theDeck);
    }

    public RareCandyHands(){
        super();
        setPrizes(new PokemonCard[getPrizeCount()]);
    }

    public PokemonCard[] getPrizes() {
        return prizes;
    }

    public void setPrizes(PokemonCard[] prizes) {
        this.prizes = prizes;
    }

    public int getPrizeCount(){
        return PRIZE_COUNT;
    }

    private PokemonCard[] prizes;

    private static final int PRIZE_COUNT = 6;
}
