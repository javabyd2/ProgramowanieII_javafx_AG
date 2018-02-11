package com.sda.javafx;

import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

//    static {
//
//    }

    public Main() {
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Andrzej", "Duda"));
        personObservableList.add(new Person("Adam", "Małysz"));
        personObservableList.add(new Person("Karol", "Kozłowski"));
        personObservableList.add(new Person("Edyta", "Hetman"));
        personObservableList.add(new Person("Sylwia", "Nałęcz"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/RootLayout.fxml"));
        primaryStage.setTitle("Contacts");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}