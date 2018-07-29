package pl.sdacademy.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.sdacademy.javafx.Main;
import pl.sdacademy.javafx.model.Person;

public class PersonController {

    private Main main;

    @FXML
    private TableView<Person> personTable;
    @FXML
    private Label firstNamelabel;
    @FXML
    private Label lastNamelabel;
    @FXML
    private Label streetlabel;
    @FXML
    private Label citylabel;
    @FXML
    private Label postalCodelabel;
    @FXML
    private Label telephonelabel;

    @FXML
    private TableColumn<Person, String> firstNameCol;
    @FXML
    private TableColumn<Person, String> lastNameCol;

    @FXML
    public void initialize(){
        firstNameCol.setCellValueFactory(cell -> cell.getValue().firstNameProperty());
        lastNameCol.setCellValueFactory(cell -> cell.getValue().lastNameProperty());
    }

    public void setMain(Main main) {
        this.main = main;
        personTable.setItems(this.main.getPersonList());
    }
}
