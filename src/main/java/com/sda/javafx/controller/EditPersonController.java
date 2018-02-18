package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditPersonController {

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

    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    public void setStreet(String street) {
        this.street.setText(street);
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.setText(postalCode);
    }

    public void setCity(String city) {
        this.city.setText(city);
    }

    public void setBirthday(String birthday) {
        this.birthday.setText(birthday);
    }

    private Main main;
    private Controller controller;
    private Person person;
    private AddPersonController addPersonController;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void editPersonToList(ActionEvent actionEvent) {
        int index = controller.getPersonTableView().getSelectionModel().getSelectedIndex();

        Person person = new Person(firstName.getText(), lastName.getText());
        person.setStreet(street.getText());
        person.setPostalcode(postalCode.getText());
        person.setCity(city.getText());
        person.setBirthday(birthday.getText());
        main.getPersonObservableList().remove(index);
        main.getPersonObservableList().add(index, person);

        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();


    }

    public void handleCloseButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
