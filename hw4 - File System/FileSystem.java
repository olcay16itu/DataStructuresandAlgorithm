import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;

public class FileSystem {

    private Directory root;

    public FileSystem() {
        this.root = new Directory("root",null);
    }

    public void createDirectory(String name, Directory path ) {
        try{
            FileSystemElement elem;
            if(!searchDirectories(name,root)){
                elem = new Directory(name, path);
                path.addElement(elem);
                System.out.println("Directory created: "+ elem.getName()+"/");
            }
            else {
                System.out.println("Same name exist in this system...");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void createFile(String name,Directory path){
        FileSystemElement elem;
        if(!searchDirectories(name,root)){
            elem = new File(name, path);
            path.addElement(elem);
            System.out.println("File created: "+ elem.getName());
        }
        else {
            System.out.println("Same name exist in this system...");
        }
    }
    public boolean searchDirectories(String name,Directory directory){
        if(name.equals("root")){
            return true;
        }

        // Check if the current directory contains the target name
        for (FileSystemElement element : directory.getChildren()) {
            if (element.getName().equals(name)) {
                return true; // Found the target
            }
        }
        // If not found in the current directory, search recursively in subdirectories
        for (FileSystemElement element : directory.getChildren()) {
            if (element instanceof Directory) {
                if (searchDirectories(name, (Directory) element)) {
                    return true; // Found in a subdirectory
                }
            }
        }
        return false;
    }

    public void moveElement(String name,Directory to,Directory currentDir){
        FileSystemElement element = getElem(name,currentDir);
        if(element!=null){
            element.setParent(to);
            currentDir.removeElement(element);
            to.addElement(element);
            System.out.println("File moved: "+element.getName()+" to "+getCurrentPath(to));
        }
    }
    public void listContents(Directory dir){
        for(FileSystemElement fileSystemElement:dir.getChildren()){
            fileSystemElement.print("");
        }
    }


    public void deleteFile(String name,Directory parent){
        try{
            for(FileSystemElement element:parent.getChildren()){
                if(name.equals(element.getName())){
                    parent.removeElement(element);
                    System.out.println("File deleted: "+element.getName());
                }
            }
        }catch (Exception e){

        }

    }
    public void sortDirectoryByDate(Directory dir){
        Collections.sort(dir.getChildren(), new Comparator<FileSystemElement>() {
            @Override
            public int compare(FileSystemElement o1, FileSystemElement o2) {
                return o1.getDateCreated().compareTo(o2.getDateCreated());
            }
        });
        System.out.println("Sorted contents of "+getCurrentPath(dir)+" by date created:");
        for (FileSystemElement element:dir.getChildren()){
            System.out.print(element.getDateCreated()+" ");
            element.print("");
        }
    }

    public String getCurrentPath(Directory dir){
        String path="";
        while(dir!=null){
            path = "/" + dir.getName() + path;
            dir=(Directory) dir.getParent();
        }
        return path;
    }

    public Directory changeDirectory(String path,Directory dir) {
        try {
            // Check if the path is an absolute path
            if (path.startsWith("/root")) {
                // Absolute path: start navigation from the root directory
                return navigateToDirectory(root, path.substring(1)); // Remove leading "/"
            } else {
                // Relative path: start navigation from the current directory
                return navigateToDirectory(dir, path);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Directory getRoot() {
        return root;
    }
    public void deleteDirectory(String name,Directory directory) {
        Directory directoryToDelete = findDirectory(name, directory);
        if (directoryToDelete != null) {
            deleteDirectoryRecursive(directoryToDelete);
            directory.removeElement(directoryToDelete);
        } else {
            System.out.println("Directory not found.");
        }
    }

    public FileSystemElement getElem(String name,Directory dir){
        for(FileSystemElement element:dir.getChildren()){
            if(name.equals(element.getName())){
                return element;
            }
        }
        return null;
    }

    public boolean search(String name) {
        return searchRecursive(root, name);
    }
    public void printDirectoryTree(Directory dir) {
        System.out.println("Directory Tree:");
        printDirectoryTreeHelper(root, 0,dir);
    }
    private boolean searchRecursive(Directory directory, String name) {
        if(name.equals("root")){
            return true;
        }
        // Check if the current directory contains the target name
        for (FileSystemElement element : directory.getChildren()) {
            if (element.getName().equals(name)) {
                System.out.println(getCurrentPath((Directory) element.getParent())+"/"+element.getName());
                return true; // Found the target
            }
        }
        // If not found in the current directory, search recursively in subdirectories
        for (FileSystemElement element : directory.getChildren()) {
            if (element instanceof Directory) {
                if (searchRecursive((Directory) element, name)) {
                    System.out.println(getCurrentPath((Directory) element.getParent()));
                    return true; // Found in a subdirectory
                }
            }
        }
        // Not found in this directory or its subdirectories
        return false;
    }


    private void printDirectoryTreeHelper(Directory directory, int depth,Directory current) {
        // Print the directory's name with appropriate indentation
        System.out.print(getIndentation(depth));
        System.out.print("*"+directory.getName() + "/");
        if(current==directory){
            System.out.print("(Current Directory)");
        }
        System.out.println("");

        // Print the contents of the directory recursively
        for (FileSystemElement element : directory.getChildren()) {
            if (element instanceof Directory) {
                printDirectoryTreeHelper((Directory) element, depth + 1,current);
            } else {
                System.out.print(getIndentation(depth + 1));
                System.out.println(element.getName());
            }
        }
    }

    private String getIndentation(int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("    "); // Assuming 4 spaces per indentation level
        }
        return indentation.toString();
    }

    private Directory findDirectory(String directoryName, Directory currentDirectory) {
        if (currentDirectory.getName().equals(directoryName)) {
            return currentDirectory;
        }

        for (FileSystemElement element : currentDirectory.getChildren()) {
            if (element instanceof Directory) {
                Directory foundDirectory = findDirectory(directoryName, (Directory) element);
                if (foundDirectory != null) {
                    return foundDirectory;
                }
            }
        }

        return null;
    }

    private void deleteDirectoryRecursive(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            if (child instanceof Directory) {
                deleteDirectoryRecursive((Directory) child);
            } else if (child instanceof File) {
                directory.removeElement(child);
            }
        }
        directory.removeElement(directory);
    }

    private Directory navigateToDirectory(Directory startDir, String path) {
        String[] directories = path.split("/"); // Split the path into directory names
        Directory currentDirectory = startDir; // Start navigation from the specified directory

        // Navigate through the directory structure
        for (String directory : directories) {
            if (directory.isEmpty() || directory.equals(".")) {
                // Ignore empty directory names or "."
                continue;
            } else if (directory.equals("..")) {
                // Move to the parent directory
                currentDirectory = (Directory) currentDirectory.getParent();
            }else {

                // Search for the directory with the specified name among the children
                for (FileSystemElement element : currentDirectory.getChildren()) {
                    if (element instanceof Directory && element.getName().equals(directory)) {
                        // Found the directory, update currentDirectory and continue to the next level
                        currentDirectory = (Directory) element;
                        break;
                    }
                }

            }
        }

        // Return the final directory after navigating through the path
        return currentDirectory;
    }

}
