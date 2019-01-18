package lk.ijse.dep.library.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReturnManageFormController {


    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField TxtISBN;
    @FXML
    private JFXTextField TxtMemID;
    @FXML
    private JFXTextField Expiredate;
    @FXML
    private JFXTextField ReturnDate;
    @FXML
    private JFXButton BtnReturn;
    @FXML
    private TableView Tblmember;
    @FXML
    private ImageView btnHome;


    public void Save(ActionEvent actionEvent) {
    }

    public void Home(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/DashboardForm.fxml"));
        Scene scene  = new Scene(load);
        Stage mainstage = (Stage)root.getScene().getWindow();
        mainstage.setScene(scene);
    }
}
