package Project1.PokemonProjects.PokemonTCG.Program;

import Project1.InterfacesAbstracts.CardGameEnvironment;
import Project1.InterfacesAbstracts.FileAble;
import Project1.PokemonProjects.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import Project1.PokemonProjects.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import Project1.PokemonProjects.PokemonTCG.Structures.MainSuperClasses.PokemonPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Pokemon Game is a program designed to emulate simple functions of the Pokemon Trading Card Game.
 * Two players can participate to play the game against one another, winning when their opponent has
 * no available Pokemon to play, or they take all Prizes from their Prize Pile. Players can import their
 * own custom deck lists, or participate in a game with premade deck lists.
 */
public class PokemonGame implements CardGameEnvironment<PokemonCard, PokemonPlayer>, FileAble {

    /**
     * instantiates the player objects, builds the game environment, and runs the game
     * until a player is declared the winner.
     * @return the winner of the game.
     */
    @Override
    public PokemonPlayer runGame() {
        //build necessary game objects
        buildGame();
        //determine who goes first
        PokemonPlayer first = turnOrder();
        //while player 1 or player 2 prizes > 0,
        while(!getPlayerOne().isWinner()
                && !getPlayerTwo().isWinner()) {
            //conduct turns of the game starting with high roll player
            conductTurn(first);
            if(first == getPlayerOne()){
                conductTurn(getPlayerTwo());
            }else{
                conductTurn(getPlayerOne());
            }
        }
        //determine winner by whichever prize list has no cards
        if(getPlayerOne().isWinner()){
            return getPlayerOne();
        }else{
            return getPlayerTwo();
        }
    }

    /**
     * draws hands for both players, and prompts the players to set their active
     * pokemon and benched pokemon. then, sets each player's prize piles.
     */
    @Override
    public void buildGame() {
        PokemonPlayer currPlayer;
        Scanner in = new Scanner(System.in);
        //check hands and mulligan while player has no pokemon
        //then choose active and benched pokemon
        for (int i = 0; i < 2; i++) {
            //list for valid targets of search
            ArrayList<PokemonCard> pokeList = new ArrayList<>();
            //TODO: wrap the loop contents in a method
            if (i == 0) {
                currPlayer = getPlayerOne();
                while (!currPlayer.handHasPokemon()) {
                    //if curr player mulligans, opponent gets to draw a card
                    currPlayer.mulliganHand();
                    getPlayerTwo().getHand().add(getPlayerTwo().getDeck().pop());
                }
                System.out.println("Choose your active Pokemon, " + currPlayer);
                System.out.println("Place some Pokemon on the bench?");
                //if no
                System.out.println("");
                setPlayerOne(currPlayer);
            } else {
                currPlayer = getPlayerTwo();
                while (!currPlayer.handHasPokemon()) {
                    //if curr player mulligans, opponent gets to draw a card
                    currPlayer.mulliganHand();
                    getPlayerOne().getHand().add(getPlayerOne().getDeck().pop());
                }
                System.out.println("Choose your active Pokemon, " + currPlayer);
                //print the list of pokemon to choose
                //TODO: make displayHand method to replace this
                for (PokemonCard c : getPlayerTwo().getHand()) {
                    if (c.getClass() == Pokemon.class) {
                        pokeList.add(c);
                    }
                }
                System.out.println("Valid Targets:");
                for (PokemonCard c : pokeList) {
                    System.out.println(c.getCardName());
                }
                //get input
                String choice = in.next();
                //remove the pokemon placed from the hand
                //TODO: Make a method in player to do this
                for (int j = 0; j < currPlayer.getHand().size(); j++) {
                    PokemonCard c = getPlayerTwo().getHand().get(j);
                    if (choice.equalsIgnoreCase(c.getCardName())) {
                        currPlayer.setActivePokemon((Pokemon) pokeList.remove(j));
                        currPlayer.getHand().remove(c);
                    }
                }
                //print list to put on bench
                System.out.println("Add Pokemon to Bench:");
                Pokemon[] bench = new Pokemon[5];
                System.out.println("Valid Targets:");
                for (PokemonCard c : pokeList) {
                    System.out.println(c.getCardName());
                }
                while (currPlayer.handHasPokemon()) {
                    choice = in.next();
                    for (int j = 0; j < currPlayer.getHand().size(); j++) {
                        PokemonCard c = getPlayerTwo().getHand().get(j);
                        if (choice.equalsIgnoreCase(c.getCardName())) {
                            bench[j] = (Pokemon) pokeList.remove(j);
                            currPlayer.getHand().remove(c);
                        }
                    }
                    //if no, continue
                    //set bench
                }
                currPlayer.setBench(bench);
            }
            //after active pokemon and benches are set, set each player's prize cards
            setPlayerTwo(currPlayer);
        }
    }


