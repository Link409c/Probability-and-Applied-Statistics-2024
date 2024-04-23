package Project1.PokemonProjects.PokemonTCG.Structures.MainSuperClasses;

import Project1.InterfacesAbstracts.Modifier;

public class Trainer extends PokemonCard implements Modifier<PokemonPlayer> {

    @Override
    public PokemonPlayer modify(PokemonPlayer objectToModify) {
        return null;
    }

    public Trainer(){
        super("Professor's Research", "T01");
    }
}