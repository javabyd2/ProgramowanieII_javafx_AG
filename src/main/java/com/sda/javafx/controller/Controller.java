package com.sda.javafx.controller;

import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

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
    private Label streat;

    @FXML
    private Label city;

    @FXML
    private Label postCode;

    @FXML
    private Label birthday;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println(personTableView);
//        System.out.println(firstNameColumn);
//        System.out.println(lastNameColumn);

    }
}