    /**
     * Conducts a player's turn. This consists of drawing a card, playing any number of
     * trainers, supporters, and items, and attacking with the active pokemon.
     * @param turnPlayer the player whose turn it is
     * @return the turn player object
     */
    @Override
    public PokemonPlayer conductTurn(PokemonPlayer turnPlayer) {
        //the turn player
        //draws a card
        turnPlayer.drawCard();
        boolean declaredAttack = false;
        String choice;
        Scanner in = new Scanner(System.in);
        while(!declaredAttack){
            //plays items, trainers, supporters, stadiums, attaches energy, evolves pokemon.
            //get each different card type in the hand
            //show choices based on these types
            //get user input for what to do
            //if attack, set flag to true
            //attack using the active pokemon.
        }
        //after attacking the turn ends and the other player takes their turn.
        return turnPlayer;
    }

    /**
     * Determines the turn order and which player starts the game going first.
     * @return the player who goes first.
     */
    public PokemonPlayer turnOrder(){
        //high roll
        Random dieOne = new Random();
        Random dieTwo = new Random();
        int rollOne, rollTwo;
        //player to return
        PokemonPlayer first = new PokemonPlayer();
        //roll two dice and compare
        do {
            rollOne = dieOne.nextInt(1, 7) + dieTwo.nextInt(1, 7);
            rollTwo = dieOne.nextInt(1, 7) + dieTwo.nextInt(1, 7);
            if (rollOne > rollTwo) {
                first = getPlayerOne();
            } else if (rollOne < rollTwo) {
                first = getPlayerTwo();
            }
        }while(rollOne == rollTwo);
        return first;
    }

    @Override
    public String printWholeField() {
        //call inspect methods for player 1 and 2
        //call status methods for player 1 and 2
        return null;
    }

    @Override
    public String inspectPlayerOneField() {
        //display active pokemon with status, bench pokemon with status, stadium in play
        return null;
    }

    @Override
    public String inspectPlayerTwoField() {
        return null;
    }

    @Override
    public String inspectPlayerOneStatus() {
        return null;
    }

    @Override
    public String inspectPlayerTwoStatus() {
        //display cards in hand, cards in discard, prizes remaining
        return null;
    }

    @Override
    public ArrayList<PokemonCard> inspectPlayerOneDiscard() {
        //used for printing player one's discard pile arraylist
        return null;
    }

    @Override
    public ArrayList<PokemonCard> inspectPlayerTwoDiscard() {
        //used for printing player two's discard pile arraylist
        return null;
    }

    @Override
    public void importObjects(String filePath) throws IOException {
        //import decks for the players to use.
    }

    @Override
    public String exportObjects(String filePath) throws IOException {
        //export a log of the game?
        //deck lists?
        return null;
    }

    @Override
    public String addFileType(String fileName) {
        //filetype should be .csv to export deck contents
        return null;
    }

    @Override
    public String addIdentifier(String fileName) {
        //add a date to the filename
        return null;
    }

    /**
     * Parameterized constructor sets player objects to passed parameters.
     * @param playerA Player One
     * @param playerB Player Two
     */
    public PokemonGame(PokemonPlayer playerA, PokemonPlayer playerB){
        setPlayerOne(playerA);
        setPlayerTwo(playerB);
    }

    /**
     * Default constructor initializes new player objects.
     */
    public PokemonGame() {
        setPlayerOne(new PokemonPlayer());
        setPlayerTwo(new PokemonPlayer());
    }

    public PokemonPlayer getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(PokemonPlayer playerOne) {
        this.playerOne = playerOne;
    }

    public PokemonPlayer getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(PokemonPlayer playerTwo) {
        this.playerTwo = playerTwo;
    }

    /**
     * the object representing Player One.
     */
    private PokemonPlayer playerOne;

    /**
     * the object representing Player Two.
     */
    private PokemonPlayer playerTwo;
}
