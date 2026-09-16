interface UIAbstractButton {
    void render();
}

interface UIAbstractCheckbox {
    void render();
}

// Windows products
class WindowsButton implements UIAbstractButton {

    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class WindowsCheckbox implements UIAbstractCheckbox {

    @Override
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

// Mac products
class MacButton implements UIAbstractButton {

    @Override
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

class MacCheckbox implements UIAbstractCheckbox {

    @Override
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}

// Abstract Factory
interface UIAbstractFactory {
    UIAbstractButton createButton();

    UIAbstractCheckbox createCheckbox();
}

// Windows Factory
class WindowsUIFactory implements UIAbstractFactory {

    @Override
    public UIAbstractButton createButton() {
        return new WindowsButton();
    }

    @Override
    public UIAbstractCheckbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Mac Factory
class MacUIFactory implements UIAbstractFactory {

    @Override
    public UIAbstractButton createButton() {
        return new MacButton();
    }

    @Override
    public UIAbstractCheckbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class DesignPatternAbstractFactory {

    public static void main(String[] args) {

        UIAbstractFactory windowsFactory =
                new WindowsUIFactory();

        UIAbstractButton windowsButton =
                windowsFactory.createButton();

        UIAbstractCheckbox windowsCheckbox =
                windowsFactory.createCheckbox();

        windowsButton.render();
        windowsCheckbox.render();

        System.out.println();

        UIAbstractFactory macFactory =
                new MacUIFactory();

        UIAbstractButton macButton =
                macFactory.createButton();

        UIAbstractCheckbox macCheckbox =
                macFactory.createCheckbox();

        macButton.render();
        macCheckbox.render();
    }
}