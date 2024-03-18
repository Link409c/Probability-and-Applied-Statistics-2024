package PokemonProjects.PokemonCardHands.Program;

import PokemonProjects.PokemonCardHands.Structures.CandyHandResult;
import PokemonProjects.PokemonTCG.Structures.Items.RareCandy;
import PokemonProjects.PokemonTCG.Structures.MainSuperClasses.Energy;
import PokemonProjects.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import PokemonProjects.PokemonTCG.Structures.MainSuperClasses.PokemonCard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
* Rare Candy Hands Program is a subclass of the Pokemon Hands Program. Much like the
* previous program, this one too aims to determine optimal ratios of certain cards in
* a Pokemon Deck. For this program, the aim is to determine the probability of drawing
* both a "Rare Candy" and a "Charizard" or "Given you draw a Charizard, what is the
* probability you draw a Rare Candy?". Probabilities are altered by changing the amount
* of Pokemon and Rare Candy in the deck until an optimal probability is found. The program
* also determines the probability that, given you do NOT draw a Rare Candy, it is in the 
* Prize Pile.
*/

public class RareCandyHands extends PokemonHands{

    /**
     * runs the appropriate number of trials and writes the results to a file.
     * @param filePath the directory to save the output file.
     * @param numTrials the intended number of trials to run for each ratio
     *                  of rare candy objects in the deck.
     * @return calls the exportObjects method, which will produce a status message
     * for the user.
     * @throws IOException if the filepath is invalid.
     */
    @Override
    public String runProgram(String filePath, int numTrials) throws IOException {
        //run the appropriate amount of trials
        runTrials(numTrials);
        //export the results
        filePath = filePath.concat("\\RareCandyHandsTest");
        filePath = addIdentifier(filePath);
        filePath = addFileType(filePath);
        return exportObjects(filePath);
    }

    /**
     * Run a number of trials to calculate the chances of success and bricking.
     * Success is defined as seeing a hand which contains a Pokemon and a Rare Candy.
     * Bricking is defined as having no Rare Candy in the hand, and seeing one in the Prizes.
     * @param numTrials the amount of hands to draw for each ratio of Rare Candy in the deck.
     */
    @Override
    public void runTrials(int numTrials) {
        //rare candy count
        int candyCount = count(getDeck(), new RareCandy());
        //probability of success (rare candy and pokemon in hand)
        double successRate;
        //probability of brick (rare candy in prizes)
        double brickRate;
        //tracking successes in each trial run
        int successes;
        //tracking bricks in each trial run
        int bricks;
        //tracking hand result for each run
        boolean handResult;
        //run the program for up to 4 copies of rare candy
        while(candyCount < 5) {
            shuffleDeck();
            successes = bricks = 0;
            //run a number of trials to get hand results
            for(int i = 0; i < numTrials; i++){
                //deal the prizes
                dealPrizes();
                //then draw a hand
                drawHand(getHandSize());
                //evaluate
                handResult = evaluateHand();
                //if hand has no rare candy,
                if(!handResult){
                    //if rare candy in prizes,
                    if(evaluatePrizes(false)) {
                        //increment bricks
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
            //calculate the chance of a brick
            brickRate = (double) bricks / numTrials;
            //get accurate pokemon count
            int pokemonCount = count(getDeck(), new Pokemon());
            //add to results
            getCandyResults().add(new CandyHandResult(pokemonCount, successRate,
                    candyCount, brickRate));
            //after a set of trials, increment candy count
            candyCount++;
            //get accurate energy count
            int energyCount = count(getDeck(), new Energy());
            //make a new deck for next run of trials
            makeDeck(pokemonCount, energyCount, candyCount);
        }
    }

    /**
     * Determines if the Prize Cards contain a Rare Candy card.
     * @param handEvaluationResult the result of seeing a Rare Candy in the hand.
     * @return True if a Rare Candy exists in the Prizes without being in the hand.
     * False otherwise.
     */
    public boolean evaluatePrizes(boolean handEvaluationResult) {
        //if the hand does not have a rare candy & pokemon
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

    /**
     * Determines if the hand contains both a Pokemon and a Rare Candy.
     * @return The logical AND of two variables representing truth values
     * for seeing a Pokemon in the hand and a Rare Candy in the hand.
     */
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

    /**
     * Populates a Stack Data Structure with passed amounts of card objects, and fills the
     * rest of the space with Energy cards. Then, sets the Stack as the global Deck object.
     * @param pokemonCount number of Pokemon to add to the deck
     * @param energyCount number of Energy to add to the deck
     * @param candyCount number of Rare Candy to add to the deck
     */
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
     * Populates the Prizes array with six cards drawn from the top of the deck.
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

    @Override
    public String exportObjects(String filePath) throws IOException {
        FileWriter fr = new FileWriter(filePath);
        BufferedWriter bfr = new BufferedWriter(fr);
        //header
        bfr.write("Pokemon in Deck,Rare Candy in Deck,Rate of Success,Rate of Bricks");
        bfr.newLine();
        //data
        for(CandyHandResult h : getCandyResults()){
            bfr.write(h.getNumPokemon() + "," + h.getNumCandy() + "," +
                    h.getSuccessRate() + "," + h.getPrizeCandyRate());
            bfr.newLine();
        }
        //close writers
        bfr.close();
        fr.close();
        //inform user of success
        return "File successfully created at " + filePath;
    }

    /**
     * Creates a deck with 16 copies of Pokemon and Energy, and one Rare Candy.
     * Fills the rest of the deck with energy afterward. Initializes all other
     * data structures for use in program.
     */
    public RareCandyHands(){
        //make a deck with 16 pokemon, 16 energy, and 1 Rare Candy
        makeDeck(16, 16, 1);
        //set hand size to 7
        setHandSize(7);
        //set the hand to an empty arraylist
        setTheHand(new ArrayList<>());
        //set the results to an empty arraylist
        setCandyResults(new ArrayList<>());
        //set prizes as new array
        setPrizes(new PokemonCard[getPrizeCount()]);
    }

    /**
     * Parameterized constructor allows user to specify deck contents and hand size.
     * Also initializes all other data structures for use in program.
     * @param aDeck a premade deck list. if not populated, uses passed values to make deck
     * @param pokemonCount number of Pokemon to include
     * @param energyCount number of energy to include
     * @param candyCount number of Rare Candy to include
     * @param handSize the desired hand size
     */
    public RareCandyHands(Stack<PokemonCard> aDeck, int pokemonCount, int energyCount,
                          int candyCount, int handSize){
        //if the passed deck is not null and is the correct size,
        if(aDeck != null){
            if(aDeck.size() == 60) {
                //set it as the deck
                setDeck(aDeck);
            }
        //otherwise
        }else{
            //make a deck data structure
            makeDeck(pokemonCount, energyCount, candyCount);
        }
        //set hand size
        setHandSize(handSize);
        //set hand as new arraylist
        setTheHand(new ArrayList<>());
        //set the results to an empty arraylist
        setCandyResults(new ArrayList<>());
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

    public ArrayList<CandyHandResult> getCandyResults(){
        return theResults;
    }

    public void setCandyResults(ArrayList<CandyHandResult> theResults){
        this.theResults = theResults;
    }

    private ArrayList<CandyHandResult> theResults;

    private PokemonCard[] prizes;

    private static final int PRIZE_COUNT = 6;
}
