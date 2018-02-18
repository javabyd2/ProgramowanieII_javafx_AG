package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPersonController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField street;
    @FXML
    private TextField postalCode;
    @FXML
    private TextField city;
    @FXML
    private TextField birthday;
    @FXML
    private Button okButton;
    @FXML
    private Button closeButton;

    private Main main;
    private Controller controller;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    public void addPersonToList() {
        Person person = new Person(firstName.getText(), lastName.getText());
        person.setStreet(street.getText());
        person.setPostalcode(postalCode.getText());
        person.setCity(city.getText());
        person.setBirthday(birthday.getText());
        main.getPersonObservableList().add(person);

        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    public void handleCloseButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}