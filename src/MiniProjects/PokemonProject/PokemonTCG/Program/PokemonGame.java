package MiniProjects.PokemonProject.PokemonTCG.Program;

import InterfacesAbstracts.CardGameEnvironment;
import InterfacesAbstracts.FileAble;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import MiniProjects.PokemonProject.PokemonTCG.Structures.PokemonPlayer;

import java.io.IOException;
import java.util.ArrayList;

public class PokemonGame implements CardGameEnvironment<PokemonCard, PokemonPlayer>, FileAble {

    @Override
    public PokemonPlayer runGame() {
        return null;
    }

    @Override
    public void buildGame() {
        //create both player objects
        //create
    }

    @Override
    public void conductTurn() {

    }

    @Override
    public String printWholeField() {
        return null;
    }

    @Override
    public String inspectPlayerOneField() {
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
        return null;
    }

    @Override
    public ArrayList<PokemonCard> inspectPlayerOneDiscard() {
        return null;
    }

    @Override
    public ArrayList<PokemonCard> inspectPlayerTwoDiscard() {
        return null;
    }

    @Override
    public void importObjects(String filePath) throws IOException {

    }

    @Override
    public String exportObjects(String filePath) throws IOException {
        return null;
    }

    @Override
    public String addFileType(String fileName) {
        return null;
    }

    @Override
    public String addIdentifier(String fileName) {
        return null;
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