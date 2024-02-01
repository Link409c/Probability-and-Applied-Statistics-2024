package MiniProjects.PokemonProject.PokemonCardHands.Structures;

import java.util.ArrayList;

/**
 * A Data Structure for holding information about a hand of Pokemon Card Objects.
 */
public class HandResult {

    public HandResult(int numPokemon, double successRate){
        setNumPokemon(numPokemon);
        setSuccessRate(successRate);
    }

    public int getNumPokemon() {
        return numPokemon;
    }

    public void setNumPokemon(int numPokemon) {
        this.numPokemon = numPokemon;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    private int numPokemon;

    private double successRate;
}
