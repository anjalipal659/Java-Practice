import java.util.HashMap;
import java.util.Map;

interface Character {

    void display(int row, int column);
}

// Flyweight Object
class CharacterStyle implements Character {

    private String font;
    private int size;

    public CharacterStyle(String font, int size) {
        this.font = font;
        this.size = size;

        System.out.println(
                "Creating CharacterStyle: "
                + font + " - " + size
        );
    }

    @Override
    public void display(int row, int column) {

        System.out.println(
                "Character displayed at ("
                + row + ", " + column + ") "
                + "Font: " + font
                + ", Size: " + size
        );
    }
}

// Flyweight Factory
class CharacterStyleFactory {

    private static Map<String, CharacterStyle> styles =
            new HashMap<>();

    public static CharacterStyle getStyle(
            String font,
            int size) {

        String key = font + "-" + size;

        if (!styles.containsKey(key)) {

            styles.put(
                    key,
                    new CharacterStyle(font, size)
            );
        }

        return styles.get(key);
    }
}

public class DesignPatternFlyweight {

    public static void main(String[] args) {

        CharacterStyle style1 =
                CharacterStyleFactory.getStyle(
                        "Arial", 12
                );

        CharacterStyle style2 =
                CharacterStyleFactory.getStyle(
                        "Arial", 12
                );

        CharacterStyle style3 =
                CharacterStyleFactory.getStyle(
                        "Times New Roman", 14
                );

        style1.display(1, 1);
        style2.display(1, 2);
        style3.display(2, 1);

        System.out.println(
                "\nSame Object: "
                + (style1 == style2)
        );
    }
}