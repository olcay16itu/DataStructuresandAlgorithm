import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        try{
            FileService s = new FileService();
            Scanner scanner = new Scanner(System.in);
            s.fileReaderwithExceptionCheck();
            s.matchCustomers();
            s.matchOrders();
            System.out.println("Please enter your ID...");
            int num = scanner.nextInt();
            if(num<0){
                throw new Exception("ID have to be positive");
            }
            else{
                s.findandPrintOperator(num);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);

        }

    }
}