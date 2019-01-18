package lk.ijse.dep.library.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BorrowManageFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView btnHome;
    @FXML
    private JFXTextField txtISBN;
    @FXML
    private JFXTextField TxtBookTitle;
    @FXML
    private TableView TblBorrowmange;
    @FXML
    private Label BtnHome;
    @FXML
    private JFXButton BtnAdd;
    @FXML
    private JFXButton Btndelete;
    @FXML
    private JFXTextField txtMemName;
    @FXML
    private JFXTextField txtmemID;
    @FXML
    private JFXDatePicker IssuDate;
    @FXML
    private JFXDatePicker Expirdate;

    public void Home(MouseEvent mouseEvent) throws IOException {

    }

    public void IsbnPress(KeyEvent keyEvent) {
    }

    public void Add(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void memberIdpress(KeyEvent keyEvent) {
    }

    public void Dashboard(MouseEvent mouseEvent) throws IOException {

        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/DashboardForm.fxml"));
        Scene scene  = new Scene(load);
        Stage mainstage = (Stage)root.getScene().getWindow();
        mainstage.setScene(scene);
    }
}
