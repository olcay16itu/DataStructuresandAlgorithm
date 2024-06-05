
import java.io.File;
import java.util.Scanner;
/**
 * The {@link FileService} class handles file reading and exception checking.
 * It reads data from a file, performs validation, and stores the information into appropriate arrays.
 */
public class FileService {
    /** The count of orders read from the file. */
    public int orderCount=0;
    /** The count of operators read from the file. */
    public int operatorCount=0;
    /** The count of customers read from the file. */
    public int customerCount=0;
    /** An array to store orders. */
    public Customer[] customers=new Customer[100];
    /** An array to store operators. */
    public Operator[] operators=new Operator[100];
    /** An array to store customers. */
    public Order[] orders=new Order[100];
    /**
     * Reads data from a file and performs exception checking.
     * The file should be formatted with semicolon-separated values.
     * Each line should represent an order, operator, or customer.
     * Throws exceptions for various error conditions encountered during file reading and validation.
     */
    public void fileReaderwithExceptionCheck(){
        try{
            File myObj = new File("C:\\Users\\PC\\Downloads\\content.txt");
            Scanner reader = new Scanner(myObj);

            while (reader.hasNextLine()){
                String data = reader.nextLine();
                if (data.isEmpty()) {
                    throw new Exception("String is empty.");
                }
                String[] datas = data.split(";");
                if (datas.length < 5) {
                    throw new Exception("Missing column.");
                }
                checkStringlength(datas);
                    if(datas[0].equals("order")){
                        if (datas.length != 6) {
                            throw new Exception("Extra column.");
                        }
                        if(Integer.valueOf(datas[2])>0){
                            orders[orderCount++]= new Order(datas[1],Integer.valueOf(datas[2]),Integer.valueOf(datas[3]),Integer.valueOf(datas[4]),Integer.valueOf(datas[5]));
                        }
                    }
                    else if(datas[0].equals("operator")){
                        if (datas.length != 7) {
                            throw new Exception("Extra column.");
                        }
                        if(contains(operators,Integer.valueOf(datas[5]))){
                            throw new Exception("ID is exist.");
                        }
                        operators[operatorCount++]= new Operator(Integer.valueOf(datas[5]),datas[1],datas[2],datas[3],datas[4],Integer.valueOf(datas[6]));
                    }
                    else if(datas[0].equals("retail_customer")){
                        if (datas.length != 7) {
                            throw new Exception("Extra column.");
                        }
                        if(contains(customers,Integer.valueOf(datas[5]))){
                            throw new Exception("ID is exist.");
                        }
                        customers[customerCount++]= new Retail_Customer(Integer.valueOf(datas[5]),datas[1],datas[2],datas[3],datas[4],Integer.valueOf(datas[6]));
                    }
                    else if(datas[0].equals("corporate_customer")){
                        if (datas.length != 8) {
                            throw new Exception("Extra column.");
                        }
                        if(contains(customers,Integer.valueOf(datas[5]))){
                            throw new Exception("ID is exist.");
                        }
                        customers[customerCount++]= new Corporate_Customer(Integer.valueOf(datas[5]),datas[1],datas[2],datas[3],datas[4],Integer.valueOf(datas[6]),datas[7]);
                    }
                    else {
                        throw new Exception("Unknown identifier: " + datas[0]);
                    }
            }
            reader.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    /**
     * Matches orders with their respective customers.
     */
    public void matchOrders(){
        for(Customer a : customers){
            if(a!=null){
                a.define_orders(orders);
            }
        }
    }
    /**
     * Checks the length of each string in an array.
     * Throws an exception if any string has a length less than 1.
     *
     * @param datas The array of strings to check.
     * @throws Exception If any string length is less than 1.
     */
    public void checkStringlength(String[] datas) throws Exception {
        for(String d:datas){
            if(d.length()<1){
                throw new Exception("String length have to be more than 0");
            }
        }
    }
    /**
     * Matches customers with their respective operators.
     */
    public void matchCustomers(){
        for(Operator o:operators){
            if(o!=null){
                o.define_customers(customers);
            }
        }
    }
    /**
     * Checks if an array contains an element with the specified value.
     * Throws an exception if the value already exists in the array.
     *
     * @param array The array to check.
     * @param value The value to search for.
     * @return {@code true} if the value exists, {@code false} otherwise.
     * @throws Exception If the value already exists in the array.
     */

    private boolean contains(Person[] array, int value) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if(array[i]!=null){
                if (array[i].getId()==value) {
                    throw new Exception("There was a operator/customer with same id...");
                }
            }
        }
        return false;
    }

    /**
     * Finds and prints details of an operator or customer with the specified ID.
     *
     * @param id The ID to search for.
     * @throws Exception If no operator/customer is found with the specified ID.
     */
    public void findandPrintOperator(int id) throws Exception {
        boolean found = false;
        for (Operator o : operators) {
            if (o != null && id == o.getId()) {
                System.out.println("*** Operator Screen ***");
                System.out.println("----------------------------");
                o.print_operator();
                System.out.println("----------------------------");
                o.print_customers();
                found = true;
            }
        }
        for(Customer c:customers){
            if (c != null && id == c.getId()) {
                System.out.println("*** Customer Screen ***");
                System.out.println("----------------------------");
                c.print_customer();
                c.print_orders();
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) {
            throw new Exception("No operator/customer was found with ID "+id+" . Please try again.\n");
        }
    }



}
