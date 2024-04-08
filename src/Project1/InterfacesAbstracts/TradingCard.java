package Project1.InterfacesAbstracts;

/**
 * A class representing some kind of trading card.
 */
public class TradingCard {

    public TradingCard(String aCardName, String anIDCode){
        setCardName(aCardName);
        setIdCode(anIDCode);
    }

    public TradingCard(){
        setCardName("TradingCard");
        setIdCode("NoID");
    }
    public String getCardName() {
        return String.valueOf(cardName);
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    /**
     * The name of a Trading Card.
     */
    private String cardName;
    /**
     * Some unique ID for a Trading Card.
     */
    private String idCode;
}
