package InterfacesAbstracts;

/**
 * A class representing some kind of trading card.
 */
public class TradingCard {

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    private String cardName;
}
