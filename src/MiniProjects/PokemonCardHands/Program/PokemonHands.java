package MiniProjects.PokemonCardHands.Program;

import InterfacesAbstracts.DeckAnalyzer;
import InterfacesAbstracts.FileAble;
import MiniProjects.PokemonCardHands.Structures.Energy;
import MiniProjects.PokemonCardHands.Structures.HandResult;
import MiniProjects.PokemonCardHands.Structures.Pokemon;
import MiniProjects.PokemonCardHands.Structures.PokemonCard;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * A Program designed to assist Pokemon players with a simple aspect of
 * deck building: Ensuring they always have a Pokemon in their opening hand.
 * The program will find the optimal ratio of Pokemon to other cards in a 60-card
 * deck.
 */
public class PokemonHands implements DeckAnalyzer<PokemonCard>, FileAble {

    /**
     * Runs the program, testing a number of hands to evaluate and calculate the
     * optimal number of Pokemon Cards to add to the deck in order to see, at minimum,
     * the specified number of Pokemon in the hand every time.
     * @param numTrials the amount of hands to draw for each ratio of Pokemon in the deck.
     * @return a message informing the user the program has completed and the filepath of
     * the results file.
     */
    public String runProgram(int numTrials){
        //start with one pokemon
        int pokemonCount = 1;
        //initial probability of success
        double successRate = 0;
        //tracking successes in each trial run
        int successes = 0;
        //structure to hold test results
        ArrayList<HandResult> testResults = new ArrayList<>();
        //make the deck starting with one pokemon
        makeDeck(pokemonCount);
        while(pokemonCount <= FULL_DECK_COUNT || successRate < 1.0) {
            shuffleDeck();
            //run a number of trials to get hand results
            for(int i = 0; i < numTrials; i++){
                //draw a hand
                drawHand(getHandSize());
                //evaluate
                if(evaluateHand()){
                    successes++;
                }
                //add the result to the test results
                testResults.add(new HandResult(i, getTheHand()));
                //reset the deck
                for(PokemonCard c : getTheHand()){
                    getDeck().add(c);
                }
                shuffleDeck();
            }
            //calculate the chance of success
            //num of hands w/ pokemon over num trials
            successRate = (double) successes / numTrials;
            //repeat until the chance of success is as close to 100% as possible
            pokemonCount++;
            makeDeck(pokemonCount);
        }
        //export the results of the tests
        String fileName = "PokemonHandsResults";
        //get local date and time to add to file name
        String theDate = new ChronoLocalDate().toString();
        fileName = fileName.concat()
        //return a success message with the filepath
        return exportObjects(testResults, theFilePath);
    }
    /**
     * Populates the global Deck structure with Energy and Pokemon Cards.
     * @param cardCount the amount of Pokemon to add to the deck.
     */
    @Override
    public void makeDeck(int cardCount) {
        //make a new Deck Object
        Stack<PokemonCard> newDeck = new Stack<>();
        //for the card count,
        for(int i = 0; i < cardCount; i++) {
            //make a Pokemon card
            //add it to the deck
            newDeck.add(new Pokemon());
        }
        //subtract cardCount from Full Deck Count
        int energyCount = FULL_DECK_COUNT - cardCount;
        //for that amount,
        for(int i = 0; i < energyCount; i++) {
            //add energy cards to the deck
            newDeck.add(new Energy());
        }
        //set the populated Deck Object as the global
        setDeck(newDeck);
    }

    /**
     * Shuffles the deck by using an array and the Random class.
     * Adapted from Fall 2023 Probability and Applied Statistics
     * HandEvaluator.java
     */
    @Override
    public void shuffleDeck() {
        Stack<PokemonCard> theDeck = getDeck();
        //make an array of the deck
        PokemonCard[] deckArray = new PokemonCard[FULL_DECK_COUNT];
        for (int i = 0; i < FULL_DECK_COUNT; i++) {
            deckArray[i] = theDeck.pop();
        }
        Random r = new Random();
        int shuffleSlot;
        //for each index,
        for (int i = 0; i < FULL_DECK_COUNT; i++) {
            //get a random number in the index bounds
            shuffleSlot = r.nextInt(0, FULL_DECK_COUNT);
            //ensure it is not the current index
            while (shuffleSlot == i) {
                shuffleSlot = r.nextInt(0, FULL_DECK_COUNT);
            }
            //switch the current index with that random number
            PokemonCard temp = deckArray[i];
            deckArray[i] = deckArray[shuffleSlot];
            deckArray[shuffleSlot] = temp;
        }
        //populate a new stack with the randomized deck
        for (PokemonCard c : deckArray) {
            theDeck.push(c);
        }
        //set the randomized deck as the deck global
        setDeck(theDeck);
    }

