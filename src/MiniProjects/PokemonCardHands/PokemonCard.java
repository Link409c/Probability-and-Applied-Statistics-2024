package MiniProjects.PokemonCardHands;

import InterfacesAbstracts.TradingCard;

public class PokemonCard extends TradingCard {

    public PokemonCard(String aName, int anHP){
        setCardName(aName);
        setHp(anHP);
        setWeakness("None");
        setResistance("None");
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
