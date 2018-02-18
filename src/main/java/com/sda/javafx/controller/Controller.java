package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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

    public TableView<Person> getPersonTableView() {
        return personTableView;
    }

    //referencja klasy main
    private Main main;

    private EditPersonController editPersonController;

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

    @FXML
    public void deletePerson(ActionEvent actionEvent) {
        int index = personTableView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String firstName = personTableView.getItems().get(index).getFirstName();
            String lastName = personTableView.getItems().get(index).getLastname();
            personTableView.getItems().remove(index);
            alert.setTitle("Info");
            alert.setHeaderText("Usunąłeś osobę: ");
            alert.setContentText(firstName + " " + lastName);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Brak pozycji na liście!");
            alert.setContentText("Nie ma co usunąć");
            //alert.showAndWait();
            alert.show();
        }
    }

    public void addPersonWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("AddPerson.fxml"));

        AnchorPane addPersonLayout = loader.load();

        AddPersonController addPersonController = loader.getController();
        addPersonController.setMain(main);

        Stage stage = new Stage();
        Scene scene = new Scene(addPersonLayout);

        stage.setScene(scene);
        stage.show();
    }

    public void edytujPerson(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("EditPerson.fxml"));

        AnchorPane editPersonLayout = loader.load();

        EditPersonController editPersonController = loader.getController();
        editPersonController.setMain(main);
        editPersonController.setController(this);

        Stage stage = new Stage();
        Scene scene = new Scene(editPersonLayout);

        stage.setScene(scene);
        stage.show();

        int index = personTableView.getSelectionModel().getSelectedIndex();

        editPersonController.setFirstName(main.getPersonObservableList().get(index).getFirstName());
        editPersonController.setLastName(main.getPersonObservableList().get(index).getLastname());
        editPersonController.setStreet(main.getPersonObservableList().get(index).getStreet());
        editPersonController.setPostalCode(main.getPersonObservableList().get(index).getPostalcode());
        editPersonController.setCity(main.getPersonObservableList().get(index).getCity());
        editPersonController.setBirthday(main.getPersonObservableList().get(index).getBirthday());



    }

}