package Project2.StocksBot.Structures;

/**
 * A Data Container for daily values of a stock.
 */
public class StockDay {

    /**
     * get the attributes of the object and add them to
     * a String.
     * @return a String consisting of the attributes of the object.
     */
    public String dailyValuesToString(){
        return getDate() + ", " +
                getOpen() + ", " +
                getHigh() + ", " +
                getLow() + ", " +
                getClose() + ", " +
                getAdjustedClose() + ", " +
                getVolume();
    }

    public StockDay(){}

    public StockDay(String aDate, double theOpen, double theHigh,
                    double theLow, double theClose, double theAdjClose,
                    long theVolume){
        this.date = aDate;
        this.open = theOpen;
        this.high = theHigh;
        this.low = theLow;
        this.close = theClose;
        this.adjustedClose = theAdjClose;
        this.volume = theVolume;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getAdjustedClose() {
        return adjustedClose;
    }

    public void setAdjustedClose(double adjustedClose) {
        this.adjustedClose = adjustedClose;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    /**
     * The date in MM/DD/YYYY format.
     */
    private String date;
    /**
     * the opening price of the stock
     */
    private double open;
    /**
     * the high price of the stock
     */
    private double high;
    /**
     * the low price of the stock
     */
    private double low;
    /**
     * the price of the stock at the end of the day
     */
    private double close;
    /**
     * the closing price adjusted for some variables
     */
    private double adjustedClose;
    /**
     * the number of shares traded in a stock or contracts traded in futures or options
     */
    private long volume;
}
