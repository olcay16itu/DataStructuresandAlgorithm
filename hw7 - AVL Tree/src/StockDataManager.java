/**
 * The StockDataManager class manages a collection of stocks using an AVL tree data structure.
 * It provides methods to add, update, remove, and search for stocks.
 */
public class StockDataManager {
    private AVLTree avlTree; // AVL tree to store stocks

    /**
     * Constructs a new StockDataManager with an empty AVL tree.
     */
    public StockDataManager() {
        avlTree = new AVLTree(); // Initialize AVL tree
    }

    /**
     * Constructs a new StockDataManager with the specified AVL tree.
     *
     * @param avlTree the AVL tree containing stocks
     */
    public StockDataManager(AVLTree avlTree) {
        this.avlTree = avlTree; // Initialize AVL tree
    }

    /**
     * Adds or updates a stock with the given details.
     * If a stock with the same symbol already exists, its details are updated.
     * Otherwise, a new stock is added to the AVL tree.
     *
     * @param symbol    the symbol of the stock
     * @param price     the price of the stock
     * @param volume    the volume of the stock
     * @param marketCap the market capitalization of the stock
     */
    public void addOrUpdateStock(String symbol, double price, long volume, long marketCap) {
        Stock existingStock = avlTree.search(symbol); // Search for existing stock
        if (existingStock != null) {
            // Update existing stock details
            existingStock.setPrice(price);
            existingStock.setVolume(volume);
            existingStock.setMarketCap(marketCap);
        } else {
            // Add new stock to the AVL tree
            Stock newStock = new Stock(symbol, price, volume, marketCap);
            avlTree.insert(newStock);
        }
    }

    /**
     * Removes a stock with the specified symbol from the AVL tree.
     *
     * @param symbol the symbol of the stock to be removed
     */
    public void removeStock(String symbol) {
        avlTree.delete(symbol); // Delete stock from AVL tree
    }

    /**
     * Searches for a stock with the specified symbol in the AVL tree.
     *
     * @param symbol the symbol of the stock to search for
     * @return the stock with the specified symbol, or null if not found
     */
    public Stock searchStock(String symbol) {
        return avlTree.search(symbol); // Search for stock in AVL tree
    }
    /**
     * Prints the stocks stored in the AVL tree in sorted order.
     * Uses in-order traversal to traverse the AVL tree and print each stock.
     */
    public void printStocks(){
        avlTree.inOrderTraversal();
    }

    /**
     * Updates the details of a stock with the specified symbol.
     *
     * @param symbol      the symbol of the stock to be updated
     * @param newPrice    the new price of the stock
     * @param newVolume   the new volume of the stock
     * @param newMarketCap the new market capitalization of the stock
     */
    public void updateStock(String symbol, double newPrice, long newVolume, long newMarketCap) {
        Stock stock = avlTree.search(symbol); // Search for stock
        if (stock != null) {
            // Update stock details
            stock.setPrice(newPrice);
            stock.setVolume(newVolume);
            stock.setMarketCap(newMarketCap);
        }
    }
}
