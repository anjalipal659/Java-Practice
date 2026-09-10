import java.util.Stack;

// Memento
class TextMemento {

    private String text;

    public TextMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Originator
class TextEditor {

    private String text = "";

    public void write(String text) {
        this.text += text;
    }

    public String getText() {
        return text;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        text = memento.getText();
    }
}

// Caretaker
class EditorHistory {

    private Stack<TextMemento> history = new Stack<>();

    public void save(TextMemento memento) {
        history.push(memento);
    }

    public TextMemento undo() {

        if (!history.isEmpty()) {
            return history.pop();
        }

        return null;
    }
}

public class DesignPatternMemento {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.write("Hello ");
        history.save(editor.save());

        editor.write("Anjali");
        history.save(editor.save());

        System.out.println("Current Text:");
        System.out.println(editor.getText());

        TextMemento previousState = history.undo();
        editor.restore(previousState);

        System.out.println("\nAfter Undo:");
        System.out.println(editor.getText());
    }
}