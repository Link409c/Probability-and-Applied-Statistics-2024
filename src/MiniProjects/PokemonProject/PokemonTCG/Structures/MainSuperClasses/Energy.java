package MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses;

import MiniProjects.PokemonProject.PokemonTCG.Structures.Enums.PokemonType;

/**
 * Subclass of the PokemonCard object. Represents an Energy Card from the
 * Pokemon Trading Card Game.
 */
public class Energy extends PokemonCard {

    public Energy(){
        super("Colorless Energy", "E01");
        setEnergyType(PokemonType.Normal);
    }

    public Energy(String aName, String anID, PokemonType anEnergyType){
        super(aName, anID);
        setEnergyType(anEnergyType);
    }

    public PokemonType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(PokemonType energyType) {
        this.energyType = energyType;
    }

    private PokemonType energyType;
}
