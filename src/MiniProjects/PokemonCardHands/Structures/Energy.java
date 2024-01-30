package MiniProjects.PokemonCardHands.Structures;

/**
 * Subclass of the PokemonCard object. Represents an Energy Card from the
 * Pokemon Trading Card Game.
 */
public class Energy extends PokemonCard {

    public Energy(){
        setCardName("Colorless Energy");
        setEnergyType("Colorless");
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType(String energyType) {
        this.energyType = energyType;
    }

    private String energyType;
}
