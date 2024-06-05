/**
 * The {@link Corporate_Customer} class represents a corporate customer entity, extending from the {@link Customer} class.
 * It contains additional information specific to corporate customers such as the company name.
 */
public class Corporate_Customer extends Customer{
    /**
     * The name of the company associated with the corporate customer.
     */
    private String company_name;
    /**
     * Constructs a {@link Corporate_Customer} object with the specified parameters.
     *
     * @param id           The unique identifier of the corporate customer.
     * @param name         The name of the corporate customer.
     * @param surname      The surname of the corporate customer.
     * @param adress      The address of the corporate customer.
     * @param phone        The phone number of the corporate customer.
     * @param operator_id  The ID of the operator associated with the corporate customer.
     * @param company_name The name of the company associated with the corporate customer.
     */
    public Corporate_Customer( int id,String name, String surname, String adress, String phone, int operator_id, String company_name) {
        super( id, name, surname, adress, phone, operator_id);
        this.company_name = company_name;
    }
    /**
     * Prints the details of the corporate customer, including the company name.
     */
    public void print_customer(){
        System.out.println("Name & Surname: "+this.getName()+" "+this.getSurname());
        System.out.println("Address: " + this.getAdress());
        System.out.println("Phone: " + this.getPhone());
        System.out.println("ID: " + this.getId());
        System.out.println("Operator ID: " + this.getOperator_id());
        System.out.println("Company name: " + this.company_name);
    }

}
