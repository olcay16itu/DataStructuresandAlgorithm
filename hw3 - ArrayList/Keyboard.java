/**
 * This class represents a keyboard device.
 * It implements the {@link IDevice} interface, providing methods to access
 * and modify basic information about the keyboard such as its name, category,
 * price, and quantity.
 */
public class Keyboard implements IDevice {
    private String name;
    private final String category = "Keyboard";
    private double price;
    private int quantity;

    /**
     * Constructs a new Keyboard object with the specified name, price, and quantity.
     *
     * @param name     The name of the keyboard.
     * @param price    The price of the keyboard.
     * @param quantity The quantity of the keyboard.
     */
    public Keyboard(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the name of the keyboard.
     * Time complexity: O(1)
     *
     * @return The name of the keyboard.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the keyboard.
     * Time complexity: O(1)
     *
     * @param name The new name to set for the keyboard.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the category of the keyboard.
     * Time complexity: O(1)
     *
     * @return The category of the keyboard.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the price of the keyboard.
     * Time complexity: O(1)
     *
     * @return The price of the keyboard.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the keyboard.
     * Time complexity: O(1)
     *
     * @param price The new price to set for the keyboard.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the keyboard.
     * Time complexity: O(1)
     *
     * @return The quantity of the keyboard.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the keyboard.
     * Time complexity: O(1)
     *
     * @param quantity The new quantity to set for the keyboard.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
