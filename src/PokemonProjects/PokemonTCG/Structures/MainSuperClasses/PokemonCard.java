package PokemonProjects.PokemonTCG.Structures.MainSuperClasses;

import InterfacesAbstracts.TradingCard;

/**
 * Subclass of the Trading Card object designated to be used in programs
 * emulating aspects of the Pokemon Trading Card Game.
 */
public class PokemonCard extends TradingCard {

    /**
     * outputs the object class as a string, removing any
     * "class" or "interface" labels if present.
     * @return the class of this object as a string.
     */
    @Override
    public String toString(){
        return this.getClass().toString().replace("class", "");
    }
    public PokemonCard(String aName, String anID){
        super(aName, anID);
    }

    public PokemonCard(){
        setCardName("PokemonCard");
        setIdCode("NoID");
    }
}
