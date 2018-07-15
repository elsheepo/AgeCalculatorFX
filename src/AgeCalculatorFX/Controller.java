package AgeCalculatorFX;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import static AgeCalculatorFX.Validators.isValidDate;

public class Controller implements Initializable {

    @FXML
    public Label label_1;
    public TextField inputTxt;
    public Button calcBtn;
    public Label resultLbl;

    DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    private LocalDate currentDate = LocalDate.now();


    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void clearTextField(MouseEvent event) {
        inputTxt.setText("");
    }

    public void resetOnClick(MouseEvent event) {
        reset();
    }
    public void resetOnReturn(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            reset();
        }
    }

    public void calculateOnReturn(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            calculate();
        }
    }

    public void calculateOnClick(MouseEvent e) {
        calculate();
    }

    private void reset() {
        inputTxt.setText("YYYY-MM-DD");
        resultLbl.setText("");
    }

    private void calculate() {
        if (isValidDate(inputTxt.getText())) {
            LocalDate dateOfBirth = LocalDate.parse(inputTxt.getText());
            Long age = ChronoUnit.YEARS.between(dateOfBirth, currentDate);
            resultLbl.setText("You are " + age + " years old.");
        } else {
            inputTxt.setText("YYYY-MM-DD");
            resultLbl.setText("Please enter your birthday in the specified format.");
        }
    }

    public void close(ActionEvent event) {
        Platform.exit();
    }


}
