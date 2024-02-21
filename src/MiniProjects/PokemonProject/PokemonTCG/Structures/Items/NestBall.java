package MiniProjects.PokemonProject.PokemonTCG.Structures.Items;

import InterfacesAbstracts.Modifier;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Item;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * An object designed to emulate the Nest Ball Pokemon Card.
 * The Nest Ball card adds one Basic Pokemon from the Player's Deck
 * to the Bench. Internally, this object takes user input after producing a list of
 * available Pokemon objects in the PokemonPlayer's Deck structure. It then
 * finds the first instance of the chosen object in the Deck, removes it, adds it
 * to the bench, and updates all associated data structures. If the card is not in
 * the deck or an invalid input is given, the program simply prompts the user for
 * input again.
 */
public class NestBall extends Item implements Modifier<PokemonPlayer> {

    public NestBall(){
        super();
    }

    //add this to a different class
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
        Pokemon[] newBench = p.getBench();
        //make list for pokemon cards in deck
        ArrayList<Pokemon> thePokemon = new ArrayList<>();
        //check the deck for every basic pokemon
        for(PokemonCard c : theDeck){
            if(c.getClass() == Pokemon.class){
                thePokemon.add((Pokemon) c);
            }
        }
        //select one of the pokemon through user input
        Scanner in = new Scanner(System.in);
        //loop while bench has not been changed
        while(Arrays.equals(theBench, newBench)) {
            System.out.println("Choose a Pokemon to add to your Bench: ");
            //display the list of Pokemon to choose
            for(Pokemon k : thePokemon){
                System.out.println(k.getCardName());
            }
            String toAdd = in.nextLine();
            for (Pokemon k : thePokemon) {
                if (toAdd.equalsIgnoreCase(k.getCardName())) {
                    //find the next empty slot in the bench array
                    int next = -1;
                    int i = 0;
                    while (next < 0) {
                        if (theBench[i] == null) {
                            next = i;
                        } else {
                            i++;
                        }
                    }
                    //add the pokemon to it
                    theBench[next] = (Pokemon) theDeck.remove(theDeck.indexOf(k));
                    //update the data structures
                    p.setBench(theBench);
                    p.setDeck(theDeck);
                }
            }
        }
        //return the player object
        return p;
    }
}