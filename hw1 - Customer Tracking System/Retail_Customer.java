/**
 * The {@link Retail_Customer} class represents a retail customer entity, extending from the {@code Customer} class.
 * It inherits common attributes and methods from the {@link  Customer} class.
 * This class does not introduce any additional attributes or methods.
 */
public class Retail_Customer extends Customer{
    /**
     * Constructs a {@link Retail_Customer} object with the specified parameters.
     *
     * @param id          The unique identifier of the retail customer.
     * @param name        The name of the retail customer.
     * @param surname     The surname of the retail customer.
     * @param adress     The address of the retail customer.
     * @param phone       The phone number of the retail customer.
     * @param operator_id The ID of the operator associated with the retail customer.
     */
    public Retail_Customer(int id,String name, String surname, String adress, String phone, int operator_id) {
        super( id,name, surname, adress, phone, operator_id);
    }
}
