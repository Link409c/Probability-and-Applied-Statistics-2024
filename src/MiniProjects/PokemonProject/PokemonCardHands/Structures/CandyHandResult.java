package MiniProjects.PokemonProject.PokemonCardHands.Structures;

public class CandyHandResult extends HandResult{

    public CandyHandResult(int numPokemon, double successRate, int numCandy){
        super(numPokemon, successRate);
        setNumCandy(numCandy);
    }
    public int getNumCandy() {
        return numCandy;
    }

    public void setNumCandy(int numCandy) {
        this.numCandy = numCandy;
    }

    /**
     * the total number of "Rare Candy" cards in the deck.
     */
    private int numCandy;

    private boolean handHasCandy;

    private boolean prizesHasCandy;
}
