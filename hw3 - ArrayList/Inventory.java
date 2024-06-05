import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
/**
 * This class represents an inventory management system for electronic devices.
 * It maintains a list of different types of devices and provides functionalities
 * to add, remove, update, and display devices, as well as calculate total inventory value
 * and export inventory reports.
 */
public class Inventory {
    private LinkedList<ArrayList<IDevice>> inventoryList;
    /**
     * Constructs a new Inventory object with an empty inventory list.
     * The inventory list is initialized with slots for different categories of devices.
     */
    public Inventory() {
        inventoryList = new LinkedList<>();
        inventoryList.add(new ArrayList<>()); // TV
        inventoryList.add(new ArrayList<>()); // Smartphones
        inventoryList.add(new ArrayList<>()); // Printer
        inventoryList.add(new ArrayList<>()); // Keyboard
        inventoryList.add(new ArrayList<>()); // Headphones

        inventoryList.get(1).add(new SmartPhone("Samsung S21",600,15));
        inventoryList.get(0).add(new TV("LG OLED55",800,30));
        inventoryList.get(3).add(new Keyboard("Razer Chroma",200,12));
        inventoryList.get(2).add(new Printer("HP Printer",215,24));
        inventoryList.get(4).add(new Headphones("HyperX Cloud2",100,20));
        inventoryList.get(4).add(new Headphones("HyperX Cloud3",200,15));
    }

    /**
     * Adds a new device to the inventory.
     * Time complexity: O(n^2) (worst case)
     *
     * @param device The device to be added.
     * @throws Exception if the device type is unsupported.
     */
    public void addDevice(IDevice device) throws Exception {
        if (device instanceof TV) {
            inventoryList.get(0).add(device);
        } else if (device instanceof SmartPhone) {
            inventoryList.get(1).add(device);
        } else if (device instanceof Printer) {
            inventoryList.get(2).add(device);
        } else if (device instanceof Keyboard) {
            inventoryList.get(3).add(device);
        } else if (device instanceof Headphones) {
            inventoryList.get(4).add(device);
        } else {
            // Handle unsupported device types
            throw new Exception("Unsupported device type");
        }
    }
    /**
     * Removes a device from the inventory based on its name.
     * Time complexity: O(n^2)
     *
     * @param name The name of the device to be removed.
     * @throws Exception if the device cannot be found.
     */
    public void removeDevice(String name) throws Exception {
        for(ArrayList<IDevice> devices:inventoryList){
            for(IDevice item:devices){
                if(item.getName().equals(name)){
                    devices.remove(item);
                    return;
                }
            }
        }
        throw new Exception("Device can not found");
    }

