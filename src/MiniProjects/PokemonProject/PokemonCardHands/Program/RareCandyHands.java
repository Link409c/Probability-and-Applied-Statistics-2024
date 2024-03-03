package MiniProjects.PokemonProject.PokemonCardHands.Program;

import MiniProjects.PokemonProject.PokemonCardHands.Structures.CandyHandResult;
import MiniProjects.PokemonProject.PokemonTCG.Structures.Items.RareCandy;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Energy;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import StatsLibrary.StatsLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class RareCandyHands extends PokemonHands{

    @Override
    public String runProgram(String filePath, int numTrials) throws IOException {
        return "";
    }

    public void runTrials(int numTrials, StatsLibrary statalyzer) {
        //run a number of trials for 1, 2, 3, 4 rare candy
        //rare candy count
        int candyCount = 0;
        //initial probability of success
        double successRate;
        double brickRate;
        //tracking successes in each trial run
        int successes;
        //tracking candy location in each trial run
        int bricks;
        //tracking hand result for each run
        boolean handResult;
        //get accurate rare candy count in deck
        if(getDeck() != null) {
            for (PokemonCard c : getDeck()) {
                if (c.getClass() == RareCandy.class) {
                    candyCount++;
                }
            }
        }
        //run the program for
        while(candyCount < 5) {
            shuffleDeck();
            successes = bricks = 0;
            //run a number of trials to get hand results
            for(int i = 0; i < numTrials; i++){
                //draw a hand
                drawHand(getHandSize());
                //evaluate
                handResult = evaluateHand();
                //if hand has no rare candy,
                if(!handResult){
                    //if no rare candy in prizes,
                    if(!evaluatePrizes(false)){
                        //neither event occurs.
                        continue;
                    }else{
                        //else increment bricks
                        bricks++;
                    }
                }else{
                    //else increment successes
                    successes++;
                }
                //reset the deck
                for(PokemonCard c : getTheHand()){
                    getDeck().add(c);
                }
                for(PokemonCard c : getPrizes()){
                    getDeck().add(c);
                }
                //shuffle and repeat
                shuffleDeck();
            }
            //calculate the chance of success
            successRate = (double) successes / numTrials;
            brickRate = (double) bricks / numTrials;
            getTheResults().add(new CandyHandResult(candyCount, successRate,
                    candyCount, brickRate));
            /*
            System.out.println(getTheResults().getLast().getNumPokemon() + ", "
                    + getTheResults().getLast().getSuccessRate());
            */
            candyCount++;
            int pokemonCount = 0, energyCount = 0;
            for(PokemonCard c : getDeck()){
                if(c.getClass() == Pokemon.class){
                    pokemonCount++;
                }
                else if(c.getClass() == Energy.class){
                    energyCount++;
                }
            }
            makeDeck(pokemonCount, energyCount, candyCount);
        }
    }

    public boolean evaluatePrizes(boolean handEvaluationResult) {
        //if the hand does not have a rare candy
        if (!handEvaluationResult) {
            //if the prizes have a rare candy
            for (PokemonCard c : getPrizes()) {
                //return true
                if(c.getClass() == RareCandy.class) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean evaluateHand() {
        boolean hasPokemon = false;
        boolean hasCandy = false;
        //check the cards in the hand
        for (PokemonCard c : getTheHand()) {
            //track if hand has a Pokemon
            if(c.getClass() == Pokemon.class){
                hasPokemon = true;
            }
            //track if hand has a Rare Candy
            if(c.getClass() == RareCandy.class){
                hasCandy = true;
            }
        }
        //return true if hand has both cards
        return hasPokemon && hasCandy;
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
            newDeck.add(new Energy());
        }
        //add rare candy
        for(int i = 0; i < candyCount; i++) {
            newDeck.add(new RareCandy());
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

    public RareCandyHands(Stack<PokemonCard> aDeck, int pokemonCount, int energyCount,
                          int candyCount, int handSize){
        //if the passed deck is not null,
        if(aDeck != null){
            //set it as the deck
            setDeck(aDeck);
        //otherwise
        }else {
            //make a deck data structure
            makeDeck(pokemonCount, energyCount, candyCount);
        }
        //set hand size
        setHandSize(handSize);
        //set hand as new arraylist
        setTheHand(new ArrayList<>());
        //set the results to an empty arraylist
        setTheResults(new ArrayList<>());
        //set prizes as new array
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