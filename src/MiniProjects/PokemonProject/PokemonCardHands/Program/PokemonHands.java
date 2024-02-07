package MiniProjects.PokemonProject.PokemonCardHands.Program;

import InterfacesAbstracts.DeckAnalyzer;
import InterfacesAbstracts.FileAble;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Energy;
import MiniProjects.PokemonProject.PokemonCardHands.Structures.HandResult;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;

import java.io.*;
import java.time.LocalDateTime;
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

    public String runProgram(String filePath, int numTrials) throws IOException {
        //run the appropriate amount of trials
        runTrials(numTrials);
        //export the results
        filePath = filePath.concat("\\PokemonHandTest");
        filePath = addIdentifier(filePath);
        filePath = addFileType(filePath);
        return exportObjects(filePath);
    }
    /**
     * Tests a number of hands to evaluate and calculate the
     * optimal number of Pokemon Cards to add to the deck in order to see, at minimum,
     * the specified number of Pokemon in the hand every time.
     * @param numTrials the amount of hands to draw for each ratio of Pokemon in the deck.
     */
    public void runTrials(int numTrials){
        //pokemon count
        int pokemonCount = 0;
        //initial probability of success
        double successRate = 0;
        //tracking successes in each trial run
        int successes;
        //get accurate pokemon count in deck
        if(getDeck() != null) {
            for (PokemonCard c : getDeck()) {
                if (c.getClass() == Pokemon.class) {
                    pokemonCount++;
                }
            }
        }
        //run the program
        //either until pokemon = deck count or success rate hits 100%
        while(pokemonCount <= FULL_DECK_COUNT && successRate < 1.0) {
            shuffleDeck();
            successes = 0;
            //run a number of trials to get hand results
            for(int i = 0; i < numTrials; i++){
                //draw a hand
                drawHand(getHandSize());
                //evaluate
                if(evaluateHand()){
                    successes++;
                }
                //reset the deck
                for(PokemonCard c : getTheHand()){
                    getDeck().add(c);
                }
                //shuffle and repeat
                shuffleDeck();
            }
            //calculate the chance of success
            //num of hands w/ pokemon over num trials
            successRate = (double) successes / numTrials;
            getTheResults().add(new HandResult(pokemonCount, successRate));
            /*
            System.out.println(getTheResults().getLast().getNumPokemon() + ", "
                    + getTheResults().getLast().getSuccessRate());
            */
            //repeat until the chance of success is as close to 100% as possible
            pokemonCount++;
            makeDeck(pokemonCount);
        }
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
    public String exportObjects(String filePath) throws IOException {
        //different ways to approach exporting results
        //can give each hand with cards
        //can give condensed results
            //aka how many hands had 0 pokemon, 1 pokemon, 2 pokemon, etc.
        //can give optimized results
            //aka "Run x pokemon to see one every time"
        //can export a mix of these outputs
        FileWriter fr = new FileWriter(filePath);
        BufferedWriter bfr = new BufferedWriter(fr);
        //header
        bfr.write("Pokemon in Deck,Rate of Success");
        bfr.newLine();
        //data
        for(HandResult h : getTheResults()){
            bfr.write(h.getNumPokemon() + "," + h.getSuccessRate());
            bfr.newLine();
        }
        //close writers
        bfr.close();
        fr.close();
        //inform user of success
        return "File successfully created at " + filePath;
    }

    /**
     * adds the .csv suffix to any exported file for this program
     * @param fileName the current string representing the file name
     * @return returns the file name with a .csv suffix
     */
    public String addFileType(String fileName){
        //take the fileName as a parameter
        //add the appropriate file type as the suffix
        //return the filename with the suffix added
        return fileName.concat(".csv");
    }

    /**
     * Adds the date and time to the file name for identification.
     * @param fileName the current string representing the file name.
     * @return the file name concatenated with the date and time
     */
    public String addIdentifier(String fileName){
        //get the date and time
        String dateTime = String.valueOf(LocalDateTime.now());
        dateTime = dateTime.substring(0, dateTime.indexOf(":"));
        //add the date and time to the filename
        return fileName.concat(dateTime);
    }

    //default constructor
    public PokemonHands(){
        //make a deck with one pokemon
        makeDeck(1);
        //shuffle the deck
        //set deck as the global
        //set hand size to 7
        setHandSize(7);
        //set the hand to an empty arraylist
        setTheHand(new ArrayList<>());
        //set the results to an empty arraylist
        setTheResults(new ArrayList<>());
    }

    /**
     * Parameterized Constructor allows user to specify their deck contents
     * as well as hand size.
     * @param theDeck the deck of Pokemon Cards.
     * @param theHandSize the size for test hands.
     */
    public PokemonHands(Stack<PokemonCard> theDeck, int theHandSize){
        //set the deck to the passed parameter
        setDeck(theDeck);
        //set the hand size to the passed parameter
        setHandSize(theHandSize);
        //set the hand to an empty arraylist
        setTheHand(new ArrayList<>());
        //set the results to an empty arraylist
        setTheResults(new ArrayList<>());
    }
    public Stack<PokemonCard> getDeck() {
        return theDeck;
    }

    public void setDeck(Stack<PokemonCard> theDeck) {
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

    public ArrayList<HandResult> getTheResults() {
        return theResults;
    }

    public void setTheResults(ArrayList<HandResult> theResults) {
        this.theResults = theResults;
    }

    /**
     * collected results of all test runs of the program for exporting.
     */
    private ArrayList<HandResult> theResults;
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