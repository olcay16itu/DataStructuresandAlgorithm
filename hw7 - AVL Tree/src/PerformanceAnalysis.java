import java.util.Random;

/**
 * Class to analyze the performance of operations on a stock data manager.
 */
public class PerformanceAnalysis {

    private static final int NUM_OPERATIONS = 100; // Number of operations to perform for each test
    private static final int[] TREE_SIZES = {1000, 5000, 10000, 50000}; // Tree sizes to test
    private static final Random random = new Random();

    /**
     * Main method to perform performance analysis on various operations.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        StockDataManager stockDataManager = new StockDataManager(generateRandomAVLTree(1000));
        testAddOperation(stockDataManager);
        testRemoveOperation(stockDataManager);
        testSearchOperation(stockDataManager);
        testUpdateOperation(stockDataManager);
    }

    /**
     * Method to test the performance of adding stocks.
     * @param stockDataManager The stock data manager to perform operations on
     */
    public static void testAddOperation(StockDataManager stockDataManager) {
        System.out.println("Performance Analysis for ADD Operation:");
        System.out.println("---------------------------------------");
        for (int size : TREE_SIZES) {
            long totalTime = 0;
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                String symbol = generateRandomSymbol();
                double price = random.nextDouble() * 100;
                long volume = random.nextInt(1000000);
                long marketCap = random.nextInt(1000000000);
                long startTime = System.nanoTime();
                stockDataManager.addOrUpdateStock(symbol, price, volume, marketCap);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            double averageTime = totalTime / (double) NUM_OPERATIONS;
            System.out.println("Tree Size: " + size + " nodes, Average Time: " + averageTime + " ns");
        }
        System.out.println();
    }

    /**
     * Method to test the performance of removing stocks.
     * @param stockDataManager The stock data manager to perform operations on
     */
    public static void testRemoveOperation(StockDataManager stockDataManager) {
        System.out.println("Performance Analysis for REMOVE Operation:");
        System.out.println("------------------------------------------");
        for (int size : TREE_SIZES) {
            long totalTime = 0;
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                String symbol = generateRandomSymbol();
                long startTime = System.nanoTime();
                stockDataManager.removeStock(symbol);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            double averageTime = totalTime / (double) NUM_OPERATIONS;
            System.out.println("Tree Size: " + size + " nodes, Average Time: " + averageTime + " ns");
        }
        System.out.println();
    }

    /**
     * Method to test the performance of searching for stocks.
     * @param stockDataManager The stock data manager to perform operations on
     */
    public static void testSearchOperation(StockDataManager stockDataManager) {
        System.out.println("Performance Analysis for SEARCH Operation:");
        System.out.println("------------------------------------------");
        for (int size : TREE_SIZES) {
            long totalTime = 0;
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                String symbol = generateRandomSymbol();
                long startTime = System.nanoTime();
                stockDataManager.searchStock(symbol);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            double averageTime = totalTime / (double) NUM_OPERATIONS;
            System.out.println("Tree Size: " + size + " nodes, Average Time: " + averageTime + " ns");
        }
        System.out.println();
    }

    /**
     * Method to test the performance of updating stocks.
     * @param stockDataManager The stock data manager to perform operations on
     */
    public static void testUpdateOperation(StockDataManager stockDataManager) {
        System.out.println("Performance Analysis for UPDATE Operation:");
        System.out.println("------------------------------------------");
        for (int size : TREE_SIZES) {
            long totalTime = 0;
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                String newSymbol = generateRandomSymbol();
                double newPrice = random.nextDouble() * 100;
                long newVolume = random.nextInt(1000000);
                long newMarketCap = random.nextInt(1000000000);
                long startTime = System.nanoTime();
                stockDataManager.updateStock(newSymbol, newPrice, newVolume, newMarketCap);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            double averageTime = totalTime / (double) NUM_OPERATIONS;
            System.out.println("Tree Size: " + size + " nodes, Average Time: " + averageTime + " ns");
        }
        System.out.println();
    }

    /**
     * Method to generate a random AVL tree with given size.
     * @param size The size of the AVL tree
     * @return The generated AVL tree
     */
    private static AVLTree generateRandomAVLTree(int size) {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < size; i++) {
            String symbol = generateRandomSymbol();
            double price = random.nextDouble() * 100;
            long volume = random.nextInt(1000000);
            long marketCap = random.nextInt(1000000000);
            avlTree.insert(new Stock(symbol, price, volume, marketCap));
        }
        return avlTree;
    }

    /**
     * Method to generate a random symbol.
     * @return The generated random symbol
     */
    private static String generateRandomSymbol() {
        StringBuilder symbol = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            symbol.append((char) ('A' + random.nextInt(26)));
        }
        return symbol.toString();
    }
}
