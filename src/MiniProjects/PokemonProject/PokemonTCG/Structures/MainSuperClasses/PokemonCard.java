package MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses;

import InterfacesAbstracts.TradingCard;

/**
 * Subclass of the Trading Card object designated to be used in programs
 * emulating aspects of the Pokemon Trading Card Game.
 */
public class PokemonCard extends TradingCard {

    public PokemonCard(String aName, String anID){
        super(aName, anID);
    }
}
