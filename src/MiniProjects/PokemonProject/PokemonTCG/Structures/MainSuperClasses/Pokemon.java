package MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses;

import MiniProjects.PokemonProject.PokemonTCG.Structures.Enums.PokemonType;

/**
 * Subclass of the PokemonCard object. Designed to represent a Pokemon.
 */
public class Pokemon extends PokemonCard {

    public Pokemon(){
        super("Pikachu", "025");
        setHp(50);
        setType(PokemonType.Electric);
        setResistance(this.getType());
        setWeakness(this.getType());
    }
    public Pokemon(String aName, String anID, int anHP, PokemonType aType){
        super(aName, anID);
        setHp(anHP);
        setType(aType);
        setWeakness(checkWeakness());
        setResistance(checkResistance());
    }

    public PokemonType checkWeakness(){
        switch(this.getType()){
            case Normal -> {
                return PokemonType.Fighting;
            }
            case Fire -> {
                return PokemonType.Water;
            }
            case Grass -> {
                return PokemonType.Fire;
            }
            case Water -> {
                return PokemonType.Grass;
            }
            case Psychic, Electric -> {
                return PokemonType.None;
            }
            case Fighting -> {
                return PokemonType.Psychic;
            }
        }
        return PokemonType.None;
    }

    public PokemonType checkResistance(){
        switch(this.getType()){
            case Normal, Electric -> {
                return PokemonType.None;
            }
            case Fire -> {
                return PokemonType.Grass;
            }
            case Grass -> {
                return PokemonType.Water;
            }
            case Water -> {
                return PokemonType.Fire;
            }
            case Psychic -> {
                return PokemonType.Fighting;
            }
            case Fighting -> {
                return PokemonType.Normal;
            }
        }
        return PokemonType.None;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public PokemonType getWeakness() {
        return weakness;
    }

    public void setWeakness(PokemonType weakness) {
        this.weakness = weakness;
    }

    public PokemonType getResistance() {
        return resistance;
    }

    public void setResistance(PokemonType resistance) {
        this.resistance = resistance;
    }

    private int hp;

    private PokemonType type;

    private PokemonType weakness;

    private PokemonType resistance;
}
