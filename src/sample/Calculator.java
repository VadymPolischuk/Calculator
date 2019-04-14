package sample;

public class Calculator {

    double number1;
    double number2;
    boolean isFirstCalculation;
    Operation operation;
    String result;

    public Calculator() {
        this.number1 = 0;
        this.number2 = 0;
        this.isFirstCalculation = true;
        this.operation = Operation.unassigned;
        this.result = "0";


    }

    public void calculate() {
        switch (operation) {
            case plus:
                result = String.valueOf(number1 + number2);
                break;
            case minus:
                result = String.valueOf(number1 - number2);
                break;
            case multiply:
                result = String.valueOf(number1 * number2);
                break;
            case divide:
                result = number2 == 0 ? "Divide by zero" : String.valueOf(number1 / number2);
                break;
            case power:
                result = String.valueOf(Math.pow(number1, number2));
                break;
            case sqrt:
                result = number1 < 0 ? "Not a negative" : String.valueOf(Math.sqrt(number1));
                break;

            default:
                result = "Unassigned function";

        }
        result = result.endsWith("0") ? result.substring(0, result.length() - 2) : result;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public boolean isFirstCalculation() {
        return isFirstCalculation;
    }

    public void setFirstCalculation(boolean firstCalculation) {
        isFirstCalculation = firstCalculation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
