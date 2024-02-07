package MiniProjects.PokemonProject.PokemonTCG.Structures.Items;

import InterfacesAbstracts.Modifier;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Item;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import MiniProjects.PokemonProject.PokemonTCG.Structures.PokemonPlayer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Nest Ball is an item card.
 */
public class NestBall extends Item implements Modifier<PokemonPlayer> {

    public NestBall(){
        super();
    }
    public PokemonPlayer playCard(PokemonPlayer p){
        //if card is legal to play,
        if(!isBenchFull(p)){
            //play card
            return modify(p);
        }
        //otherwise print an error message?
        else{
            //nothing gets modified
            return p;
        }
    }
    public boolean isBenchFull(PokemonPlayer p){
        return p.getBench().length > 5;
    }
    /**
     * Nest Ball adds one basic Pokemon from the player Deck to the player Bench.
     * @param p the object to affect
     * @return
     */
    @Override
    public PokemonPlayer modify(PokemonPlayer p) {
        //get the player deck
        Stack<PokemonCard> theDeck = p.getDeck();
        //get the player bench
        Pokemon[] theBench = p.getBench();
        //make list for pokemon cards in deck
        ArrayList<Pokemon> thePokemon = new ArrayList<>();
        //check the deck for every basic pokemon
        for(PokemonCard c : theDeck){
            if(c.getClass() == Pokemon.class){
                thePokemon.add((Pokemon) c);
            }
        }
        //put all cards into a list
        for(Pokemon c : thePokemon){

        }
        //select one of the pokemon through user input
        //remove selected from deck and add that pokemon to the bench
        //update hand and deck parameters
        //return the player object
        return p;
    }
}
