/**
 * The Stock class represents a stock with its symbol, price, volume, and market capitalization.
 */
public class Stock {
    private String symbol;   // Symbol of the stock
    private double price;    // Price of the stock
    private long volume;     // Volume of the stock
    private long marketCap;  // Market capitalization of the stock

    /**
     * Constructs a new Stock object with the specified symbol, price, volume, and market capitalization.
     *
     * @param symbol    the symbol of the stock
     * @param price     the price of the stock
     * @param volume    the volume of the stock
     * @param marketCap the market capitalization of the stock
     */
    public Stock(String symbol, double price, long volume, long marketCap) {
        this.symbol = symbol;     // Initialize symbol
        this.price = price;       // Initialize price
        this.volume = volume;     // Initialize volume
        this.marketCap = marketCap; // Initialize market capitalization
    }

    /**
     * Retrieves the symbol of the stock.
     *
     * @return the symbol of the stock
     */
    public String getSymbol() {
        return symbol;  // Return symbol
    }

    /**
     * Sets the symbol of the stock.
     *
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol; // Set symbol
    }

    /**
     * Retrieves the price of the stock.
     *
     * @return the price of the stock
     */
    public double getPrice() {
        return price;   // Return price
    }

    /**
     * Sets the price of the stock.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price; // Set price
    }

    /**
     * Retrieves the volume of the stock.
     *
     * @return the volume of the stock
     */
    public long getVolume() {
        return volume;  // Return volume
    }

    /**
     * Sets the volume of the stock.
     *
     * @param volume the volume to set
     */
    public void setVolume(long volume) {
        this.volume = volume;   // Set volume
    }

    /**
     * Retrieves the market capitalization of the stock.
     *
     * @return the market capitalization of the stock
     */
    public long getMarketCap() {
        return marketCap;   // Return market capitalization
    }

    /**
     * Sets the market capitalization of the stock.
     *
     * @param marketCap the market capitalization to set
     */
    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap; // Set market capitalization
    }

    /**
     * Returns a string representation of the stock object.
     *
     * @return a string representation of the stock
     */
    @Override
    public String toString() {
        return "Stock [symbol=" + symbol + ", price=" + price + ", volume=" + volume + ", marketCap=" + marketCap + "]";
    }
}
