package InterfacesAbstracts;

import java.util.ArrayList;

/**
 * An interface designed to guide the implementation of a tabletop card game environment.
 */
public interface CardGameEnvironment<T, P> {

    /**
     * run the game, alternating turns until a player, P, is declared the winner.
     * @return the winner, P
     */
    P runGame();
    /**
     * create and populate all necessary global data structures and
     * objects that make up the game environment.
     */
    void buildGame();
    /**
     * step through each of the procedures in a normal turn of this card game.
     * @param turnPlayer the player whose turn it is
     */
    void conductTurn(P turnPlayer);
    /**
     * displays the current objects in play for all players.
     * @return a table representation of the current game board.
     */
    String printWholeField();
    /**
     * displays the current objects in play for player one only.
     * @return a table representation of the player designated P1.
     */
    String inspectPlayerOneField();
    String inspectPlayerTwoField();
    /**
     * used to query public information about P1 such as quantity of objects in
     * all areas in their possession and progress toward the game's win state,
     * without revealing private knowledge to the opposing player.
     * @return a table containing information on P1's deck, discard, hand, and any other
     * specific information relevant to the game.
     */
    String inspectPlayerOneStatus();
    String inspectPlayerTwoStatus();
    /**
     * used to query P1 discard area / graveyard / etc.
     * @return a list of objects from that designated data container
     */
    ArrayList<T> inspectPlayerOneDiscard();
    ArrayList<T> inspectPlayerTwoDiscard();
}
