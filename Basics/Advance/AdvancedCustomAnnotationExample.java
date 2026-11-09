
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface PlacementInfo {
    String company();
    String role();
}

class PlacementInterview {

    @PlacementInfo(company = "TCS", role = "Java Developer")
    public void interview() {
        System.out.println("Interview is in progress.");
    }
}

public class AdvancedCustomAnnotationExample {

    public static void main(String[] args) throws Exception {

        Method method =
                PlacementInterview.class.getMethod("interview");

        PlacementInfo info =
                method.getAnnotation(PlacementInfo.class);

        System.out.println("Company: " + info.company());
        System.out.println("Role: " + info.role());

        method.invoke(new PlacementInterview());
    }
}
