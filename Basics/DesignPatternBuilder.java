class Student {

    private String name;
    private int age;
    private String course;
    private String city;

    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.course = builder.course;
        this.city = builder.city;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("City: " + city);
    }

    static class StudentBuilder {

        private String name;
        private int age;
        private String course;
        private String city;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

public class DesignPatternBuilder {

    public static void main(String[] args) {

        Student student = new Student.StudentBuilder()
                .setName("Anjali")
                .setAge(21)
                .setCourse("MCA")
                .setCity("Indore")
                .build();

        student.display();
    }
}