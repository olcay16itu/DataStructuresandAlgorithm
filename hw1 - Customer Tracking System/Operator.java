/**
 * The {@link Operator} class represents an operator entity, extending from the {@link Person} class.
 * It contains information about the operator such as their wage and associated customers.
 */
public class Operator extends Person{
    /**
     * The wage of the operator.
     */
    private int wage;
    /**
     * An array containing the customers associated with the operator.
     */
    Customer[] customers=new Customer[100];
    /**
     * The count of customers associated with the operator.
     */
    private int customerCount=0;
    /**
     * Constructs an {@link Operator} object with the specified parameters.
     *
     * @param id      The unique identifier of the operator.
     * @param name    The name of the operator.
     * @param surname The surname of the operator.
     * @param adress  The address of the operator.
     * @param phone   The phone number of the operator.
     * @param wage    The wage of the operator.
     */
    public Operator(int id,String name, String surname, String adress, String phone, int wage) {
        super( id,name, surname, adress, phone);
        this.wage = wage;
    }
    /**
     * Retrieves the count of customers associated with the operator.
     *
     * @return The count of customers associated with the operator.
     */
    public int getCustomerCount() {
        return customerCount;
    }
    /**
     * Retrieves the wage of the operator.
     *
     * @return The wage of the operator.
     */
    public int getWage(){
        return wage;
    }
    /**
     * Prints the details of the operator.
     */
    public void print_operator(){
        System.out.println("Name & Surname: "+this.getName()+" "+this.getSurname());
        System.out.println("Address: " + this.getAdress());
        System.out.println("Phone: " + this.getPhone());
        System.out.println("ID: " + this.getId());
        System.out.println("Wage: " + this.getWage());
    }
    /**
     * Prints the customers associated with the operator.
     */
    public void print_customers(){
        int count=1;
        for(Customer c : customers){
            if(c!=null){
                System.out.print("Customer #"+count++);
                System.out.println("( a "+c.getClass().getName()+"): ");
                c.print_customer();
                c.print_orders();
                System.out.println("----------------------------");
            }
        }
        if(count==1){
            System.out.println("This operator doesn't have any customer.");
            System.out.println("----------------------------");
        }
    }
    /**
     * Defines the customers associated with the operator.
     *
     * @param lcustomers An array containing all customers.
     */

    public void define_customers(Customer[] lcustomers){
        for (Customer customer : lcustomers) {
            if (customer != null) {
                if(customer.getOperator_id()==this.getId()) {
                    this.customers[customerCount++]=customer;
                }
            }
        }
    }

}
