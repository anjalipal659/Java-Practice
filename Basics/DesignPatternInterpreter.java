interface Expression {

    boolean interpret(String context);
}

// Terminal Expression
class NumberExpression implements Expression {

    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public boolean interpret(String context) {
        return Integer.parseInt(context) == number;
    }
}

// Non-Terminal Expression
class OrExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public OrExpression(
            Expression expression1,
            Expression expression2) {

        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {

        return expression1.interpret(context)
                || expression2.interpret(context);
    }
}

class AndExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public AndExpression(
            Expression expression1,
            Expression expression2) {

        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {

        return expression1.interpret(context)
                && expression2.interpret(context);
    }
}

public class DesignPatternInterpreter {

    public static void main(String[] args) {

        Expression number5 =
                new NumberExpression(5);

        Expression number10 =
                new NumberExpression(10);

        Expression number5Or10 =
                new OrExpression(number5, number10);

        System.out.println(
                "Is 5 valid? "
                + number5Or10.interpret("5")
        );

        System.out.println(
                "Is 10 valid? "
                + number5Or10.interpret("10")
        );

        System.out.println(
                "Is 20 valid? "
                + number5Or10.interpret("20")
        );
    }
}