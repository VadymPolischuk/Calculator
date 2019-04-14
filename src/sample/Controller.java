package sample;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField txtData;

    Calculator calculator;
    boolean isSecondNumber = false;

    public Controller() {
        txtData = new TextField();
        calculator = new Calculator();
    }

    public void btnNumberClick(ActionEvent actionEvent) {
        String btnNumber = ((Button) actionEvent.getSource()).getText();
        txtData.setText(txtData.getText().equals("0") || (isSecondNumber) ? btnNumber : txtData.getText() + btnNumber);
        isSecondNumber = false;
        calculator.isFirstCalculation = true;

    }

    public void btnOperationClick(ActionEvent actionEvent) {
        if(calculator.isFirstCalculation) {
            calculator.number1 = Double.parseDouble(txtData.getText());
            switch (((Button) actionEvent.getSource()).getText()) {
                case "+":
                    calculator.operation = Operation.plus;
                    break;
                case "-":
                    calculator.operation = Operation.minus;
                    break;
                case "x":
                    calculator.operation = Operation.multiply;
                    break;
                case "/":
                    calculator.operation = Operation.divide;
                    break;
                case "^":
                    calculator.operation = Operation.power;
                    break;
                case "√":
                    calculator.operation = Operation.sqrt;
                    calculator.calculate();
                    txtData.setText(calculator.result);
                    break;
            }
        }
        else
            calculator.result = "0";
        isSecondNumber = true;
        //txtData.setText("0");
        calculator.isFirstCalculation = true;
    }

    public void btnClearClick(ActionEvent actionEvent) {
        txtData.setText("0");
        calculator.isFirstCalculation = true;
    }

    public void btnResultClick(ActionEvent actionEvent) {
//        if (calculator.isFirstCalculation)
            calculator.number2 = Double.parseDouble(txtData.getText());
        calculator.calculate();
        txtData.setText(calculator.result);
        calculator.isFirstCalculation = false;
        isSecondNumber = false;


    }


    public void btnPointClick(ActionEvent actionEvent) {
        if(!(txtData.getText().contains(".")))
        txtData.setText(txtData.getText() + ".");
        calculator.isFirstCalculation = true;

    }


    public void btnSignClick(ActionEvent actionEvent) {
        txtData.setText("-"+txtData.getText());
    }
}
