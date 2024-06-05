/**
 * This class represents a smartphone device.
 * It implements the {@link IDevice} interface, providing methods to access
 * and modify basic information about the smartphone such as its name, category,
 * price, and quantity.
 */
public class SmartPhone implements IDevice {
    private String name;
    private final String category = "SmartPhone";
    private double price;
    private int quantity;

    /**
     * Constructs a new SmartPhone object with the specified name, price, and quantity.
     *
     * @param name     The name of the smartphone.
     * @param price    The price of the smartphone.
     * @param quantity The quantity of the smartphone.
     */
    public SmartPhone(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the name of the smartphone.
     * Time complexity: O(1)
     *
     * @return The name of the smartphone.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the smartphone.
     * Time complexity: O(1)
     *
     * @param name The new name to set for the smartphone.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the category of the smartphone.
     * Time complexity: O(1)
     *
     * @return The category of the smartphone.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the price of the smartphone.
     * Time complexity: O(1)
     *
     * @return The price of the smartphone.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the smartphone.
     * Time complexity: O(1)
     *
     * @param price The new price to set for the smartphone.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the smartphone.
     * Time complexity: O(1)
     *
     * @return The quantity of the smartphone.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the smartphone.
     * Time complexity: O(1)
     *
     * @param quantity The new quantity to set for the smartphone.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