    /**
     * Populates the hand data structure with Pokemon Cards.
     * @param handSize the amount of cards a hand has
     */
    @Override
    public void drawHand(int handSize) {
        //make a new hand object
        ArrayList<PokemonCard> newHand = new ArrayList<>();
        //for the hand size,
        for(int i = 0; i < handSize; i++) {
            //pop the top object in the deck
            //add it to the hand
            newHand.add(getDeck().pop());
        }
        //set the hand as the global
        setTheHand(newHand);
    }

    /**
     * Evaluate the current hand of Pokemon Cards.
     */
    @Override
    public boolean evaluateHand() {
        //get the hand
        //check each card
        for(PokemonCard p : getTheHand()) {
            //if there is a pokemon, return true
            if(p.getClass() == Pokemon.class){
                return true;
            }
        }
        //else return false
        return false;
    }

    /**
     * Import a premade deck of Pokemon Cards to use for testing.
     * @param filePath the location of the deck file.
     * @throws IOException if the filePath is invalid or null.
     */
    @Override
    public void importObjects(String filePath) throws IOException {
        //get the file from the filepath
        //try to get each card name
        //add each card name to the Deck data structure
    }

    /**
     * Exports the results of a run of the program for user review.
     * @param filePath the desired path to create the file
     * @return a message informing the user if the export was successful.
     */
    public String exportObjects(ArrayList<HandResult> theResults, String filePath){
        //different ways to approach exporting results
        //can give each hand with cards
        //can give condensed results
            //aka how many hands had 0 pokemon, 1 pokemon, 2 pokemon, etc.
        //can give optimized results
            //aka "Run x pokemon to see one every time"
        //can export a mix of these outputs


        return "";
    }

    public String addFileType(String fileName){
        //take the fileName as a parameter
        //add the appropriate file type as the suffix
        //return the filename with the suffix added
        return fileName.concat(".csv");
    }

    //default constructor
    public PokemonHands(){
        //make a deck with one playset of a Pokemon (4 cards)
        //shuffle the deck
        //set deck as the global
        //set hand size to 7
        //set the hand to an empty arraylist
    }

    /**
     * Parameterized Constructor allows user to specify their deck contents
     * as well as hand size.
     * @param theDeck the deck of Pokemon Cards.
     * @param theHandSize the size for test hands.
     */
    public PokemonHands(Stack<PokemonCard> theDeck, int theHandSize){
        //set the deck to the passed parameter
        //set the hand size to the passed parameter
        //set the hand to an empty arraylist
    }
    public Stack<PokemonCard> getDeck() {
        return theDeck;
    }

    public void setDeck(Stack<PokemonCard> theDeck) {
        this.theDeck = theDeck;
    }

    public Stack<PokemonCard> getTheDeck() {
        return theDeck;
    }

    public void setTheDeck(Stack<PokemonCard> theDeck) {
        this.theDeck = theDeck;
    }

    public ArrayList<PokemonCard> getTheHand() {
        return theHand;
    }

    public void setTheHand(ArrayList<PokemonCard> theHand) {
        this.theHand = theHand;
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }

    /**
     * Data Structure representing a Deck of Pokemon Trading Cards.
     */
    private Stack<PokemonCard> theDeck;

    /**
     * Data Structure representing a hand of Pokemon Trading Cards.
     */
    private ArrayList<PokemonCard> theHand;

    /**
     * Amount of cards in a hand. Standard for Pokemon is 7
     */
    private int handSize;

    /**
     * Maximum amount of cards that may be added to a deck.
     * Standard for Pokemon is 60
     */
    private static final int FULL_DECK_COUNT = 60;
}