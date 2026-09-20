import java.util.HashMap;
import java.util.Map;

class EnvironmentConfig {

    private String environment;

    private EnvironmentConfig(String environment) {
        this.environment = environment;

        System.out.println(
                "Created config for: " + environment
        );
    }

    public void showConfig() {
        System.out.println(
                "Using " + environment + " configuration."
        );
    }

    private static final Map<String, EnvironmentConfig> INSTANCES =
            new HashMap<>();

    public static EnvironmentConfig getInstance(
            String environment) {

        if (!INSTANCES.containsKey(environment)) {

            INSTANCES.put(
                    environment,
                    new EnvironmentConfig(environment)
            );
        }

        return INSTANCES.get(environment);
    }
}

public class DesignPatternMultiton {

    public static void main(String[] args) {

        EnvironmentConfig development =
                EnvironmentConfig.getInstance("DEV");

        EnvironmentConfig testing =
                EnvironmentConfig.getInstance("TEST");

        EnvironmentConfig developmentAgain =
                EnvironmentConfig.getInstance("DEV");

        development.showConfig();
        testing.showConfig();

        System.out.println();

        System.out.println(
                "DEV same object: "
                        + (development == developmentAgain)
        );

        System.out.println(
                "DEV and TEST same object: "
                        + (development == testing)
        );
    }
}