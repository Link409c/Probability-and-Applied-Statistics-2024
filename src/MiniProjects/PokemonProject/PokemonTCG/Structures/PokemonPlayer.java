package MiniProjects.PokemonProject.PokemonTCG.Structures;

import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Data Structure representing the player in a Pokemon Card Game.
 */
public class PokemonPlayer {
    public void setBench(Pokemon[] aBench){
        this.bench = aBench;
    }
    public Pokemon[] getBench(){
        return this.bench;
    }
    public void setHand(ArrayList<PokemonCard> aHand){
        this.hand = aHand;
    }
    public ArrayList<PokemonCard> getHand(){
        return this.hand;
    }
    public void setDiscard(ArrayList<PokemonCard> aDiscard){
        this.discard = aDiscard;
    }
    public ArrayList<PokemonCard> getDiscard(){
        return this.discard;
    }
    public void setDeck(Stack<PokemonCard> aDeck){
        this.deck = aDeck;
    }
    public Stack<PokemonCard> getDeck(){
        return this.deck;
    }
    private Pokemon activePokemon;
    private Pokemon[] bench;
    private PokemonCard[] prizeCards;
    private ArrayList<PokemonCard> discard;
    private ArrayList<PokemonCard> hand;
    private Stack<PokemonCard> deck;
    private String playerName;
    private static final int BENCH_SIZE = 5;
    private static final int PRIZES = 6;
}
