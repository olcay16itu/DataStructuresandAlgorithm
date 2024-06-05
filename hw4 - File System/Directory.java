import java.util.LinkedList;

public class Directory extends FileSystemElement{
    private LinkedList<FileSystemElement> children;

    public Directory(String name, FileSystemElement parent) {
        super(name, parent);
        this.children = new LinkedList<>();
    }

    public void addElement(FileSystemElement element){
        children.add(element);
    }

    public void removeElement(FileSystemElement element){
        children.remove(element);
    }

    public LinkedList<FileSystemElement> getChildren() {
        return children;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix+"*"+getName()+"/");
    }



}
