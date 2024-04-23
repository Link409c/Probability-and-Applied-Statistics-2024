package Project1.PokemonProjects.PokemonTCG.Structures.MainSuperClasses;

import Project1.InterfacesAbstracts.Attackable;
import Project1.PokemonProjects.PokemonTCG.Structures.Enums.EvolutionType;
import Project1.PokemonProjects.PokemonTCG.Structures.Enums.PokemonType;

import java.util.ArrayList;


/**
 * Subclass of the PokemonCard object. Designed to represent a Pokemon.
 */
public class Pokemon extends PokemonCard implements Attackable<Pokemon> {

    public Pokemon attackOne(Pokemon target){
        target.setHp(target.getHp() - 10);
        return target;
    }

    public Pokemon attackTwo(Pokemon target){
        target.setHp(target.getHp() - 10);
        return target;
    }

    public Pokemon(){
        super("Pikachu", "025");
        setHp(50);
        setType(PokemonType.Electric);
        setEvolutionType(EvolutionType.Basic);
        setResistance(this.getType());
        setWeakness(this.getType());
        setAttachedEnergy(new ArrayList<>());
    }
    public Pokemon(String aName, String anID, int anHP,
                   PokemonType aType, ArrayList<Energy> theEnergy){
        super(aName, anID);
        setHp(anHP);
        setType(aType);
        setWeakness(checkWeakness());
        setResistance(checkResistance());
        setAttachedEnergy(theEnergy);
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

    public EvolutionType getEvolutionType() {
        return evolutionType;
    }

    public void setEvolutionType(EvolutionType evolutionType) {
        this.evolutionType = evolutionType;
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

    public ArrayList<Energy> getAttachedEnergy() {
        return attachedEnergy;
    }

    public void setAttachedEnergy(ArrayList<Energy> attachedEnergy) {
        this.attachedEnergy = attachedEnergy;
    }

    private int hp;

    private PokemonType type;

    private EvolutionType evolutionType;

    private PokemonType weakness;

    private PokemonType resistance;

    private ArrayList<Energy> attachedEnergy;
}
