class LazyResource {

    public LazyResource() {
        System.out.println("Heavy resource created.");
    }

    public void use() {
        System.out.println("Using heavy resource.");
    }
}

class LazyResourceManager {

    private LazyResource resource;

    public LazyResource getResource() {

        if (resource == null) {
            System.out.println("Resource not created yet.");
            resource = new LazyResource();
        }

        return resource;
    }
}

public class DesignPatternLazyInitialization {

    public static void main(String[] args) {

        LazyResourceManager manager =
                new LazyResourceManager();

        System.out.println("Application started.");
        System.out.println();

        System.out.println("Requesting resource first time:");

        LazyResource resource1 =
                manager.getResource();

        resource1.use();

        System.out.println();

        System.out.println("Requesting resource second time:");

        LazyResource resource2 =
                manager.getResource();

        resource2.use();

        System.out.println();

        System.out.println(
                "Same object: " + (resource1 == resource2)
        );
    }
}