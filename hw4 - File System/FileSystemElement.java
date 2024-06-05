import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public abstract class FileSystemElement {
    private String name;
    private FileSystemElement parent;
    private Timestamp dateCreated;


    public FileSystemElement(String name, FileSystemElement parent) {
        this.name = name;
        this.parent = parent;
        this.dateCreated = new Timestamp(System.currentTimeMillis()/1000*1000);
    }

    public String getName() {
        return name;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public FileSystemElement getParent() {
        return parent;
    }

    public void setParent(FileSystemElement parent) {
        this.parent = parent;
    }

    public abstract void print(String prefix);
}
