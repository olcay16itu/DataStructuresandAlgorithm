/**
 * This class represents a headphone device.
 * It implements the {@link IDevice} interface, providing methods to access
 * and modify basic information about the headphone such as its name, category,
 * price, and quantity.
 */
public class Headphones implements IDevice {
    private String name;
    private final String category = "Headphone";
    private double price;
    private int quantity;

    /**
     * Constructs a new Headphones object with the specified name, price, and quantity.
     *
     * @param name     The name of the headphones.
     * @param price    The price of the headphones.
     * @param quantity The quantity of the headphones.
     */
    public Headphones(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the name of the headphones.
     * Time complexity: O(1)
     *
     * @return The name of the headphones.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the headphones.
     * Time complexity: O(1)
     *
     * @param name The new name to set for the headphones.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the category of the headphones.
     * Time complexity: O(1)
     *
     * @return The category of the headphones.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the price of the headphones.
     * Time complexity: O(1)
     *
     * @return The price of the headphones.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the headphones.
     * Time complexity: O(1)
     *
     * @param price The new price to set for the headphones.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the headphones.
     * Time complexity: O(1)
     *
     * @return The quantity of the headphones.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the headphones.
     * Time complexity: O(1)
     *
     * @param quantity The new quantity to set for the headphones.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
