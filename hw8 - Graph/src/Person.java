import java.util.*;

/**
 * Represents a person with a name, age, list of hobbies, and a timestamp indicating when the person was created.
 */
public class Person {
    String name;
    int age;
    List<String> hobbies;
    Date timestamp;

    /**
     * Constructs a new Person object with the specified name, age, and list of hobbies.
     * The timestamp is set to the current date and time.
     *
     * @param name    the name of the person
     * @param age     the age of the person
     * @param hobbies the list of hobbies of the person
     */
    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);
        this.timestamp = new Date();
    }

    /**
     * Returns a string representation of the person, including their name, age, and hobbies.
     *
     * @return a string representation of the person
     */
    @Override
    public String toString() {
        return name + " (Age: " + age + ", Hobbies: " + hobbies + ")";
    }
}