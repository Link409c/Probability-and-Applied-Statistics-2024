package PokemonProjects.PokemonTCG.Structures.Trainers;

import PokemonProjects.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import PokemonProjects.PokemonTCG.Structures.MainSuperClasses.PokemonPlayer;
import PokemonProjects.PokemonTCG.Structures.MainSuperClasses.Trainer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Object modeling the trainer card Professor's Research.
 */
public class ProfessorsResearch extends Trainer {

    public ProfessorsResearch(){
        setCardName("Professor's Research");
        setIdCode("T01");
    }
    /**
     * The effect of Professor's Research allows the player to discard their
     * hand and draw seven new cards.
     * @param thePlayer the object to affect
     * @return the updated Player object
     */
    public PokemonPlayer modify(PokemonPlayer thePlayer){
        Stack<PokemonCard> playerDeck = thePlayer.getDeck();
        //get the player hand
        ArrayList<PokemonCard> playerHand = thePlayer.getHand();
        //get the player discard
        ArrayList<PokemonCard> playerDiscard = thePlayer.getDiscard();
        //put all the cards in it in the discard pile
        for(PokemonCard p : playerHand){
            playerDiscard.add(p);
            playerHand.remove(p);
        }
        //draw seven cards from the deck
        //put them in the hand
        for(int i = 0; i < 6; i++){
            playerHand.add(playerDeck.pop());
        }
        //update the player object parameters modified
        thePlayer.setHand(playerHand);
        thePlayer.setDiscard(playerDiscard);
        thePlayer.setDeck(playerDeck);
        //return the updated player object
        return thePlayer;
    }
}
