/**
 * This interface represents a generic device.
 * Implementing classes should provide methods to access and modify
 * basic information about the device such as its name, category,
 * price, and quantity.
 */
public interface IDevice {
    /**
     * Retrieves the name of the device.
     *
     * @return The name of the device.
     */
    String getName();
    /**
     * Retrieves the category of the device.
     *
     * @return The category of the device.
     */
    String getCategory();
    /**
     * Retrieves the price of the device.
     *
     * @return The price of the device.
     */
    double getPrice();
    /**
     * Sets the price of the device.
     *
     * @param price The new price to set for the device.
     */
    void setPrice(double price);
    /**
     * Retrieves the quantity of the device.
     *
     * @return The quantity of the device.
     */
    int getQuantity();
    /**
     * Sets the quantity of the device.
     *
     * @param quantity The new quantity to set for the device.
     */
    void setQuantity(int quantity);
}
