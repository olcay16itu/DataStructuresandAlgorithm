/**
 * The {@link Person} class is an abstract class representing a person entity.
 * It contains common attributes and methods for a person such as id, name, surname, address, and phone number.
 */
public abstract class Person {
    /**
     * The unique identifier of the person.
     */
    private int id;
    /**
     * The name of the person.
     */
    private String name;
    /**
     * The surname of the person.
     */
    private String surname;
    /**
     * The address of the person.
     */
    private String adress;
    /**
     * The phone number of the person.
     */
    private String phone;
    /**
     * Constructs a {@link Person} object with the specified parameters.
     *
     * @param id      The unique identifier of the person.
     * @param name    The name of the person.
     * @param surname The surname of the person.
     * @param adress The address of the person.
     * @param phone   The phone number of the person.
     */
    public Person(int id,String name, String surname, String adress, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone = phone;
    }
    /**
     * Retrieves the unique identifier of the person.
     *
     * @return The unique identifier of the person.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the unique identifier of the person.
     *
     * @param id The unique identifier of the person.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Retrieves the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the person.
     *
     * @param name The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Retrieves the surname of the person.
     *
     * @return The surname of the person.
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Sets the surname of the person.
     *
     * @param surname The surname of the person.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * Retrieves the address of the person.
     *
     * @return The address of the person.
     */
    public String getAdress() {
        return adress;
    }
    /**
     * Sets the address of the person.
     *
     * @param adress The address of the person.
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }
    /**
     * Retrieves the phone number of the person.
     *
     * @return The phone number of the person.
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Sets the phone number of the person.
     *
     * @param phone The phone number of the person.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
