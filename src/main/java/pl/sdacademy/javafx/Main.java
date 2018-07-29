package pl.sdacademy.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdacademy.javafx.controller.PersonController;
import pl.sdacademy.javafx.model.Person;

import java.io.IOException;

public class Main extends Application {
    private Stage stage;
    private VBox layout;

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public Main(){
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Zenon", "Nowak"));
        personList.add(new Person("Marian", "Iksiński"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
    }
    public ObservableList<Person> getPersonList(){
        return personList;
    }

    public static void main(String[] args) {
        launch();

    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Moja aplikacja w JavaFX");
        loadView();
    }
    public void loadView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/RootView.fxml"));
            layout = (VBox) loader.load();

            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.show();

            PersonController controller = loader.getController();
            controller.setMain(this);

        }
        catch (IOException err){
            err.printStackTrace();
        }

    }
    public void loadPersonEdit(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/PersonEdit.fxml"));
            VBox window = (VBox) loader.load();

            Stage editStage = new Stage();
            editStage.setTitle("edytuj osobę");
            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();
        }
        catch (IOException err){
            err.printStackTrace();
        }
    }
}
