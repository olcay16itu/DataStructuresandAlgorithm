/**
 * The Order class represents an order for a product.
 * It contains information such as the product name, count, total price, status, and customer ID.
 */

public class Order {
    /**
     * The name of the product.
     */
    private String product_name;
    /**
     * The quantity of the product ordered.
     */
    private int count;
    /**
     * The total price of the order.
     */
    private int total_price;
    /**
     * The status of the order.
     * <p>
     * Status 0: Initialized.
     * Status 1: Processing.
     * Status 2: Completed.
     * Status 3: Cancelled.
     * Any other value is considered as an invalid status.
     */
    private  int status;
    /**
     * The ID of the customer who placed the order.
     */
    private int Customer_ID;

    /**
     * Constructs an Order object with the given parameters.
     * @param product_name The name of the product
     * @param count The count of the product in the order
     * @param total_price The total price of the order
     * @param status The status of the order (0 for initialized, 1 for processing, 2 for completed, 3 for cancelled)
     * @param customer_ID The ID of the customer who placed the order
     */

    public Order(String product_name, int count, int total_price, int status, int customer_ID) {
        this.product_name = product_name;
        this.count = count;
        this.total_price = total_price;
        this.status = status;
        this.Customer_ID = customer_ID;
    }
    /**
     * Constructs an Order object by copying another Order object.
     * @param o The Order object to copy
     */
    public Order(Order o){
        this.product_name = o.product_name;
        this.count = o.count;
        this.total_price = o.total_price;
        this.status = o.status;
        this.Customer_ID = o.Customer_ID;
    }

    /**
     * Gets the product name of the order.
     * @return The product name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * Gets the count of the product in the order.
     * @return The count of the product
     */

    public int getCount() {
        return count;
    }
    /**
     * Gets the total price of the order.
     * @return The total price
     */
    public int getTotal_price() {
        return total_price;
    }
    /**
     * Gets the status of the order as an integer.
     * @return The status (0 for initialized, 1 for processing, 2 for completed, 3 for cancelled)
     */
    public int getStatus() {
        return status;
    }
    /**
     * Gets the ID of the customer who placed the order.
     * @return The customer ID
     */
    public int getCustomer_ID() {
        return Customer_ID;
    }
    /**
     * Prints the details of the order.
     */
    public void print_order(){
        System.out.print("Product Name: "+this.product_name+" - "+"Count: "+this.count+" - "+"Total Price: "+this.total_price+" - "+"Status: "+this.StatusToString());
    }
    /**
     * Converts the status integer to its corresponding string representation.
     * @return The string representation of the status
     */
    private String StatusToString()  {
        if(this.status==0){
            return "Initialized.\n";
        }
        if(this.status==1){
            return "Processing.\n";
        }
        if(this.status==2){
            return "Completed.\n";
        }
        else if(this.status==3){
            return "Cancelled.\n";
        }
        else{
            return "Not valid status.\n";
        }
    }
}
