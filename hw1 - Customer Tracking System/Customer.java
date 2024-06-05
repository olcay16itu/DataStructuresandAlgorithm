/**
 * The {@link  Customer} class represents a customer entity, extending from the {@link Person} class.
 * It contains information about the customer such as their orders and operator ID.
 */
public class Customer extends Person{
    /**
     * An array containing the orders made by the customer.
     */
    Order[] orders=new Order[100];
    /**
     * The ID of the operator assigned to the customer.
     */
    private int Operator_id;
    /**
     * The count of orders made by the customer.
     */
    private int orderCount=0;
    /**
     * Constructs a {@link Customer} object with the specified parameters.
     *
     * @param id         The unique identifier of the customer.
     * @param name       The name of the customer.
     * @param surname    The surname of the customer.
     * @param adress     The address of the customer.
     * @param phone      The phone number of the customer.
     * @param operator_id The ID of the operator assigned to the customer.
     */
    public Customer( int id,String name, String surname, String adress, String phone, int operator_id) {
        super( id,name, surname, adress, phone);
        this.Operator_id = operator_id;
    }
    /**
     * Retrieves the count of orders made by the customer.
     *
     * @return The count of orders made by the customer.
     */
    public int getOrderCount() {
        return orderCount;
    }
    /**
     * Retrieves the ID of the operator assigned to the customer.
     *
     * @return The ID of the operator assigned to the customer.
     */
    public int getOperator_id() {
        return Operator_id;
    }
    /**
     * Prints the details of the customer.
     */
    public void print_customer(){
        System.out.println("Name & Surname: "+this.getName()+" "+this.getSurname());
        System.out.println("Address: " + this.getAdress());
        System.out.println("Phone: " + this.getPhone());
        System.out.println("ID: " + this.getId());
        System.out.println("Operator ID: " + this.getOperator_id());
    }
    /**
     * Prints the orders made by the customer.
     */
    public void print_orders(){
        int count=1;
        for(Order o:orders){
            if(o!=null){
                System.out.print("Order #"+ count++);
                System.out.print(" => ");
                o.print_order();
            }
        }
        if(count==1){
            System.out.println("This customer doesn't have any order.");
        }
    }
    /**
     * Defines the orders made by the customer.
     *
     * @param lorder An array containing all orders.
     */
    public void define_orders(Order[] lorder){
        for (Order order : lorder) {
            if (order != null) {
                    if(order.getCustomer_ID()==this.getId()) {
                        this.orders[orderCount++]=order;
                    }
            }
        }
    }
}
