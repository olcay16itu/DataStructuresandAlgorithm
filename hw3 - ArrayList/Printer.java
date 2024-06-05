/**
 * This class represents a printer device.
 * It implements the {@link IDevice} interface, providing methods to access
 * and modify basic information about the printer such as its name, category,
 * price, and quantity.
 */
public class Printer implements IDevice {
    private String name;
    private final String category = "Printer";
    private double price;
    private int quantity;

    /**
     * Constructs a new Printer object with the specified name, price, and quantity.
     *
     * @param name     The name of the printer.
     * @param price    The price of the printer.
     * @param quantity The quantity of the printer.
     */
    public Printer(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the name of the printer.
     * Time complexity: O(1)
     *
     * @return The name of the printer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the printer.
     * Time complexity: O(1)
     *
     * @param name The new name to set for the printer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the category of the printer.
     * Time complexity: O(1)
     *
     * @return The category of the printer.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the price of the printer.
     * Time complexity: O(1)
     *
     * @return The price of the printer.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the printer.
     * Time complexity: O(1)
     *
     * @param price The new price to set for the printer.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the printer.
     * Time complexity: O(1)
     *
     * @return The quantity of the printer.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the printer.
     * Time complexity: O(1)
     *
     * @param quantity The new quantity to set for the printer.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