    /**
     * Restocks or reduces the quantity of a device in the inventory based on the condition.
     * Time complexity: O(n^2)
     *
     * @param name      The name of the device.
     * @param quantity  The quantity to be added or removed.
     * @param condition The condition indicating whether to add or remove quantity.
     * @throws Exception if the device cannot be found or the quantity is higher than the stock.
     */
    public void restockingDevice(String name,int quantity,String condition) throws Exception {
        IDevice item = findItem(name);
        if(condition.equals("Add")){
            item.setQuantity(item.getQuantity()+quantity);
            System.out.println(item.getName()+" stock restocked. New quantity:"+item.getQuantity());
            return;
        }
        else if(condition.equals("Remove")) {
            if(item.getQuantity()-quantity>=0){
                item.setQuantity(item.getQuantity()-quantity);
                System.out.println(item.getName()+" stock reduced. New quantity:"+item.getQuantity());
                return;
            }else{
                throw new Exception("Quantity is higher than stock.Check the stock.");
            }
        }
        else {
            throw new Exception("invalid condition");
        }
    }
    /**
     * Updates the quantity and/or price of a device in the inventory.
     * findItem O(n^2) so
     * Time complexity: O(n^2)
     *
     * @param name     The name of the device.
     * @param quantity The new quantity to set.
     * @param price    The new price to set.
     * @throws Exception if the device cannot be found.
     */
    public void updateDevice(String name,int quantity,double price) throws Exception {
        if(!(inventoryList.size()>0)){
            throw new Exception("There is no device.");
        }
        IDevice item = findItem(name);
        item.setPrice(price);
        item.setQuantity(quantity);
        System.out.println( item.getName()+" details updated: Price- "+item.getPrice()+", Quantity- "+ item.getQuantity());
    }
    /**
     * Updates the quantity of a device in the inventory.
     * findItem O(n^2) so
     * Time complexity: O(n^2)
     *
     * @param name     The name of the device.
     * @param quantity The new quantity to set.
     * @throws Exception if the device cannot be found.
     */
    public void updateDevice(String name,int quantity) throws Exception {
        if(!(inventoryList.size()>0)){
            throw new Exception("There is no device.");
        }
        IDevice item = findItem(name);
        item.setQuantity(quantity);
        System.out.println( item.getName()+" details updated: Price- "+item.getPrice()+", Quantity- "+ item.getQuantity());
    }
    /**
     * Updates the price of a device in the inventory.
     * findItem O(n^2) so
     * Time complexity: O(n^2)
     *
     * @param name  The name of the device.
     * @param price The new price to set.
     * @throws Exception if the device cannot be found.
     */
    public void updateDevice(String name,double price) throws Exception {
        if(!(inventoryList.size()>0)){
            throw new Exception("There is no device.");
        }
        IDevice item = findItem(name);
        item.setPrice(price);
        System.out.println( item.getName()+" details updated: Price- "+item.getPrice()+", Quantity- "+ item.getQuantity());
    }
    /**
     * Displays all devices in the inventory.
     * Time complexity: O(n^2)
     *
     * @throws Exception if there are no devices in the inventory.
     */
    public void displayDevices() throws Exception {
        if(!(inventoryList.size()>0)){
            throw new Exception("There is no device.");
        }
        System.out.println("Device List:");
        int i=0;
        for(ArrayList<IDevice> devices:inventoryList){
            for(IDevice item:devices){
                i++;
                System.out.println(i+". "+"Category: "+item.getCategory()+","+"Name: "+item.getName()+","+
                        "Price: "+String.format(Locale.US,"%.2f", item.getPrice())+"$"+","+"Quantity: "+item.getQuantity());
            }
        }
    }
    /**
     * Finds and displays the device with the minimum price in the inventory.
     * Time complexity: O(n^2)
     *
     * @throws Exception if there are no devices in the inventory.
     */
    public void deviceWithMinPrice() throws Exception {
        if(!(inventoryList.size()>0)){
            throw new Exception("There is no device.");
        }
        System.out.println("The cheapest device is:");
        IDevice device =inventoryList.get(0).get(0);
        for(ArrayList<IDevice> devices:inventoryList){
            for(IDevice item:devices){
                if(item.getPrice()<device.getPrice()){
                    device=item;
                }
            }
        }
        System.out.println("Category: "+device.getCategory()+","+"Name: "+device.getName()+","+
                "Price: "+String.format(Locale.US,"%.2f", device.getPrice())+"$"+","+"Quantity: "+device.getQuantity());
    }
    /**
     * Sorts and displays all devices in the inventory by price.
     * Time complexity: O(n^2)
     *
     * @throws Exception if there are no devices in the inventory.
     */
    public void sortDevicesByPrice() throws Exception {
        if(!(inventoryList.size()>0)){
            throw new Exception("There is no device.");
        }
        ArrayList<IDevice> alldevices=new ArrayList<>();
        for(ArrayList<IDevice> devices:inventoryList){
            for(IDevice item:devices){
                    alldevices.add(item);
            }
        }
        sortList(alldevices);
        System.out.println("Devices sorted by price:");
        printDevices(alldevices);
    }
    /**
     * Finds the specified device in the inventory.
     *  Time complexity: O(n^2)
     * @param name The name of the device to find.
     * @return The device with the specified name.
     * @throws Exception if the device cannot be found.

     */
    private IDevice findItem(String name) throws Exception {
        IDevice finalitem ;
        for(ArrayList<IDevice> devices:inventoryList){
            for(IDevice item:devices){
                if(item.getName().equals(name)){
                    finalitem=item;
                    return finalitem;
                }
            }
        }
        throw new Exception("Device can not found.");
    }
    /**
     * Prints the details of devices in the given list.
     *Time complexity: O(n)
     * @param allDevices The list of devices to print.
     */

