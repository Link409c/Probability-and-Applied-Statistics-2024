package PokemonProjects.PokemonTCG.Structures.MainSuperClasses;

import InterfacesAbstracts.Modifier;

public class Trainer extends PokemonCard implements Modifier<PokemonPlayer> {

    @Override
    public PokemonPlayer modify(PokemonPlayer objectToModify) {
        return null;
    }

    public Trainer(){
        super("Professor's Research", "T01");
    }
}