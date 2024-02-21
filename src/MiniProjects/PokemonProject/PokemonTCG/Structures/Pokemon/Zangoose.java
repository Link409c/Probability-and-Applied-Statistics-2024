package MiniProjects.PokemonProject.PokemonTCG.Structures.Pokemon;

import InterfacesAbstracts.Attackable;
import MiniProjects.PokemonProject.PokemonTCG.Structures.MainSuperClasses.Pokemon;
import MiniProjects.PokemonProject.PokemonTCG.Structures.Enums.PokemonType;

import java.util.ArrayList;

public class Zangoose extends Pokemon{

    public Zangoose(){
        super("Zangoose", "335", 90, PokemonType.Normal, new ArrayList<>());
        setSwordsDance(false);
    }

    /**
     * Zangoose's first attack is Slash. If Zangoose has used Swords Dance, the
     * attack does more damage and sets the flag to false.
     * @param theTarget target of the attack
     * @return the target object to update the opponent active pokemon object
     */
    @Override
    public Pokemon attackOne(Pokemon theTarget){
        if(swordsDance) {
            theTarget.setHp(theTarget.getHp() - 80);
            this.setSwordsDance(false);
        }
        else{
            theTarget.setHp(theTarget.getHp() - 40);
        }
        return theTarget;
    }

    /**
     * Zangoose's second attack is Swords Dance. Sets the flag to true.
     * Zangoose's next attack will do more damage.
     * @param thisPokemon this object
     * @return the object receives no changes to its parameters
     */
    public Pokemon attackTwo(Pokemon thisPokemon){
        this.setSwordsDance(true);
        return thisPokemon;
    }

    public void setSwordsDance(boolean status){
        this.swordsDance = status;
    }

    /**
     * Flag for the Swords Dance status.
     */
    private boolean swordsDance;
}