package MiniProjects.PokemonProject.PokemonCardHands.Structures;

public class CandyHandResult extends HandResult{

    /**
     * parameterized constructor for results of Rare Candy Hands program.
     * @param numPokemon the number of Pokemon in the deck
     * @param handCandy the percentage of hands which had a Pokemon and Rare Candy
     * @param numCandy the number of Rare Candy in the deck
     * @param prizeCandy the percentage of hands which did not have a Rare Candy, and the prizes did.
     */
    public CandyHandResult(int numPokemon, double handCandy, int numCandy, double prizeCandy){
        super(numPokemon, handCandy);
        setNumCandy(numCandy);
        setPrizeCandyRate(prizeCandy);
    }
    public int getNumCandy() {
        return numCandy;
    }

    public void setNumCandy(int numCandy) {
        this.numCandy = numCandy;
    }

    public double getPrizeCandyRate() {
        return prizeCandyRate;
    }

    public void setPrizeCandyRate(double prizeCandyRate) {
        this.prizeCandyRate = prizeCandyRate;
    }

    /**
     * the total number of "Rare Candy" cards in the deck.
     */
    private int numCandy;
    /**
     * the probability of seeing a rare candy
     * in the prizes and not in the hand for this set of trials.
     */
    private double prizeCandyRate;
}
