package MiniProjects.PokemonProject.PokemonCardHands.Structures;

public class CandyHandResult extends HandResult{

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
     * in the prizes for this set of trials.
     */
    private double prizeCandyRate;
}
