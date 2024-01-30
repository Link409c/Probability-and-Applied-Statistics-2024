package MiniProjects.PokemonCardHands.Structures;

import java.util.ArrayList;

public class HandResult {

    public HandResult(int theRunNumber, ArrayList<PokemonCard> theHand){
        setRunNumber(theRunNumber);
        setHandContents(theHand);
    }

    public int getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(int runNumber) {
        this.runNumber = runNumber;
    }

    public ArrayList<PokemonCard> getHandContents() {
        return handContents;
    }

    public void setHandContents(ArrayList<PokemonCard> handContents) {
        this.handContents = handContents;
    }

    private int runNumber;
    private ArrayList<PokemonCard> handContents;
}
