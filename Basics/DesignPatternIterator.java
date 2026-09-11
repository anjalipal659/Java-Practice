import java.util.ArrayList;
import java.util.List;

interface MyIterator<T> {

    boolean hasNext();

    T next();
}

class StudentCollection {

    private List<String> students = new ArrayList<>();

    public void addStudent(String student) {
        students.add(student);
    }

    public MyIterator<String> createIterator() {

        return new MyIterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < students.size();
            }

            @Override
            public String next() {

                if (hasNext()) {
                    return students.get(index++);
                }

                return null;
            }
        };
    }
}

public class DesignPatternIterator {

    public static void main(String[] args) {

        StudentCollection collection =
                new StudentCollection();

        collection.addStudent("Anjali");
        collection.addStudent("Rahul");
        collection.addStudent("Priya");
        collection.addStudent("Aman");

        MyIterator<String> iterator =
                collection.createIterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }
}