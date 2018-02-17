package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import com.sun.javafx.binding.BindingHelperObserver;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    public void setFirstNameLabel(String firstNameLabel) {
        this.firstNameLabel.setText(firstNameLabel);
    }

    public void setLastNameLabel(String lastNameLabel) {
        this.lastNameLabel.setText(lastNameLabel);
    }

    public void setStreetLabel(Label streetLabel) {
        this.streetLabel = streetLabel;
    }

    public void setPostalCodeLabel(Label postalCodeLabel) {
        this.postalCodeLabel = postalCodeLabel;
    }

    public void setCityLabel(Label cityLabel) {
        this.cityLabel = cityLabel;
    }

    public void setBirthdayLabel(Label birthdayLabel) {
        this.birthdayLabel = birthdayLabel;
    }

    //referencja klasy main
    private Main main;


    public Controller() {
    }


    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(
                data -> data.getValue().firstNameProperty()
        );
        lastNameColumn.setCellValueFactory(
                data -> data.getValue().lastNameProperty()
        );

        personTableView.getSelectionModel().selectedItemProperty().addListener((observable, x, y) -> showPerson(y));
    }

    public void showPerson(Person person) {

        //za pomocą seterow
        setFirstNameLabel("");
        setLastNameLabel("");

        //bez setterów
        streetLabel.setText("");
        postalCodeLabel.setText("");
        cityLabel.setText("");
        birthdayLabel.setText("");

        //za pomocą setterów
        setFirstNameLabel(person.getFirstName());
        setLastNameLabel(person.getLastname());

        //bez setterów
        streetLabel.setText(person.getStreet());
        postalCodeLabel.setText(person.getPostalcode());
        cityLabel.setText(person.getCity());
        birthdayLabel.setText(person.getBirthday());
    }

    public void setMain(Main main) {
        this.main = main;
        personTableView.setItems(main.getPersonObservableList());
    }

}