    private void printDevices(ArrayList<IDevice> allDevices){
        int i=0;
        for(IDevice item:allDevices){
            i++;
            System.out.println(i+". "+"Category: "+item.getCategory()+","+"Name: "+item.getName()+","+
                    "Price: "+String.format(Locale.US,"%.2f",item.getPrice())+"$"+","+"Quantity: "+item.getQuantity());
        }
    }

    /**
     * Calculates the total value of all devices in the inventory.
     * Time complexity: O(n^2)
     *
     * @return The total inventory value.
     */
    public double calculateTotalInventory(){
        double total=0;
        for(ArrayList<IDevice> devices:inventoryList){
            for(IDevice item:devices){
                total+=item.getPrice();
            }
        }
        return total;
    }
    /**
     * Prints the total value of all devices in the inventory.
     * Time complexity: O(n^2) it calls calculate total inventory.
     */
    public void printTotalInventory(){
        System.out.println("Total inventory value: "+String.format("$%,.2f", calculateTotalInventory()));
    }
    /**
     * Exports an inventory report to a text file.
     * Time complexity: O(n^2)
     */
    public void exportInventoryReport(){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Electronics Shop Inventory Report\n");
            myWriter.write("Generated on: "+dateFormat.format(date)+"\n");
            myWriter.write("\n");
            myWriter.write("---------------------------------------"+"\n");
            myWriter.write("| No. | Category | Name" + "|   Price | Quantity |"+"\n");
            myWriter.write("---------------------------------------"+"\n");
            if(!(inventoryList.size()>0)){
                throw new Exception("There is no device.");
            }
            int i=0;
            for(ArrayList<IDevice> devices:inventoryList){
                for(IDevice item:devices){
                    i++;
                    myWriter.write("|  "+i+"  | "+item.getCategory()+"  |"+" "+item.getName()+
                            "   | "+"$"+String.format(Locale.US,"%.2f", item.getPrice())+"   | "+item.getQuantity()+"  |\n");
                }
            }
            myWriter.write("---------------------------------------"+"\n");
            myWriter.write("Summary:"+"\n");
            myWriter.write("-Total Number of Devices :"+numberOfDevices()+"\n");
            myWriter.write("-Total Inventory Value :"+String.format("$%,.2f", calculateTotalInventory())+"\n");
            myWriter.write("\n");
            myWriter.write("End of Report");
            myWriter.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    /**
     * Sorts the given list of devices by price in ascending order.
     *Time complexity: O(n^2) selection sort
     * @param list The list of devices to sort.
     *
     */
    private void sortList(ArrayList<IDevice> list){
        for (int i = 0; i < list.size()-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < list.size(); j++)
                if (list.get(j).getPrice() < list.get(min_idx).getPrice())
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            IDevice temp = list.get(min_idx);
            list.set(min_idx,list.get(i));
            list.set(i,temp);
        }
    }
    /**
     * Calculates the total number of devices in the inventory.
     *Time complexity: O(n)
     * @return The total number of devices.
     */
    private int numberOfDevices(){
        int devicecount=0;
        for(ArrayList<IDevice> devices:inventoryList){
            devicecount+=devices.size();
        }
        return devicecount;
    }
}
