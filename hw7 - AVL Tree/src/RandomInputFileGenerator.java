import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

/**
 * The RandomInputFileGenerator class generates a random input file containing commands for testing the StockDataManager class.
 * It includes commands for adding, removing, searching, and updating stock data.
 */
public class RandomInputFileGenerator {

    private static final int SYMBOL_LENGTH = 4; // Length of the stock symbol

    /**
     * Generates a random input file with the specified number of commands for adding, removing, searching,
     * and updating stock data.
     *
     * @param fileName  the name of the file to be generated
     * @param numAdd    the number of add commands to be generated
     * @param numRemove the number of remove commands to be generated
     * @param numSearch the number of search commands to be generated
     * @param numUpdate the number of update commands to be generated
     */
    public static void generateRandomInputFile(String fileName, int numAdd, int numRemove, int numSearch, int numUpdate) {
        Random random = new Random(); // Random object for generating random values
        Set<String> addedSymbols = new HashSet<>(); // Set to store symbols that have been added
        Set<String> removedSymbols = new HashSet<>(); // Set to store symbols that have been removed

        try (FileWriter writer = new FileWriter(fileName)) {
            // Generate add commands
            for (int i = 0; i < numAdd; i++) {
                String command = generateAddCommand(random, addedSymbols);
                writer.write(command + "\n");
            }
            // Generate remove commands
            for (int i = 0; i < numRemove; i++) {
                String command = generateRemoveCommand(random, addedSymbols, removedSymbols);
                writer.write(command + "\n");
            }
            // Generate search commands
            for (int i = 0; i < numSearch; i++) {
                String command = generateSearchCommand(random, addedSymbols, removedSymbols);
                writer.write(command + "\n");
            }
            // Generate update commands
            for (int i = 0; i < numUpdate; i++) {
                String command = generateUpdateCommand(random, addedSymbols);
                writer.write(command + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace if an IOException occurs
        }
    }

    // Generates an add command with a random stock symbol and data
    private static String generateAddCommand(Random random, Set<String> addedSymbols) {
        String symbol;
        do {
            symbol = generateRandomSymbol(random); // Generate a random symbol
        } while (addedSymbols.contains(symbol)); // Ensure the symbol hasn't been added before
        addedSymbols.add(symbol); // Add the symbol to the set of added symbols
        // Generate random price, volume, and market cap values
        double price = 10 + (5000 - 10) * random.nextDouble();
        long volume = 1000 + random.nextInt(1000000);
        long marketCap = 1000000 + random.nextInt(1000000000);
        // Format the command string
        return String.format(Locale.ENGLISH, "ADD %s %.2f %d %d", symbol, price, volume, marketCap);
    }

    // Generates a remove command with a random stock symbol
    private static String generateRemoveCommand(Random random, Set<String> addedSymbols, Set<String> removedSymbols) {
        if (addedSymbols.isEmpty()) {
            return "REMOVE " + generateRandomSymbol(random); // No symbols to remove
        }
        String symbol;
        do {
            symbol = getRandomElementFromSet(random, addedSymbols); // Get a random added symbol
        } while (removedSymbols.contains(symbol)); // Ensure the symbol hasn't been removed before
        removedSymbols.add(symbol); // Add the symbol to the set of removed symbols
        return "REMOVE " + symbol; // Format the command string
    }

    // Generates a search command with either a random existing symbol or a new random symbol
    private static String generateSearchCommand(Random random, Set<String> addedSymbols, Set<String> removedSymbols) {
        String symbol;
        if (random.nextBoolean() && !addedSymbols.isEmpty()) {
            do {
                symbol = getRandomElementFromSet(random, addedSymbols); // Get a random added symbol
            } while (removedSymbols.contains(symbol)); // Ensure the symbol hasn't been removed
        } else {
            symbol = generateRandomSymbol(random); // Generate a new random symbol
        }
        return "SEARCH " + symbol; // Format the command string
    }

    // Generates an update command with a random existing stock symbol and new data
    private static String generateUpdateCommand(Random random, Set<String> addedSymbols) {
        if (addedSymbols.isEmpty()) {
            return "UPDATE " + generateRandomSymbol(random) + " " + generateRandomSymbol(random) + " 0.0 0 0";
        }
        String oldSymbol = getRandomElementFromSet(random, addedSymbols); // Get a random added symbol
        // Generate random new price, volume, and market cap values
        double newPrice = 10 + (5000 - 10) * random.nextDouble();
        long newVolume = 1000 + random.nextInt(1000000);
        long newMarketCap = 1000000 + random.nextInt(1000000000);
        // Format the command string
        return String.format(Locale.ENGLISH, "UPDATE %s %.2f %d %d", oldSymbol, newPrice, newVolume, newMarketCap);
    }

    // Generates a random symbol of length SYMBOL_LENGTH
    private static String generateRandomSymbol(Random random) {
        StringBuilder symbol = new StringBuilder(SYMBOL_LENGTH);
        for (int i = 0; i < SYMBOL_LENGTH; i++) {
            symbol.append((char) ('A' + random.nextInt(26))); // Append a random uppercase letter
        }
        return symbol.toString(); // Convert StringBuilder to String and return
    }

    // Gets a random element from a set
    private static String getRandomElementFromSet(Random random, Set<String> set) {
        int index = random.nextInt(set.size()); // Generate a random index within the set size
        return set.stream().skip(index).findFirst().orElse(null); // Return the element at the random index
    }
}
