package Project1.PokemonProjects.PokemonTCG.Structures.MainSuperClasses;

public class Item extends PokemonCard{

    public Item(String aName, String anID){
        super(aName, anID);
    }
    public Item(){
        super("Nest Ball", "I01");
    }
}
