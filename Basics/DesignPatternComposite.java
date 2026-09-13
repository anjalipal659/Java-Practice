import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {

    void showDetails();
}

// Leaf
class FileComponent implements FileSystemComponent {

    private String fileName;

    public FileComponent(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + fileName);
    }
}

// Composite
class FolderComponent implements FileSystemComponent {

    private String folderName;

    private List<FileSystemComponent> components =
            new ArrayList<>();

    public FolderComponent(String folderName) {
        this.folderName = folderName;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {

        System.out.println("Folder: " + folderName);

        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

public class DesignPatternComposite {

    public static void main(String[] args) {

        FileComponent file1 =
                new FileComponent("Resume.pdf");

        FileComponent file2 =
                new FileComponent("JavaPractice.java");

        FileComponent file3 =
                new FileComponent("SQLNotes.txt");

        FolderComponent javaFolder =
                new FolderComponent("Java");

        javaFolder.add(file2);

        FolderComponent projectFolder =
                new FolderComponent("Projects");

        projectFolder.add(file1);
        projectFolder.add(file3);
        projectFolder.add(javaFolder);

        projectFolder.showDetails();
    }
}