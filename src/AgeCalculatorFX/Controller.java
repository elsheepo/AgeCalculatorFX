package AgeCalculatorFX;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    public void clickButton(ActionEvent event) {
        if (isValidDate(inputTxt.getText())) {
            LocalDate dateOfBirth = LocalDate.parse(inputTxt.getText());
            Long age = ChronoUnit.YEARS.between(dateOfBirth, currentDate);
            resultLbl.setText("You are " + age + " years old.");
        } else {
            inputTxt.setText("YYYY-MM-DD");
            resultLbl.setText("Please enter your birthday in the specified format.");
        }
    }

    public void clearTextField(MouseEvent event) {
        inputTxt.setText("");
    }

    public void reset(ActionEvent event) {
        inputTxt.setText("YYYY-MM-DD");
        resultLbl.setText("");
    }

    public void close(ActionEvent event) {
        Platform.exit();
    }


}
