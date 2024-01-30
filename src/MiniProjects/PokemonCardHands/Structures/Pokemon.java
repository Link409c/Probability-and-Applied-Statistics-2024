package MiniProjects.PokemonCardHands.Structures;

/**
 * Subclass of the PokemonCard object. Designed to represent a Pokemon.
 */
public class Pokemon extends PokemonCard {

    public Pokemon(){
        setCardName("Zangoose");
        setHp(90);
        setResistance("Poison");
        setWeakness("Fighting");
    }
    public Pokemon(String aName, int anHP, String aWeakness, String aResistance){
        setCardName(aName);
        setHp(anHP);
        setWeakness(aWeakness);
        setResistance(aResistance);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    private int hp;

    private String weakness;

    private String resistance;
}
