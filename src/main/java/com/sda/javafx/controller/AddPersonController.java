package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AddPersonController {


    Controller controller = new Controller();
    Main main = new Main();

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
    public void addPersonToList() {
        Person person = new Person(firstName.getText(), lastName.getText());
        person.setStreet(street.getText());
        person.setPostalcode(postalCode.getText());
        person.setCity(city.getText());
        person.setBirthday(birthday.getText());

        main.personObservableList.add(person);




    }
}