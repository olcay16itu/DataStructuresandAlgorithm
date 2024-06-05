import java.util.Scanner;
/**
 * This class contains the main method to run the Electronics Inventory Management System.
 * It provides a menu system for users to interact with the inventory functionalities.
 */
public class Main {
    /**
     * The main method to run the program.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Inventory inventory=new Inventory();
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                menuSystemPrint();
                int k = scanner.nextInt();
                selectedProcess(k,inventory);
                System.out.println("---------------------------------------");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    /**
     * Prints the menu system options for the user.
     * O(1)
     */
    public static void menuSystemPrint(){
        System.out.println(" Welcome to the Electronics Inventory Management System!");
        System.out.println(" Please select an option:");
        System.out.println(" 1. Add a new device");
        System.out.println(" 2. Remove a device");
        System.out.println(" 3. Update device details");
        System.out.println(" 4. List all devices");
        System.out.println(" 5. Find the cheapest device");
        System.out.println(" 6. Sort devices by price");
        System.out.println(" 7. Calculate total inventory value");
        System.out.println(" 8. Restock a device");
        System.out.println(" 9. Export inventory report");
        System.out.println(" 0. Exit");
    }
    /**
     * Executes the selected process based on user input.
     *
     * @param k         The selected option.
     * @param inventory The inventory object to perform operations on.
     * @throws Exception if an invalid selection is made.
     * @implNote Time complexity: O(n^2)
     */

    public static void selectedProcess(int k,Inventory inventory) throws Exception {
        if(k<0 && k>9){
            throw new Exception("Unvalid selection.");
        }
        else{
            Scanner scanner = new Scanner(System.in);
            if(k==1){
                System.out.println("Enter category name: ");
                String category_name=scanner.nextLine();
                System.out.println("Enter device name:  ");
                String name = scanner.nextLine();
                System.out.println("Enter price: ");
                String price =scanner.nextLine();
                System.out.println("Enter quantity:");
                String quantity = scanner.nextLine();
                Double doubleprice = Double.parseDouble(price);
                Integer intquantity = Integer.parseInt(quantity);
                if(category_name.equals("Keyboard")){
                    inventory.addDevice(new Keyboard(name,doubleprice,intquantity));
                }
                else if (category_name.equals("TV")){
                    inventory.addDevice(new TV(name,doubleprice,intquantity));
                }
                else if (category_name.equals("SmartPhone")){
                    inventory.addDevice(new SmartPhone(name,doubleprice,intquantity));
                }
                else if (category_name.equals("Printer")){
                    inventory.addDevice(new Printer(name,doubleprice,intquantity));
                }
                else if (category_name.equals("Headphone")){
                    inventory.addDevice(new Headphones(name,doubleprice,intquantity));
                }else{
                    throw new Exception("Category not found.");
                }
            }
            else if(k==2){
                System.out.println("Enter device name to remove: ");
                String name = scanner.nextLine();
                inventory.removeDevice(name);
            }
            else if(k==3){
                System.out.print("Enter the name of the device to update:");
                String name=scanner.nextLine();
                System.out.println("Enter new price (leave blank to keep current price):");
                String price = scanner.nextLine();
                System.out.println("Enter new quantity (leave blank to keep current quantity)");
                String quantity = scanner.nextLine();
                if(quantity.isBlank()&&price.isBlank()){
                    return;
                }
                else if(price.isBlank()){
                    Integer intquantity = Integer.parseInt(quantity);
                    inventory.updateDevice(name,intquantity);
                }
                else if(quantity.isBlank()){
                    Double doubleprice = Double.parseDouble(price);
                    inventory.updateDevice(name,doubleprice);
                }
                else{
                    Integer intquantity = Integer.parseInt(quantity);
                    Double doubleprice = Double.parseDouble(price);
                    inventory.updateDevice(name,intquantity,doubleprice);
                }
            }
            else if(k==4){
                inventory.displayDevices();
            }
            else if(k==5){
                inventory.deviceWithMinPrice();
            }
            else if(k==6){
                inventory.sortDevicesByPrice();
            }
            else if(k==7){
                inventory.printTotalInventory();
            }
            else if(k==8){
                System.out.print("Enter the name of the device to restock:");
                String name=scanner.nextLine();
                System.out.println("Do you want to add or remove stock? (Add/Remove): ");
                String condition = scanner.nextLine();
                System.out.println(" Enter the quantity to add: ");
                int quantity=scanner.nextInt();
                inventory.restockingDevice(name,quantity,condition);
            }
            else if(k==9){
                inventory.exportInventoryReport();
            }
            else if(k==0){
                System.exit(0);
            }
        }
    }


}