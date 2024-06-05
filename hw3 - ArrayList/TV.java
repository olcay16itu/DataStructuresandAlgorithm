/**
 * This class represents a television device.
 * It implements the {@link IDevice} interface, providing methods to access
 * and modify basic information about the television such as its name, category,
 * price, and quantity.
 */
public class TV implements IDevice {
    private String name;
    private final String category = "TV";
    private double price;
    private int quantity;

    /**
     * Constructs a new TV object with the specified name, price, and quantity.
     *
     * @param name     The name of the television.
     * @param price    The price of the television.
     * @param quantity The quantity of the television.
     */
    public TV(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the name of the television.
     * Time complexity: O(1)
     *
     * @return The name of the television.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the television.
     * Time complexity: O(1)
     *
     * @param name The new name to set for the television.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the category of the television.
     * Time complexity: O(1)
     *
     * @return The category of the television.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the price of the television.
     * Time complexity: O(1)
     *
     * @return The price of the television.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the television.
     * Time complexity: O(1)
     *
     * @param price The new price to set for the television.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the television.
     * Time complexity: O(1)
     *
     * @return The quantity of the television.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the television.
     * Time complexity: O(1)
     *
     * @param quantity The new quantity to set for the television.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}