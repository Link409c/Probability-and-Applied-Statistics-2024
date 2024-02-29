package MiniProjects.PokemonProject.PokemonTCG.Structures.Items;

import InterfacesAbstracts.Modifier;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Item;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.PokemonPlayer;

public class RareCandy extends Item implements Modifier<PokemonPlayer> {

    public RareCandy(){
        super("Rare Candy", "I02");
    }

    @Override
    public PokemonPlayer modify(PokemonPlayer objectToModify) {
        //if the active or bench has a pokemon that can evolve,
            //select one of those pokemon
            //get the appropriate evolution pokemon from the hand or deck
            //send the pokemon to the discard pile and replace it with the evolution
            //transfer all status, energy, etc to the evolution
            //update the hand, discard, bench, active etc
        //else
            //display an error / exception
        //return the player
        return null;
    }
}
