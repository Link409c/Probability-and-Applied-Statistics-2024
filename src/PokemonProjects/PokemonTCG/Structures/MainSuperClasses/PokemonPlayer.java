package PokemonProjects.PokemonTCG.Structures.MainSuperClasses;

import PokemonProjects.PokemonTCG.Structures.Enums.PokemonType;
import PokemonProjects.PokemonTCG.Structures.Items.NestBall;
import PokemonProjects.PokemonTCG.Structures.Pokemon.Pikachu;
import PokemonProjects.PokemonTCG.Structures.Pokemon.Zangoose;
import PokemonProjects.PokemonTCG.Structures.Trainers.ProfessorsResearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/**
 * Data Structure representing the player in a Pokemon Card Game.
 */
public class PokemonPlayer {

    public void drawCard() {
        getHand().add(getDeck().pop());
    }

    /**
     * shuffles the current hand into the deck and draw the same number of cards.
     */
    public void mulliganHand() {
        //get the hand size
        int handSize = getHand().size();
        //put the current hand back in the deck
        for (PokemonCard c : getHand()) {
            getDeck().add(c);
        }
        setHand(new ArrayList<>());
        //shuffle the deck
        Collections.shuffle(getDeck());
        //draw the same number of cards
        for (int i = 0; i < handSize; i++) {
            getHand().add(getDeck().pop());
        }
    }

    public Pokemon declareAttack(Pokemon p) {
        return p;
    }

    public PokemonPlayer useTrainer(PokemonPlayer p) {
        return p;
    }

    public PokemonPlayer useItem(PokemonPlayer p) {
        return p;
    }

    public void changeBench() {
    }

    public boolean isWinner() {
        int prizesRemaining = 6;
        for (PokemonCard p : getPrizeCards()) {
            if (p == null) {
                prizesRemaining--;
            }
        }
        return prizesRemaining == 0;
    }

    /**
     * Parameterized Constructor passes populated structures to the Player Object.
     *
     * @param aName           Player Name
     * @param aDeck           Deck of Pokemon Cards
     * @param aDiscard        Discard Pile
     * @param anActivePokemon Active Pokemon
     * @param aBench          Bench of Pokemon
     * @param aHand           hand of Pokemon Cards
     * @param thePrizes       Prize Cards
     */
    public PokemonPlayer(String aName, Stack<PokemonCard> aDeck, ArrayList<PokemonCard> aDiscard,
                         Pokemon anActivePokemon, Pokemon[] aBench, ArrayList<PokemonCard> aHand,
                         PokemonCard[] thePrizes) {
        setPlayerName(aName);
        setDeck(aDeck);
        setDiscard(aDiscard);
        setActivePokemon(anActivePokemon);
        setBench(aBench);
        setHand(aHand);
        setPrizeCards(thePrizes);
    }

    /**
     * Default Constructor randomly chooses one of two ways to construct
     * the Deck for a Player Object and populates the other parameters with
     * default values.
     */
    public PokemonPlayer() {
        int i = new Random().nextInt(2);
        Stack<PokemonCard> newDeck = new Stack<>();
        if (i == 0) {
            //make pikachus
            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 15; j++) {
                    switch (k) {
                        //add energy
                        case 0 -> newDeck.add(new Energy("Electric Energy",
                                "E04", PokemonType.Electric));
                        //add pokemon
                        case 1 -> newDeck.add(new Pikachu());
                        //add items
                        case 2 -> newDeck.add(new NestBall());
                        //add trainers
                        case 3 -> newDeck.add(new ProfessorsResearch());
                    }
                }
            }
        } else {
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

    public void setBench(Pokemon[] aBench) {
        this.bench = aBench;
    }

    public Pokemon[] getBench() {
        return this.bench;
    }

    public PokemonCard[] getPrizeCards() {
        return prizeCards;
    }

    public void setPrizeCards(PokemonCard[] prizeCards) {
        this.prizeCards = prizeCards;
    }

    public void setHand(ArrayList<PokemonCard> aHand) {
        this.hand = aHand;
    }

    public ArrayList<PokemonCard> getHand() {
        return this.hand;
    }

    public void setDiscard(ArrayList<PokemonCard> aDiscard) {
        this.discard = aDiscard;
    }

    public ArrayList<PokemonCard> getDiscard() {
        return this.discard;
    }

    public void setDeck(Stack<PokemonCard> aDeck) {
        this.deck = aDeck;
    }

    public Stack<PokemonCard> getDeck() {
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