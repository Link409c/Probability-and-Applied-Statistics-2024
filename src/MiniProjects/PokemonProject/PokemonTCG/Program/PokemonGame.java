package MiniProjects.PokemonProject.PokemonTCG.Program;

import InterfacesAbstracts.CardGameEnvironment;
import InterfacesAbstracts.FileAble;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonCard;
import MiniProjects.PokemonProject.PokemonTCG.Structures.PokemonPlayer;

public class PokemonGame implements CardGameEnvironment<PokemonCard, PokemonPlayer>, FileAble {

    public PokemonGame(){
        setPlayerOne();
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
