import java.io.File;
import java.util.Scanner;

/**
 * The Main class serves as the entry point for the stock management system.
 * It generates a random input file containing commands for adding, removing, searching, and updating stocks,
 * reads the input file, and executes the corresponding operations on the StockDataManager.
 */
public class Main {

    /**
     * The main method of the program.
     * It generates a random input file, reads the commands from the file, and performs the specified operations.
     *
     * @param args the command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Generate a random input file
        RandomInputFileGenerator randomInputFileGenerator = new RandomInputFileGenerator();
        randomInputFileGenerator.generateRandomInputFile("input.txt", 200, 30, 1000, 50);

        // Initialize the StockDataManager
        StockDataManager manager = new StockDataManager();

        Scanner scanner = null;
        File file;
        try {
            // Open the input file for reading
            file = new File("input.txt").getAbsoluteFile();
            scanner = new Scanner(file);
        } catch (Exception e) {
            // Print an error message if file opening fails
            System.out.println(e.getMessage());
        }

        // Process each command from the input file
        while (scanner.hasNextLine()) {
            try {
                // Read the next line from the input file
                String input = scanner.nextLine();
                String[] tokens = input.split(" ");

                // Execute the corresponding operation based on the command
                switch (tokens[0]) {
                    case "ADD":
                        // Parse the parameters and add or update the stock
                        String symbol = tokens[1];
                        double price = Double.parseDouble(tokens[2]);
                        long volume = Long.parseLong(tokens[3]);
                        long marketCap = Long.parseLong(tokens[4]);
                        manager.addOrUpdateStock(symbol, price, volume, marketCap);
                        break;
                    case "REMOVE":
                        // Remove the stock with the specified symbol
                        symbol = tokens[1];
                        manager.removeStock(symbol);
                        break;
                    case "SEARCH":
                        // Search for the stock with the specified symbol
                        symbol = tokens[1];
                        Stock stock = manager.searchStock(symbol);
                        if (stock != null) {
                            System.out.println(stock);
                        } else {
                            System.out.println("Stock not found");
                        }
                        break;
                    case "UPDATE":
                        // Parse the parameters and update the stock details
                        symbol = tokens[1];
                        price = Double.parseDouble(tokens[2]);
                        volume = Long.parseLong(tokens[3]);
                        marketCap = Long.parseLong(tokens[4]);
                        manager.updateStock(symbol, price, volume, marketCap);
                        break;
                    default:
                        // Print an error message for unknown commands
                        System.out.println("Unknown command");
                        break;
                }

            } catch (Exception e) {
                // Print an error message if an exception occurs during command processing
                e.getMessage();
            }
        }
        scanner.close(); // Close the scanner after processing all commands
    }
}
