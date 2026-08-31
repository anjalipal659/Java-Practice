import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Developer {

    String name();

    String language() default "Java";
}


// Using Annotation
@Developer(name = "Anjali", language = "Java")
class StudentProject {

    void display() {
        System.out.println("Student Project");
    }
}


public class AnnotationsPractice {

    public static void main(String[] args) {

        // 1. Built-in Annotation
        StudentProject project = new StudentProject();

        project.display();


        // 2. Read custom annotation
        Developer developer =
                StudentProject.class
                        .getAnnotation(Developer.class);

        System.out.println("\nDeveloper Information:");

        System.out.println(
                "Name: " + developer.name()
        );

        System.out.println(
                "Language: " + developer.language()
        );
    }
}