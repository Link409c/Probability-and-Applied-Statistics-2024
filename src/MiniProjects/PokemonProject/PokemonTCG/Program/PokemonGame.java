package MiniProjects.PokemonProject.PokemonTCG.Program;

import InterfacesAbstracts.CardGameEnvironment;
import InterfacesAbstracts.FileAble;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PokemonGame implements CardGameEnvironment<PokemonCard, PokemonPlayer>, FileAble {

    @Override
    public PokemonPlayer runGame() {
        //build necessary game objects
        buildGame();
        //determine who goes first
        PokemonPlayer first = turnOrder();
        //while player 1 or player 2 prize > 0,
        while(getPlayerOne().getPrizeCards().length > 0
                && getPlayerTwo().getPrizeCards().length > 0) {
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

    @Override
    public void buildGame() {
        //check hands and mulligan while player has no pokemon
        PokemonPlayer currPlayer;
        for(int i = 0; i < 2; i++) {
            if(i == 0){
                currPlayer = getPlayerOne();
                while(!currPlayer.getHand().contains(Pokemon.class)) {
                    currPlayer.mulliganHand();
                    getPlayerTwo().getHand().add(getPlayerTwo().getDeck().pop());
                }
                setPlayerOne(currPlayer);
            }else{
                currPlayer = getPlayerTwo();
                while(!currPlayer.getHand().contains(Pokemon.class)) {
                    currPlayer.mulliganHand();
                    getPlayerOne().getHand().add(getPlayerOne().getDeck().pop());
                }
                setPlayerTwo(currPlayer);
            }
        }
        Scanner in = new Scanner(System.in);
        //players choose their active pokemon and pokemon to add to the bench
        System.out.println("Choose your active Pokemon, " + getPlayerOne());
        //after active pokemon and benches are set, set each player's prize cards
        //choose who goes first
    }

    @Override
    public PokemonPlayer conductTurn(PokemonPlayer turnPlayer) {
        //the turn player
        //draws a card
        turnPlayer.drawCard();
        //plays items, trainers, supporters, stadiums, attaches energy, evolves pokemon.
        boolean declaredAttack = false;
        while(!declaredAttack){
            //do stuff
            //attack using the active pokemon.
            //if you attack, set the flag to true
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

    public PokemonGame(PokemonPlayer playerA, PokemonPlayer playerB){
        setPlayerOne(playerA);
        setPlayerTwo(playerB);
    }

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

    private PokemonPlayer playerOne;
    private PokemonPlayer playerTwo;
}