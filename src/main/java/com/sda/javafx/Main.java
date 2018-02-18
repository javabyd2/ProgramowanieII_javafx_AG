package com.sda.javafx;

import com.sda.javafx.controller.Controller;
import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    public ObservableList<Person> personObservableList = FXCollections.observableArrayList();

//    static {
//
//    }

    public Main() {
        Person person1 = new Person("Jan", "Kowalski");
        person1.setPostalcode("00-123");
        person1.setCity("Warszawa");
        person1.setBirthday("5-12-1956");
        person1.setStreet("Mazowiecka 12");
        personObservableList.add(person1);

        Person person2 = new Person("Andrzej", "Duda");
        person2.setPostalcode("00-020");
        person2.setCity("Warszawa");
        person2.setBirthday("12-02-1934");
        person2.setStreet("Powstańców Warszawy 3");
        personObservableList.add(person2);

        Person person3 = new Person("Adam", "Małysz");
        person3.setPostalcode("00-020");
        person3.setCity("Warszawa");
        person3.setBirthday("12-02-1934");
        person3.setStreet("Powstańców Warszawy 3");
        personObservableList.add(person3);

        personObservableList.add(new Person("Karol", "Kozłowski"));

        personObservableList.add(new Person("Edyta", "Hetman"));

        personObservableList.add(new Person("Sylwia", "Nałęcz"));

        personObservableList.add(new Person("Michał", "Nowa"));

        personObservableList.add(new Person("Agata", "Małolata"));

        personObservableList.add(new Person("Monika", "Budka"));

        personObservableList.add(new Person("Lucyna", "Giełzak"));

        personObservableList.add(new Person("Marek", "Giełzak"));

        personObservableList.add(new Person("Bartosz", "Woicyki"));

        personObservableList.add(new Person("Dionizy", "Wspólny"));
    }


    public ObservableList<Person> getPersonObservableList() {
        return personObservableList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initRootLayout();
        showPersonLayout();
    }

    public void initRootLayout() throws IOException {
        rootLayout = FXMLLoader.load(getClass().getClassLoader().getResource("RootLayout.fxml"));
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showPersonLayout() throws IOException {

        FXMLLoader loader = new FXMLLoader((getClass().getClassLoader().getResource("PersonOverview.fxml")));

        AnchorPane person = loader.load();
        rootLayout.setCenter(person);

        Controller controller = loader.getController();
        controller.setMain(this);
    }

    public static void main(String[] args) {
        launch(args);
    }


}