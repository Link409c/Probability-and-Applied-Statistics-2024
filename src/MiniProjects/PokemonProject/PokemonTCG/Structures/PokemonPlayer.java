package MiniProjects.PokemonProject.PokemonTCG.Structures;

import MiniProjects.PokemonProject.PokemonTCG.Structures.Enums.PokemonType;
import MiniProjects.PokemonProject.PokemonTCG.Structures.Items.NestBall;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Energy;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import MiniProjects.PokemonProject.PokemonTCG.Structures.Pokemon.Pikachu;
import MiniProjects.PokemonProject.PokemonTCG.Structures.Pokemon.Zangoose;
import MiniProjects.PokemonProject.PokemonTCG.Structures.Trainers.ProfessorsResearch;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * Data Structure representing the player in a Pokemon Card Game.
 */
public class PokemonPlayer {

    /**
     * Default Constructor randomly chooses one of two ways to construct
     * the Deck for a Player Object and populates the other parameters with
     * default values.
     */
    public PokemonPlayer(){
        int i = new Random().nextInt(2);
        Stack<PokemonCard> newDeck = new Stack<>();
        if(i == 0){
            //make pikachus
            for(int k = 0; k < 4; k++){
                for(int j = 0; j < 15; j++){
                    switch(k){
                        //add energy
                        case 0 ->
                            newDeck.add(new Energy("Electric Energy",
                                    "E04", PokemonType.Electric));
                        //add pokemon
                        case 1 ->
                            newDeck.add(new Pikachu());
                        //add items
                        case 2 ->
                            newDeck.add(new NestBall());
                        //add trainers
                        case 3 ->
                            newDeck.add(new ProfessorsResearch());
                    }
                }
            }
        }else {
            //make zangooses
            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 15; j++) {
                    switch (k) {
                        //add energy
                        case 0 -> newDeck.add(new Energy());
                        //add pokemon
                        case 1 -> newDeck.add(new Zangoose());
                        //add items
                        case 2 -> newDeck.add(new NestBall());
                        //add trainers
                        case 3 -> newDeck.add(new ProfessorsResearch());
                    }
                }
            }
        }
        setPlayerName("Player");
        setDeck(newDeck);
        setDiscard(new ArrayList<>());
        setActivePokemon(null);
        setBench(new Pokemon[BENCH_SIZE]);
        setHand(new ArrayList<>());
        setPrizeCards(new PokemonCard[PRIZES]);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public void setBench(Pokemon[] aBench){
        this.bench = aBench;
    }
    public Pokemon[] getBench(){
        return this.bench;
    }

    public PokemonCard[] getPrizeCards() {
        return prizeCards;
    }

    public void setPrizeCards(PokemonCard[] prizeCards) {
        this.prizeCards = prizeCards;
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
