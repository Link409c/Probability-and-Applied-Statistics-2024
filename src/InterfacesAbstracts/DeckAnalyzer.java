package InterfacesAbstracts;

/**
 * An interface for modeling programs designed to analyze different aspects of a deck of cards.
 */
public interface DeckAnalyzer<C> {

    /**
     * create the deck object to the program's specifications
     */
    void makeDeck(int cardCount);

    void makeDeck(int cardCountOne, int cardCountTwo, int cardCountThree);

    /**
     * randomize the order of the objects in the deck
     */
    void shuffleDeck();

    /**
     * draw a hand of cards from the deck
     * @param handSize the amount of cards a hand has
     */
    void drawHand(int handSize);

    /**
     * determine the outcome of the drawn hand based on the program's goals
     */
    boolean evaluateHand();


}
