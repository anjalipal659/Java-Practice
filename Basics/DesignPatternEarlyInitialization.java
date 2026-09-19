class EarlyConfig {

    public EarlyConfig() {
        System.out.println("Configuration object created.");
    }

    public void load() {
        System.out.println("Configuration loaded.");
    }
}

class EarlyConfigManager {

    // Object is created immediately
    private final EarlyConfig config =
            new EarlyConfig();

    public EarlyConfig getConfig() {
        return config;
    }
}

public class DesignPatternEarlyInitialization {

    public static void main(String[] args) {

        System.out.println("Application started.");

        EarlyConfigManager manager =
                new EarlyConfigManager();

        System.out.println("Manager created.");

        EarlyConfig config =
                manager.getConfig();

        config.load();

        EarlyConfig config2 =
                manager.getConfig();

        System.out.println(
                "Same object: " + (config == config2)
        );
    }
}