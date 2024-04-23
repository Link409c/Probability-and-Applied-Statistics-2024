package Project1.PokemonProjects.PokemonTCG.Structures.Pokemon;

import Project1.PokemonProjects.PokemonTCG.Structures.MainSuperClasses.Pokemon;

public class Pikachu extends Pokemon{

    public Pikachu(){
        super();
    }

    /**
     * Pikachu's First Attack is Tackle.
     * @param theTarget the target of the attack
     * @return the updated target object
     */
    @Override
    public Pokemon attackOne(Pokemon theTarget) {
        theTarget.setHp(theTarget.getHp() - 20);
        return theTarget;
    }

    /**
     * Pikachu's second attack is Electro Ball.
     * @param theTarget the target of the attack
     * @return the updated target object
     */
    @Override
    public Pokemon attackTwo(Pokemon theTarget) {
        theTarget.setHp(theTarget.getHp() - 40);
        return theTarget;
    }
}
