import java.util.Scanner;

public class Main {

    private static FileSystem fs = new FileSystem();
    private static Scanner scanner = new Scanner(System.in);

    private static Directory currentDirectory;

    public static void main(String[] args) {

            currentDirectory = fs.getRoot();

            while(true){
                try {
                    System.out.println("===== File System Management Menu =====");
                    System.out.println("1. Change directory");
                    System.out.println("2. List directory contents");
                    System.out.println("3. Create file");
                    System.out.println("4. Create directory");
                    System.out.println("5. Delete File");
                    System.out.println("6. Delete Directory");
                    System.out.println("7. Move file/directory");
                    System.out.println("8. Search file/directory");
                    System.out.println("9. Print directory tree");
                    System.out.println("10. Sort contents by date");
                    System.out.println("11. Exit");
                    System.out.print("Please select an option: ");

                    int condition = scanner.nextInt();
                    scanner.nextLine();

                    switch (condition){
                        case 1:
                            changeDirectory();
                            break;
                        case 2:
                            listContents();
                            break;
                        case 3:
                            createFile();
                            break;
                        case 4:
                            createDirectory();
                            break;
                        case 5:
                            deleteFile();
                            break;
                        case 6:
                            deleteDirectory();
                            break;
                        case 7:
                            moveElement();
                            break;
                        case 8:
                            search();
                            break;
                        case 9:
                            printDirectoryTree();
                            break;
                        case 10:
                            sortDirectoryByDate();
                            break;
                        case 11:
                            System.exit(1);
                            break;
                    }

                }  catch (Exception exception){
                    scanner.next();
                    System.out.println(exception.getMessage());
                }

            }
    }

    private static void sortDirectoryByDate() {
        fs.sortDirectoryByDate(currentDirectory);
    }

    private static void printDirectoryTree() {
        fs.printDirectoryTree(currentDirectory);
    }

    private static void search(){
        System.out.println("Enter search query: ");
        String query = scanner.nextLine();
        boolean found = fs.search(query);
        System.out.println("Search result: "+(found ? "Found" : "Not Found"));
    }
    private static void moveElement() {
        System.out.println("Enter file/directory name to change: ");
        String name=scanner.nextLine();
        System.out.println("Enter directory path: ");
        String path=scanner.nextLine();
        fs.moveElement(name,fs.changeDirectory(path,currentDirectory),currentDirectory);
    }

    private static void deleteDirectory() {
        System.out.println("Enter directory name to delete: ");
        String name=scanner.nextLine();
        fs.deleteDirectory(name,currentDirectory);
    }

    private static void deleteFile() {
        System.out.println("Enter file name to delete: ");
        String name=scanner.nextLine();
        fs.deleteFile(name,currentDirectory);
    }

    private static void createDirectory() {
        System.out.println("Enter directory name to create: ");
        String name=scanner.nextLine();
        fs.createDirectory(name,currentDirectory);
    }

    private static void changeDirectory(){
        System.out.println("Current directory: "+fs.getCurrentPath(currentDirectory));
        System.out.print("Enter new directory path: ");
        String name=scanner.nextLine();
        Directory path=fs.changeDirectory(name,currentDirectory);
        if(path!=null){
            currentDirectory=path;
            System.out.println("Directory changed to: "+ fs.getCurrentPath(currentDirectory));
        }
    }

    private static void listContents(){
        fs.listContents(currentDirectory);
    }
    private static void createFile(){
        System.out.println("Enter file name to create: ");
        String name=scanner.nextLine();
        fs.createFile(name,currentDirectory);
    }
}